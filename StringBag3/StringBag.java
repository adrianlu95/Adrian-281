public class StringBag extends java.util.ArrayList implements SimpleCollection{

    public StringBag () {
        super();
    }

    public StringBag (String initial) {
        super();
        super.add(initial);
    }

    public StringBag (String[] initial) {
        super();
        for (int i = 0; i < initial.length; i++){
            super.add(initial[i]);
        }
    }

    public boolean add (Object lonelyString){
        return super.add(lonelyString);
    }
    
    public void clear(){
        super.clear();
    }

    public boolean contains (Object lonelyString){
        return super.contains(lonelyString);
    }
    
    public boolean isEmpty(){
        return super.isEmpty();
    }
    
    public boolean remove (Object lonelyString){
        return super.remove(lonelyString);
    }
    
    public int size(){
        return super.size();
    }

    public Object[] toArray(){
        return super.toArray();
    }
}