/**
 * @(#)Mastermind.java
 *
 *
 * @author 
 * @version 1.00 2013/11/14
 */
import java.util.*;

public class Mastermind {

    public static void main(String [] args){
    	GameBoard board = new GameBoard();
    	int outcome = playMastermind( board );
    	printResults(outcome, board);
    }//endmain
    
    //======================================================	playMastermind
    public static int playMastermind( GameBoard bd ){
    	Scanner input = new Scanner(System.in);
    	String guess;
    	int turncount = 0;
    	
    	System.out.println("\n\nHello, and again, welcome to the Aperture Science portable non-self playable Mastermind virtual board game.");
    	System.out.println("\n\nThis is a game that will test your mental agility and phalangal dexterity to a level you've probably surpased in other activities." );
    	System.out.println("\nHere is how it works.  I have come up with a code.  It is four elements in length, and each element can be one of four colors:\nRed, Blue, Green, and Yellow--each abbreviated using the first letter; R, B, G and Y, respectively, though you need not use capitals.");
    	System.out.println("\nNow you won't simply be guessing in the dark.  I'll assess your guesses and supply you with feedback.  For each element in your \ncode that is the correct color and position, you'll recieve a P in the feedback code.  If your code contains a correct \ncolor that is incorrectly placed, you will recieve a C in the response.");
    	System.out.println("\nIf you can guess the colors of my code in the correct order, you will be rewarded with your life.\nIf you need more than ten guesses, however...You'll recieve a most thorough chastising!");
    	System.out.println("\n\nEnter any character to begin!");
    	
    	guess = input.next();
    	
    	do{
    		bd.print();
    		System.out.println("\nPlease enter a guess.");
    		
    		do{
    			guess = input.next();
    			guess = guess.toUpperCase();
    		}while(!assessGuessLegality(guess) );
    		
    		bd.nextGuess(guess);
    		turncount++;
    		
    		if( bd.checkVictory() ){
    			bd.print();
    			return(1);
    		}
    		else if(turncount==10){
    			bd.print();
    			return(-1);
    		}//end if-else
    		
    	}while( true );
    	
    }//end playMastermind
    
    //====================================================== assessGuessLegality
    public static boolean assessGuessLegality(String thing){
    	
    	for(int i = 0; i<4; i++){	
    			if(  thing.length()!=4 || !( (thing.charAt(i)=='R')||(thing.charAt(i)=='G')||(thing.charAt(i)=='B')||(thing.charAt(i)=='Y')  )     ){
    				System.out.println("\nI refuse to even consider a guess that is not four characters in length or that consists of \nanything other than my color abbreviations:  R, G, B, or Y.  Please enter a *legal* guess.");
    				return(false);
    			}//end if
    		}//end for
    		return(true);
    }//end assessGuessLegality
    
    //====================================================== printResults
    public static void printResults(int val, GameBoard bd){
    	switch( val ){
    		case -1:	System.out.println("\n\n\nI can't believe you couldn't figure it out.  Even if you had guessed randomly it wouldn't have been as bad as how bad you just did.\nI played against a squirrel and even that didn't lose as badly as you did.  In fact it was so bad that I've just recieved a telephone call from your parents\ntelling me how ashamed they are of you and that they don't love you any more.  Maybe you'll do better next time.\nBut you probably won't based on this performance.");
    					System.out.println("\n\nYOU LOSE.");
    					System.exit(0);
    		
    		case  1:	System.out.println("\n\n\nCongratulations, you've managed to type in enough guesses to statistically overcome your inability to reason effectively.\nSomeone should pat you on the shoulder or something.");
    					System.out.println("\n\nYOU WIN!");
    					System.exit(0);
    		
    		default:	System.out.println("\nSomething when horribly, horribly wrong.");
    					System.exit(-2);
    	}
    	
    }//end PrintResults


}//end class Mastermind