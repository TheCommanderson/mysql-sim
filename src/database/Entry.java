package database;
import java.util.Map;
import java.util.TreeMap;

public class Entry {
    public Map<String, String> attr;
    public Entry(Map<String, String> a){
        attr = new TreeMap<>(a);
    }
    @Override
    public String toString(){
        String str = "";
        for(Map.Entry<String, String> m : attr.entrySet()){
            str += "," + m.getValue();
        }
        return str.substring(1);
    }

    public String returnFields(){
        String fields = "";
        for(Map.Entry<String, String> m : attr.entrySet()){
            fields += "," + m.getKey();
        }
        return fields.substring(1);
    }
    public String returnVals(){
        String fields = "";
        for(Map.Entry<String, String> m : attr.entrySet()){
            fields += "," + m.getValue();
        }
        return fields.substring(1);
    }
}
