/*	Alex Leduc	
 *	Connect 4
 *
 */
 import java.util.*;
 
 public class connect4{
 	public static void main(String [] args){
 		board gameboard = new board();
 		System.out.println("\nHello.  Let's play some Connect Four.\nI am the Xs, you are the Os. \nYou go first.");
 		gameboard.show();
 		int result = playGame(gameboard);
 		printResults(result, gameboard);
 	}//end main
 	
 	//=============================================================================		playGame
 	public static int playGame( board gboard ){
 		int playermove, compymove, movecount;
 		movecount = 0;
 		opponent compy = new opponent();
 		Scanner input = new Scanner(System.in);
 	
 		do{
 			//players turn
 		playermove = getPlayerMove(input,gboard);
 		gboard.putOIn(playermove);
 		gboard.show();
 		if(checkVictory(gboard))
 			return(1);
 		movecount++;
 			//computer turn
 		System.out.println("\nNow it is my turn");
 		compymove = compy.nextMove(gboard);
 		gboard.putXIn(compymove);
 		gboard.show();
 		if(checkVictory(gboard))
 			return(-1);
 		movecount++;
 		
 		}while(!(movecount==42));
 		
 		return(0);
 	}//end playGame
 	
 	//=============================================================================		getPlayerMove
 	public static int getPlayerMove(Scanner userin, board theboard){
 		System.out.print("\nPlease choose a column number to place your move into\nThe columns are numbered zero to six with the leftmost column at zero\n->");
 		int move;
 		do{
 			move = userin.nextInt();
 			if( (move>6)||(move<0)||theboard.getNextRow(move)==6 )
 				System.out.println("Can't go there.  Choose another column");
 		}while( (move>6)||(move<0)||theboard.getNextRow(move)==6 ) ;
 		return(move);
 	}//end getPlayerMove
 
 	//=============================================================================		checkVictory
 	/*	to check for a victory, I will utilize the board object's ability to concatenate
 	 *	its rows and columns and diagonals into strings, one of which will contain either
 	 *	"XXXX" or "OOOO" if there is a win.  The string.contains method can evaluate this 
 	 *	and return a boolean value, so that makes life easy.
 	 */
 	public static boolean checkVictory(board theboard){
 		if(checkRow(theboard)||checkDiag(theboard)||checkCol(theboard))
 			return(true);
 		else{
 			return(false);
 		}
 	}//end checkVictory
 	
 	//=============================================================================		checkRow
 	public static boolean checkRow(board aboard){
 		String row;
 		for(int r = 0; r<6; r++){
 			row = aboard.getRow(r);
 			if(row.contains("XXXX")||row.contains("OOOO") )
 				return(true);
 		}//end for
 		return(false);
 		
 	}//end checkRow
 	
 	//=============================================================================		checkCol
 	public static boolean checkCol(board aboard){
 		String col;
 		for(int c = 0; c<7; c++){
 			col = aboard.getCol(c);
 			if(col.contains("XXXX")||col.contains("OOOO") )
 				return(true);
 		}//end for
 		return(false);
 	}//end checkCol
 	
 	//=============================================================================		checkDiag
 	public static boolean checkDiag(board aboard){
 		String ldiag,rdiag;
 		for(int l = 1; l<7; l++){
 			ldiag = aboard.getLtDiag(l);
 			if(ldiag.contains("XXXX")||ldiag.contains("OOOO") )
 				return(true);
 		}//end for ldiag
 		for(int r = 1; r<7; r++){
 			rdiag = aboard.getRtDiag(r);
 			if(rdiag.contains("XXXX")||rdiag.contains("OOOO") )
 				return(true);
 		}//end for rdiag
 		return(false);
 	}//end checkDiag
 	
 	//=============================================================================		printResults
 	public static void printResults(int outcome, board gboard){
 		switch(outcome){
 			case -1:	System.out.println("\n\n\n You have been crushed by superior talent.  Try not to cry your body dry over it.\n");
 						gboard.show();
 						System.out.println("\n LOSER");
 						break;
 			
 			case 0:		System.out.println("\n\n\n It seems we have reached a draw.  \nThe important thing to note here is that, despite all your efforts, you failed to win.  See you next time!\n");
 						gboard.show();
 						System.out.println("\n DRAW");
 						break;
 						
 			case 1:		System.out.println("\n\n\n It would appear that, despite my superior intelligence, you have prevailed.  \nI am, unfortunately, programmed to be a sore looser.  So lets just say I was Os and you were Xs, deal?");
 						gboard.show();
 						System.out.println("\n WINNER");
 						break;
 						
 			default:	System.out.println("something when horribly wrong in print results");
 						System.exit(-1);
 		}//end switch
 	}//end printResults
 }
