package rushhour.afit.edu;

import java.util.HashSet;

@SuppressWarnings("serial")
public class MyHashSet extends HashSet<Board> {

	public boolean contains(Board b) {
		//System.out.println("Using MyHashSet contains()");
		for (Board board : this) {
			if(board.equals(b)) {
				return true;
			}
		}
		return false;
	}
}
