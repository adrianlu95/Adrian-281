import java.util.ArrayList;

public class StringBag implements SimpleCollection {

    private ArrayList <String> sack;

    public StringBag () {
        sack = new ArrayList<String>();
    }

    public StringBag (String initial) {
        sack = new ArrayList<String>();
        sack.add(initial);
    }

    public StringBag (String[] initial) {
        sack = new ArrayList<String>();
        for (int i = 0; i < initial.length; i++){
            sack.add(initial[i]);
        }
    }

    public boolean add ( Object lonelyString ){
        if (lonelyString instanceof String) {
            sack.add((String) lonelyString);
            return true;
        }
        return false;
    }
    
    public void clear(){
        sack = new ArrayList<String>();
    }

    public boolean contains ( Object lonelyString ){
        if (lonelyString instanceof String) {
            return sack.contains((String) lonelyString);
        }
        return false;
    }
    
    public boolean isEmpty(){
        return sack.isEmpty();
    }
    
    public boolean remove ( Object lonelyString ){
        if (lonelyString instanceof String) {
            return sack.remove((String) lonelyString);
        }
        return false;
    }
    
    public int size(){
        return sack.size();
    }

    public Object[] toArray(){
        return sack.toArray();
    }
}