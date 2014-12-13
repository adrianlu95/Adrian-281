import java.util.Iterator;

public class CircularList implements Iterable {

	private int size;
	private Survivor root;
	
	public CircularList(int n) {
		size(n);
		root(new Survivor(1));
		Survivor last = root();
		for(int num = 1; num < size(); num++) {
			Survivor surv = new Survivor(num);
			if(num==(size()-1)) {
				root().prev(surv);
				surv.next(root());
			}
			surv.prev(last);
			last.next(surv);
			last = surv;
		}
	}
	
	public int size() {
		return size;
	}
	
	public void size(int n) {
		size = n;
	}
	
	public void root(Survivor surv) {
		root = surv;
	}
	
	public Survivor root() {
		return root;
	}
	
	public Iterator iterator() {
		return new Iterator() {
			Survivor curr = root();
			public boolean hasNext() {
				return true; // Its impossible for it not to since circular
			}
			public Object next() {
				curr = curr.next();
				return curr;
			}
			public void remove() {
				curr.next().prev(curr.prev());
				curr.prev().next(curr.next());
				curr = curr.next();
				size--;
			}	
		};
	}
}
