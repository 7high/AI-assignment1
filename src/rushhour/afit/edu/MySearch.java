package rushhour.afit.edu;

import java.util.LinkedList;

public class MySearch implements Search{
	public LinkedList<Board>states;
	int moveCount;
	
	public MySearch(Board board) {
		this.states = new LinkedList<Board>(); 
		states.add(board);
		board.visited = false;
		this.moveCount = 0;
		System.out.println(goalTest(board));
	}

	@Override
	public Move findMoves() {
		Board board = states.remove();
		Move possibleMoves = board.genMoves();
		System.out.println(possibleMoves);
		return null;
	}

	@Override
	public long nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean goalTest(Board board) {		
		Piece myCar= board.piece_list[board.findPiece("X0")];
		
		if ((myCar.x == Board.BOARD_EXIT_X) && (myCar.y == Board.BOARD_EXIT_Y)) {
			return true;
		}
		
		return false;
	}

}
