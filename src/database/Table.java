package database;
import java.util.ArrayList;
import java.util.List;

public class Table{
    public String table_name;
    public List<String> attributes;
    public List<Entry> entries;
    public String primary_key;

    public Table (){
        table_name=new String();
        attributes = new ArrayList<>();
        entries = new ArrayList<>();
        primary_key = null;

    }
    public Table(Table t){
        table_name = t.table_name;
        attributes = new ArrayList<>(t.attributes);
        entries = new ArrayList<>(t.entries);
        primary_key = t.primary_key;
    }
    public Table(String tn, List<String> a, String pk) {
        table_name = tn;
        attributes = new ArrayList<>(a);
        entries = new ArrayList<>();
        if(attributes.contains(pk)){
            primary_key = pk;
        }
        else if(!attributes.isEmpty()){
            primary_key = attributes.get(0);
        }
        else{
            primary_key = null;
        }
    }

    public void print(){
        System.out.println("table: " + table_name);
        if(entries.isEmpty()) {
            for(String a : attributes) {
                System.out.print(a + ",\t");
            }
        }
        else{
            for(String s : entries.get(0).attr.keySet()){
                System.out.print(s + ",\t");
            }
        }
        System.out.print("\n");
        for(Entry e : entries){
            System.out.println(e);
        }
        return;
    }
}
