package rushhour.afit.edu;
/**
 * <p>Title: Rush Hour</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: AFIT</p>
 * @author not attributable
 * @version 1.0
 */

public class Move
{
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST = 3;
    public static final int WEST = 4;

    //type/direction flags
    public int direction;
    public int piece_index;

    //How many squares to move
    public int spaces;

    public Move next;

    public Move ( int index, int dir, int sp , Move pointer ) {
      direction = dir;
      piece_index = index;
      spaces = sp;
      next = pointer;
    }
    
    public Move (Move m) {
      direction = m.direction;
      piece_index = m.piece_index;
      spaces = m.spaces;
      next = null; 
    }
    
    /**
     * Checks if moves are equal
     * @param m
     * @return
     */
    public boolean equals(Move m) {
    	Move other = m;
    	if(this.direction != other.direction && 
    			this.piece_index != other.piece_index && 
    			this.spaces != other.piece_index && 
    			this.next != other.next) {
    		return false;
    	}
    	
    	return true;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String str = new String("Move: Piece " + this.piece_index + ", Direction " + this.direction + 
    			", Spaces " + this.spaces);
    	return str;
    }
}
