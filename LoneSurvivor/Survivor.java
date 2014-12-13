
public class Survivor {
	
	private Survivor next = null;
	private Survivor prev = null;
	private int num;

	public Survivor(int n) {
		num = n;
	}
	
	public Survivor next() {
		return next;
	}

	public Survivor prev() {
		return prev;
	}
	
	public int num() {
		return num;
	}
	
	public void num(int n) {
		num = n;
	}
	
	public void next(Survivor nxt) {
		next = nxt;
	}

	public void prev(Survivor prv) {
		prev = prv;
	}
}
