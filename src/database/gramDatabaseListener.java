package database;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.exit;

public class gramDatabaseListener extends gramBaseListener{
    Table tmp_table, left;
    int table_id;
    boolean union, diff, product;
    public gramDatabaseListener(){
        engine = new Engine();
    }
    private Engine engine;

    /*
     * TO IMPLEMENT
     * query
     * select
     * project
     * rename
     * union
     * difference
     * open_cmd
     * show_cmd
     * create_cmd
     * close_cmd
     * write_cmd
     * delete_cmd
     * insert_cmd
     * update_cmd
     * exit_cmd
     */
    public void enterExpr(gramParser.ExprContext ctx){
        String command_name = ctx.getStart().getText();
        String condition, attr_list, new_name;
        int i = 1;
        while(ctx.getChild(i).getText().matches(".*\\w.*")){
            ++i;
        }
        switch(command_name){
            case "SELECT":
                condition = ctx.getChild(i+1).getText();
                tmp_table = engine.select(tmp_table, condition);
                break;
            case "PROJECT":
                tmp_table.attributes = engine.database.get(table_id).attributes;
                attr_list = ctx.getChild(i+1).getText();
                if(attr_list.trim().length() < 1){
                    break;
                }
                String[] tmp_strArr = {attr_list};
                if(attr_list.contains(",")){
                    attr_list = attr_list.trim();
                    tmp_strArr = attr_list.split(",");
                }
                tmp_table = engine.project(tmp_table, tmp_strArr);
                break;
            case "RENAME":
                new_name = ctx.getChild(i+1).getText();
                tmp_table = engine.rename(tmp_table, new_name);
                break;
            case "+":
                left = new Table(tmp_table);
                tmp_table = engine.database.get(table_id);
                union = true;
                break;
            case "-":
                left = new Table(tmp_table);
                tmp_table = engine.database.get(table_id);
                diff = true;
                break;
            case "*":
                left = new Table(tmp_table);
                tmp_table = engine.database.get(table_id);
                product = true;
                break;
            default:
                break;
        }
    }
    public void exitExpr(gramParser.ExprContext ctx){
        if(union){
            tmp_table = engine.union(left, tmp_table);
        }
        if(diff){
            tmp_table = engine.difference(left, tmp_table);
        }
        if(product){
            tmp_table = engine.product(left, tmp_table);
        }
        union = diff = product = false;
    }
    public void enterQuery(gramParser.QueryContext ctx){
        String table_name = ctx.getChild(0).getText();
        for(int i = 0; i < engine.database.size(); ++i){
            if(engine.database.get(i).table_name.equals(table_name)){
                table_id = i;
                tmp_table = engine.database.get(i);
                break;
            }
        }
    }
    public void exitQuery(gramParser.QueryContext ctx){
        engine.show_cmd(tmp_table);
        tmp_table = new Table();
    }
    public void enterShow_cmd(gramParser.Show_cmdContext ctx){
        for(Table t : engine.database){
            if(t.table_name.equals(ctx.getChild(2).getText())){
                engine.show_cmd(t);
            }
        }
    }
    //Done
    public void enterOpen_cmd(gramParser.Open_cmdContext ctx){
        String name=ctx.getChild(2).getText();
        engine.open_cmd(engine.database,name);
    }
    public void enterCreate_cmd(gramParser.Create_cmdContext ctx){
        int size = ctx.getChildCount();
        List<String> attr=new ArrayList<>();
        String tablename = ctx.getChild(2).getText();
        String pk = ctx.getChild(size-1).getText();
        int attr_size= ctx.getChild(4).getChildCount();
        for(int i=0; i<attr_size;i++){
            String test = ctx.getChild(4).getChild(i).getText();
            if((!test.equals(" "))&&(!test.equals(","))) {
                if(test.indexOf("VARCHAR")==-1){
                    attr.add(test);
                }
            }
        }
        engine.create_cmd(engine.database,tablename,attr,pk);
    }
    //Need to test
    public void enterClose_cmd(gramParser.Close_cmdContext ctx){
        Table t = new Table();
        t.table_name=ctx.getChild(2).getText();
        engine.close_cmd(engine.database,t);
    }
    public void enterWrite_cmd(gramParser.Write_cmdContext ctx) {
        String tablename =  ctx.getChild(2).getText();
        engine.write_cmd(engine.database,tablename);
    }
    public void enterDelete_cmd(gramParser.Delete_cmdContext ctx){
        String tablename=ctx.getChild(2).getText();
        String condition=ctx.getChild(6).getText();
        engine.delete_cmd(engine.database,tablename,condition);
    }
    public void enterUpdate_cmd(gramParser.Update_cmdContext ctx){
        int size= ctx.getChildCount();
        String tablename = ctx.getChild(2).getText();
        String updates ="";
        for (int i=6; i<size-4;i++){
            String test=ctx.getChild(i).getText();
            updates= updates+test;
        }
        String condition = ctx.getChild(size-1).getText();
        engine.update_cmd(engine.database,tablename,updates,condition);
    }
    public void enterInsert_cmd(gramParser.Insert_cmdContext ctx){
        String temp = ctx.getText();
        String tablename=ctx.getChild(2).getText();
        List<String> attr = new ArrayList<>();
        for (Table t:engine.database){
            if(t.table_name.equals(tablename)) {
                tmp_table=new Table(t);
                if (t.attributes.size() != 0) {
                    attr = t.attributes;
                }
            }
        }
        if(!temp.contains("RELATION")){

            int size= ctx.getChildCount();

            Map<String,String> insert_map = new TreeMap<>();
            int c = 0;
            for(int i=5; i<size;i++){
                String test = ctx.getChild(i).getText();
                if((!test.equals(" "))&&(!test.equals(","))){
                    String attri=attr.get(c);
                    insert_map.put(attri,test);
                    c++;
                }
            }
            Entry e=new Entry(insert_map);
            engine.insert_cmd(engine.database,tablename,e);
        }
    }
    public void enterExit_cmd(gramParser.Exit_cmdContext ctx){

        engine.exit_cmd();
    }
    public void exitInsert_cmd(gramParser.Insert_cmdContext ctx){
        String tablename=ctx.getChild(2).getText();
        if(ctx.getText().contains("RELATION")) {
            engine.insert_cmd(engine.database, tablename, tmp_table);
        }
    }
}