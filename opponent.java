/**
 * Alex Leduc
 * Connect 4 Computer opponent
 * 
 */
import java.util.*;

public class opponent {
	Random gen = new Random();
    //============================================================================= default constructor
    public opponent() {
    	
    }
    
    //=============================================================================		nextMove
    public int nextMove(board theboard){
    	int move;
    	if(theboard.getNextRow(0)==6&&theboard.getNextRow(1)==6&&theboard.getNextRow(2)==6&&theboard.getNextRow(3)==6&&theboard.getNextRow(4)==6&&theboard.getNextRow(5)==6&&theboard.getNextRow(6)==6){
    		System.out.println("NO LEGAL MOVES REMAIN, COMPUTER OVER, DEATH, DISMEMBERMENT, ET CETERA.");
    		System.exit(-1);
    	}
    	do{
    		move = Math.abs(gen.nextInt() %7 );
    	}while(theboard.getNextRow(move)==6 );
    	return(move);
    }//end nextMove
    
    
}