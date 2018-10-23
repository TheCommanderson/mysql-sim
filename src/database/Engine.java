/*  Sources:
    https://www.w3schools.com/sql
    https://stackoverflow.com
    https://docs.oracle.com
*/

package database;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Engine {
    List<Table> database;
    public Engine(){
        database = new ArrayList<>();
    }
    public static void test(String[] args){

        List<Table> database = new ArrayList<>();
        System.out.println("I am running");

        // === OPEN_CMD ===
        System.out.println("\nTEST OPEN_CMD animals");
        open_cmd(database, "animals");
        System.out.println("Num tables (should be 1): " + database.size());
        System.out.println("\nTEST OPEN_CMD NO FILE");
        open_cmd(database, "fakefile");
        System.out.println("Num tables (should be 1): " + database.size());

        // === SHOW_CMD ===
        System.out.println("\nTEST SHOW_CMD");
        show_cmd(database.get(0));

        // === select ===
        System.out.println("\nTEST SELECT (age > 7)");
        show_cmd(select(database.get(0), "age > 7"));

        // === project ===
        System.out.println("\nTEST PROJECT (name, age)");
        String[] proj_args = {"name", "age"};
        show_cmd(project(database.get(0), proj_args));

        // === rename ===
        System.out.println("\nTEST RENAME (renamed animals)");
        show_cmd(rename(database.get(0), "renamed animals"));

        // === union ===
        String[] age = {"age"};
        String[] name = {"name"};
        System.out.println("\nTEST UNION (project animals (name) + project animals (age))");
        show_cmd(union(project(database.get(0), name),project(database.get(0), age)));

        // === difference ===
        System.out.println("\nTEST DIFFERENCE (project animals (name, age) - project animals (age))");
        show_cmd(difference(project(database.get(0), proj_args), project(database.get(0), age)));

        // === product === FIXME
        System.out.println("\nTEST PRODUCT (FIXME)");

        // === CREATE_CMD ===
        List<String> attr_list = new ArrayList<>();
        attr_list.add("attribute 1");
        attr_list.add("attribute 2");
        attr_list.add("attribute 3");
        System.out.println("\nTEST CREATE_CMD");
        create_cmd(database, "create_test", attr_list, "attribute 1");
        System.out.println("Num tables (should be 2): " + database.size());
        if(database.size() > 1){
            show_cmd(database.get(1));
        }

        // === UPDATE_CMD ===
        System.out.println("\nTEST UPDATE_CMD");
        update_cmd(database, "animals", "name = nowacatto,type = cat", "type == dog");
        show_cmd(database.get(0));

        // === DELETE_CMD ===
        System.out.println("\nTEST DELETE_CMD (age == 12)");
        delete_cmd(database, "animals", "age == 12");
        show_cmd(database.get(0));

        // === INSERT_CMD ===
        Map<String, String> insert_map = new TreeMap<>();
        insert_map.put("age", "12");
        insert_map.put("name", "cynthia");
        insert_map.put("type", "black cat");
        Entry new_entry = new Entry(insert_map);
        System.out.println("\nTEST INSERT_CMD (cynthia the black cat)");
        insert_cmd(database, "animals", new_entry);
        show_cmd(database.get(0));

        // ===   CLOSE_CMD   ===
        // === and WRITE_CMD ===
        System.out.println("\nTEST CLOSE_CMD animals");
        close_cmd(database, database.get(0)); // Calling close_cmd itself calls write_cmd for "autosave" functionality
        System.out.println("Num tables (should be 1): " + database.size());
        return;
    }


    //selection, projection, renaming, union, difference, product
    //
    public static Table select(Table t, String condition){
        Table result = new Table(t.table_name, new ArrayList<>(), t.primary_key);
        for(int i=0; i<t.entries.size();i++){
           if(condIsMet(condition,t.entries.get(i))){
               result.entries.add(t.entries.get(i));
           }
        }
        return result;
    }
    public static Table project(Table t, String[] s){
        Map<String, String> tmp_map = new TreeMap<>();
        Table result = new Table();
        result.table_name = t.table_name;
        result.primary_key = t.primary_key;
        boolean is_attribute;
        for(String att : s){
            is_attribute = false;
            for (String a : t.attributes) {
                if (a.equals(att)) {
                    result.attributes.add(a);
                    is_attribute = true;
                    break;
                }
            }
            if(!is_attribute){
                System.out.println("Attribute " + att + " is not in the table");
                return new Table();
            }
        }
        for(Entry e : t.entries){
            for(String att : result.attributes){
                tmp_map.put(att, e.attr.get(att));
            }
            result.entries.add(new Entry(tmp_map));
        }
        return result;
    }
    public static Table rename(Table t, String new_S){
        Table result= new Table(t);
        result.table_name = new_S;
        return result;
    }
    public static Table union(Table t, Table s){
        List<String> tmp_list = new ArrayList<>();
        boolean in_list, is_attribute;
        Map<String, String> tmp_map = new TreeMap<>();
        for (String t_attr:t.attributes){
            tmp_list.add(t_attr);

        }
        for(String s_attr : s.attributes) {
            in_list = false;
            for(String attrs : tmp_list){
                if(s_attr.equals(attrs)){
                    in_list = true;
                    break;
                }
            }
            if(!in_list){
                tmp_list.add(s_attr);
            }
        }
        Table result = new Table(t.table_name + " + " + s.table_name, tmp_list, t.primary_key);
        for(int i = 0; i < t.entries.size(); ++i) {
            for (String att : result.attributes) {
                is_attribute = false;
                for (String a : t.attributes) {
                    if (a.equals(att)) {
                        is_attribute = true;
                        break;
                    }
                }
                if (is_attribute) {
                    tmp_map.put(att, t.entries.get(i).attr.get(att));
                }
                else{
                    tmp_map.put(att, s.entries.get(i).attr.get(att));
                }
            }
            result.entries.add(new Entry(tmp_map));
        }
        return result;
    }
    public static Table difference(Table t, Table s){
        //This is for t-s
        List<String> tmp_list = new ArrayList<>();
        boolean same_att;
        for(String t_attr : t.attributes){
            same_att = false;
            for(String s_attr : s.attributes){
                if(s_attr.equals(t_attr)){
                    same_att = true;
                    break;
                }
            }
            if(!same_att){
                tmp_list.add(t_attr);
            }
        }
        if(tmp_list.isEmpty()){
            return new Table();
        }
        Table result = new Table(t);
        return project(result, tmp_list.toArray(new String[0]));
    }
    public static Table product(Table t, Table s){
        //Cross product of A*B
        Table result=t;
        for (String i: s.attributes){
            result.attributes.add(i);
        }
        for (Entry p: s.entries) {
            result.entries.add(p);
        }
        return result;

    }
    public static void open_cmd(List<Table> tables, String table_name){
        try{
            boolean is_table = false;
            List<String> tmp_list = new ArrayList<>();
            String tmp_string = "";
            Map<String, String> tmp_map = new TreeMap<>();
            File f = new File(table_name + ".db");
            if(f.exists()) {
                // Set up scanner
                Scanner scanner = new Scanner(f);
                scanner.useDelimiter("(\\s*,\\s*|\\n)");
                for (Table t : tables) {
                    if (t.table_name.equals(table_name)) {
                        is_table = true;
                        break;
                    }
                }
                if(is_table){
                    System.out.println(table_name + " is already open");
                    return;
                }
                Table tmp_table = new Table(table_name, tmp_list, "");
                if(scanner.hasNext()){
                    tmp_string = scanner.nextLine();
                    String[] attributes = tmp_string.split(",");
                    tmp_table.primary_key = attributes[0];
                    for(String s : attributes){
                        tmp_list.add(s);
                    }
                }
                tmp_table.attributes = new ArrayList<>(tmp_list.subList(1, tmp_list.size()));
                tmp_list.clear();
                while(scanner.hasNext()){
                    tmp_string = scanner.nextLine();
                    String[] tmp_strs = tmp_string.split(",");
                    for(int i = 0; i < tmp_strs.length; ++i){
                        tmp_string = tmp_strs[i];
                        tmp_map.put(tmp_table.attributes.get(i), tmp_string);
                    }
                    tmp_table.entries.add(new Entry(tmp_map));
                }
                tables.add(new Table(tmp_table));
            }
            else{
                System.out.println(table_name + " is not a table in this database");
                return;
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public static void close_cmd(List<Table> tables, Table t){
        tables.remove(t);
        return;
    }
    public static void write_cmd(List<Table> tables, String table_name){
        try {
            Table tmp_table = null;
            boolean is_table = false;
            File f = new File(table_name + ".db");
            PrintWriter writer = new PrintWriter(f);
            for(Table t : tables){
                if(t.table_name.equals(table_name)) {
                    tmp_table = new Table(t);
                    is_table = true;
                    break;
                }
            }
            if(!is_table){
                System.out.println(table_name + " is not a table");
                return;
            }
            else {
                writer.write(tmp_table.primary_key + ",");
                for(String a : tmp_table.attributes){
                    writer.write(a);
                    if(!(tmp_table.attributes.get(tmp_table.attributes.size()-1).equals(a))){
                        writer.write(",");
                    }

                }
                writer.print("\n");
                for (Entry e : tmp_table.entries) {
                    writer.write(e.returnVals());
                    writer.write("\n");
                }
            }
            writer.close();
            return;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void show_cmd(Table t){
        t.print();
        System.out.println();
        return;
    }
    public static Table create_cmd(List<Table> tables, String table_name, List<String> attributes, String pk){
        Table table = new Table(table_name, attributes, pk);
        tables.add(table);
        return table;
    }
    public static void update_cmd(List<Table> tables, String table_name, String updates, String condition){
        Table tmp_table = new Table();
        String left = "", right = "";
        boolean is_table = false;
        for(Table t : tables){
            if(t.table_name.equals(table_name)){
                tmp_table = t;
                is_table = true;
                break;
            }
        }
        if(!is_table){
            System.out.println(table_name + " is not a table");
            return;
        }
        else {
            String[] update_list = updates.split(",");
            for(Entry e : tmp_table.entries){
                if(condIsMet(condition, e)){
                    for(String u : update_list){
                        String[] u_split = u.split("\\s+");
                        if(u_split.length == 3){
                            left = u_split[0];
                            right = u_split[2];
                        }
                        for(Map.Entry<String, String> m: e.attr.entrySet()){
                            if(m.getKey().equals(left)){
                                m.setValue(right);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return;
    }
    public static void insert_cmd(List<Table> tables, String table_name, Entry e){
        Table tmp_table = new Table();
        boolean is_table = false;
        for(Table t : tables){
            if(t.table_name.equals(table_name)){
                tmp_table = t;
                is_table = true;
                break;
            }
        }
        if(!is_table){
            return;
        }
        else {
            tmp_table.entries.add(e);
            return;
        }
    }
    public static void insert_cmd(List<Table> tables, String table_name, Table old_table){
        Table _table = new Table();
        boolean is_table = false;
        for(Table t : tables){
            if(t.table_name.equals(table_name)){
                _table = t;
                is_table = true;
                break;
            }
        }
        if(!is_table){
            return;
        }
        else{
            int m = 0;
            for(Entry e : old_table.entries){
                if(m % 2 == 0) {
                    _table.entries.add(e);
                }
                ++m;
            }
        }
    }
    public static void delete_cmd(List<Table> tables, String table_name, String condition){
        Table tmp_table = new Table();
        boolean is_table = false;
        for(Table t : tables){
            if(t.table_name.equals(table_name)){
                tmp_table = t;
                is_table = true;
                break;
            }
        }
        if(!is_table){
            System.out.println(table_name + " is not a table");
            return;
        }
        else {
            for(int i = 0; i < tmp_table.entries.size(); ++i){
                if(condIsMet(condition, tmp_table.entries.get(i))){
                    tmp_table.entries.remove(i);
                }
            }
            return;
        }
    }
    public static void exit_cmd(){
      System.exit(0);
    }

    public static boolean condIsMet(String cond, Entry e){
        //Parse condition
        String[] conditions = cond.split("(\\s*\\|\\|\\s*|\\s*&&\\s*)");
        String left, op, right, value;
        Double d_val = 0.0, d_right = 0.0;
        for(String s : conditions){
            String[] tmp_cond = s.split("\\s+");
            if(tmp_cond.length == 3){
                left = tmp_cond[0];
                op = tmp_cond[1];
                right = tmp_cond[2];
            }
            else{
                System.out.println("improper condition statement" + s);
                return false;
            }
            value = "";
            for(Map.Entry<String, String> m : e.attr.entrySet()){
                if (m.getKey().equals(left)){
                    value = m.getValue();
                    break;
                }
            }
            if(value == ""){
                return false;
            }
            switch(op){
                case "==":
                    if(!(value.equals(right))){
                        return false;
                    }
                    break;
                case "!=":
                    if(value.equals(right)){
                        return false;
                    }
                    break;
                case "<":
                    d_val = Double.parseDouble(value);
                    d_right = Double.parseDouble(right);
                    if(d_val >= d_right){
                        return false;
                    }
                    break;
                case ">":
                    d_val = Double.parseDouble(value);
                    d_right = Double.parseDouble(right);
                    if(d_val <= d_right){
                        return false;
                    }
                    break;
                case "<=":
                    d_val = Double.parseDouble(value);
                    d_right = Double.parseDouble(right);
                    if(d_val > d_right){
                        return false;
                    }
                    break;
                case ">=":
                    d_val = Double.parseDouble(value);
                    d_right = Double.parseDouble(right);
                    if(d_val < d_right){
                        return false;
                    }
                    break;
                default:
                    System.out.println("Improper operator");
                    return false;
            }

        }
        return true;
    }
}
