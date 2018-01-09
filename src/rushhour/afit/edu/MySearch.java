package rushhour.afit.edu;

import java.util.LinkedList;

public class MySearch implements Search{
	public LinkedList<Board>states;
	
	public MySearch(Board board) {
		this.states = new LinkedList<Board>(); 
		states.add(board);
		board.visited = false;
	}

	@Override
	public Move findMoves() {
		Board board = states.pop();
		Move possibleMoves = board.genMoves();
		System.out.println(possibleMoves);
		return null;
	}

	@Override
	public long nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
