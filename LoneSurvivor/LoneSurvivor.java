import java.util.Iterator;

public class LoneSurvivor {

	public static void main(String[] args) {
		if(args.length != 2) {
			throw new IllegalArgumentException("Exactly 2 integers must be given");
		}
		int people, moves = 0;
		try {
			people = Integer.parseInt(args[0]);
			moves = Integer.parseInt(args[1]);
		} catch(Exception e) {
			throw new IllegalArgumentException("You have to give 2 ints");
		}
		if(!(people > 1 && moves > 0)) {
			throw new IllegalArgumentException("Your integers aren't in the right range");
		}
		CircularList table = new CircularList(people);
		Iterator it = table.iterator();
		while(table.size() > 1) {
			for(int i = 0; i < moves; i++) {
				it.next();
			}
			it.remove();
		}
		System.out.println(((Survivor)it.next()).num());
	}

}
