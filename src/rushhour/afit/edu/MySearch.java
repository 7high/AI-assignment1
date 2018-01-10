package rushhour.afit.edu;

import java.util.HashSet;
import java.util.LinkedList;

public class MySearch implements Search{
	public LinkedList<Board>frontier;
	public HashSet<Board>explored;
	int count;
	
	public MySearch(Board board) {
		this.frontier = new LinkedList<Board>();
		frontier.add(board);
		
		this.explored = new HashSet<Board>();		
		this.count = 0;
	}

	@Override
	public Move findMoves() {	
		Board b = frontier.peek();		
		if (goalTest(b)) {return b.move_list;}		
		
		while(!frontier.isEmpty()) {
			b = frontier.remove();
			explored.add(b);		
			
			Move m = b.genMoves(); //m has a pointer to the next move
			//printGenMove(m);
			
			if (m != null) { //the last move in a Move list is null
				carLocation(b);
				b.makeMove(m);
				carLocation(b);				
				count++;				
				
				if (goalTest(b)) {
					System.out.println("Found solution");
					return b.move_list;					
				}
				
				if ((!explored.contains(b)) && (!frontier.contains(b))) {//add only if the board is unexplored and not currently in frontier
					frontier.add(b);					
				}				
				m = m.next;
			}			
		}
		System.out.println("No solution found");
		return null;
	}

	@Override
	public long nodeCount() {
		// TODO Auto-generated method stub
		return count;
	}
	
	public boolean goalTest(Board board) {		
		Piece myCar= board.piece_list[board.findPiece("X0")];
		
		if ((myCar.x == Board.BOARD_INDEX) && (myCar.y == Board.BOARD_EXIT_Y)) {
			return true;
		}
		
		return false;
	}
	
	public void printGenMove(Move m) {
		while(m !=null) {
			System.out.println(m);
			m = m.next;
		}
	}
	
	public void printMoveList(Board b) {
		Move m = b.move_list;
		while(m !=null) {
			System.out.println(m);
			m = m.next;
		}
	}
	
	public void carLocation(Board b) {
		Piece myCar = b.piece_list[b.findPiece("X0")];
		System.out.println("MyCar(" + myCar.x + ", " + myCar.y + ")");
	}

}
