/**
 * @(#)tictactoe.java
 *
 * tictactoe application
 *
 * @author 
 * @version 1.00 2013/10/2
 */
 import  java.util.*;
 
public class tictactoe {
    
    public static void main(String[] args) {
	char [] [] board = new char [3] [3];
	
	initboard( board );
	printboard(board);
	int result = playgame(board);
	printresults( result );
	printboard(board);
	
    }
    
    public static void initboard ( char [] [] bd ) {
    	for ( int r = 0; r < 3; r++ )
    		for ( int c = 0; c < 3; c++)
    			bd[r][c] = ' ';
    }
    
    public static void printresults( int res ) {
    	switch ( res ) {
    		case 1 :
    			System.out.println("Congrats! You WIN!!!");
    			break;
    		case 0 :
    			System.out.println("The game was a draw");
    			break;
    		case -1 :
    			System.out.println("Sorry! I won the game.");
    			break;
    		default :
    			System.out.println("BAD VALUE FROM PLAYGAME METHOD");
    			break;
    	}
    }
    
    public static int playgame( char [] [] bd ) {
    	int count = 0;
   
    	boolean win = false;
    	Random gen = new Random();
    	Scanner input = new Scanner(System.in);
    	
    	do {
    		getplayermove(bd, input);
    		win = checkwin(bd);
    		if (win == true )
    			return(1);
    		count++;
    		if ( count == 9 )
    			return(0);
    		

    
    			getcomputermove(bd, gen);
    			win = checkwin(bd);
    			if (win == true )
    				return(-1);
    			count++;
    	
    			
    	      printboard(bd);	
    	}while (true );
    	
   
    }
    
    public static void getcomputermove( char [ ] [ ] bd, Random g) {

    	int val;
    	int row, col;
    	
    	do {
    		val = Math.abs(g.nextInt( ) % 9);
    		row = val / 3;
    		col = val % 3;
    			
    	} while ( bd[row][col] != ' ');
    	bd [row] [col] = 'X';
    }
    
    public static void getplayermove(char [] [] bd, Scanner inp) {
    	int val;
    	int row, col;
    	
    	do {
    		System.out.println("Please select a cell 0-8");
    		val = inp.nextInt();
    		row = val /3;
    		col = val % 3;
    	}while (bd[row][col] != ' ');
    	bd [row] [col] = 'O';
    }
    
    public static void printboard(char [] [] bd) {
    	System.out.println("\n");
    	for ( int r = 0; r < 3; r++){
    	
    	System.out.println( " "+ bd[r][0] + " | " + bd[r][1] + " | " + bd[r][2]);
    	if (r < 2 )
    		System.out.println("-----------");
    	}
    }
    
    public static boolean checkwin( char [] [] bd ){
    	
    	if ( checkrow(bd) ||  checkcol(bd)  || checkdiag(bd))
    		return(true);
    	else
    		return (false);
    }
    
    public static boolean checkrow( char [] [] bd) {
    	for (int r = 0; r < 3; r++)
    		if ((bd[r][0] == bd[r][1]) && (bd[r][1] == bd[r][2]) && (bd[r][0] != ' ') )
     			return(true);
     	return(false);
    }
    
    public static boolean checkcol( char [][] bd ){
    	for (int c = 0; c < 3; c++)
    		if ((bd[0][c] == bd[1][c]) && (bd[1][c] == bd[2][c]) && (bd[0][c] != ' ') )
     			return(true);
     	return(false);
    }
    
    public static boolean checkdiag( char [] [] bd ) {
    	if ( (bd[0][0] == bd[1][1]) && (bd[1][1] == bd[2][2]) && (bd[0][0] != ' ') )
    		return(true);
 	if ( (bd[0][2] == bd[1][1]) && (bd[1][1] == bd[2][0]) && (bd[0][2] != ' ') )
    		return(true);
 	
 	return(false);
    }
}