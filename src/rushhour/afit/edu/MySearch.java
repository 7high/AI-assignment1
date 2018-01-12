package rushhour.afit.edu;

import java.util.LinkedList;

/**
 * MySearch implements a breadth-first search to solve the Rushhour game puzzle.
 * @author User
 *
 */
public class MySearch implements Search{
	public LinkedList<Board>frontier;
	public MyHashSet explored;
	int count;
	
	public MySearch(Board board) {
		this.frontier = new LinkedList<Board>();
		frontier.add(board);		
		this.explored = new MyHashSet();	
		this.count = 0;
	}

	@Override
	public Move findMoves() {	
		Board b = frontier.peek();		
		if (goalTest(b)) {return b.move_list;}		
		
		while(!frontier.isEmpty()) {	
			b = frontier.remove();//Get unexpanded state
			Move m = b.genMoves(); //Expand state
			explored.add(b); //Put expanded state into explored 
			count++;
			
			while(m != null) { //the last move in a Move list is null
				Board newState = new Board(b); //Create new board based on expanded state	
				newState.makeMove(m);								
				
				if (goalTest(newState)) {
					return newState.move_list;					
				}								
				
				if ((!explored.contains(newState)) && (!frontier.contains(newState))) {//add only if the board is unexplored and not currently in frontier
					frontier.add(newState);
					
				}
				m = m.next;				
			}			
		}
		return null;
	}

	@Override
	public long nodeCount() {
		return count;
	}
	
	public boolean goalTest(Board board) {		
		Piece myCar= board.piece_list[board.findPiece("X0")];
		
		if ((myCar.x == Board.BOARD_INDEX) && (myCar.y == Board.BOARD_EXIT_Y)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Debugging method. I used this to print out all the possible moves from a given Move
	 * @param m
	 */
	public void printGenMove(Move m) {
		while(m !=null) {
			System.out.println(m);
			m = m.next;
		}
	}
	
	/**
	 * Debugging method.
	 * @param b
	 */
	public void printMoveList(Board b) {
		Move m = b.move_list;
		while(m !=null) {
			System.out.println(m);
			m = m.next;
		}
	}
	
	/**
	 * Debugging method
	 * @param b
	 */
	public void carLocation(Board b) {
		Piece myCar = b.piece_list[b.findPiece("X0")];
		System.out.println("MyCar(" + myCar.x + ", " + myCar.y + ")");
	}

}
