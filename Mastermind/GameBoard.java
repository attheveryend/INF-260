/**
 * Alex Leduc
 *	Mastermind Board Class
 *			
 *			holds ten player guesses in a String array, a string for the actual code and the method to generate it, and the methods to assess player guesses.
 *			also can print itself and check for a victory.
 *
 * 
 */
import java.util.*;

public class GameBoard {

private String [][] daboard = new String[10][2];  //First column is for player guesses, second column is for guess assessment strings
private String code;
private int nextGuess = 0;
private String alphabet = "RGBY";
    
    
    public GameBoard() {
    	code = generateCode();
    	for(int i = 0; i<10; i++){
    		daboard[i][0]="    ";
    		daboard[i][1]="    ";
    	}//end for
    }//end default constructor
    
    //======================================================	generateCode
    private String generateCode(){
    	String zeeCode = "";
    	Random gen = new Random();
    	for(int i = 0; i<4; i++)
    		zeeCode+= alphabet.charAt( Math.abs( gen.nextInt()%4 ) );
    	return(zeeCode);
    }//end generateCode
    
    //======================================================	printCode
    public void printCode(){
    	System.out.println(code);
    }//end printCode
    
    //======================================================	nextGuess
    public void nextGuess(String guess){
       	daboard[nextGuess][0] = guess;
    	processGuess(guess, code);
    	nextGuess++;
    }//end nextGuess
    
    //======================================================	processGuess
    //Dependence:  stringThis
    public void processGuess(String input, String answer){
    	char [] tempinput = input.toCharArray();
    	String temp;
    	String result="";
    	
    	for(int i=0; i<4; i++){
    		if( input.charAt(i)==answer.charAt(i) ){
    			result+= 'P';
    			tempinput[i]='X';
    		}//end if
    	}//end for
    	
    	temp = stringThis(tempinput);
    	
    	for(int r=0; r<4; r++){
    		if( answer.contains( ""+temp.charAt(r) ) ){
    			result+='C';
    		}//end if
    	}//end for
    	
    	daboard[ nextGuess ][1]=result;
    	
    }//end processGuess
    
    //======================================================	stringThis
    private String stringThis(char [] stuff){
    	String dude = "";
    	for(int i = 0; i<stuff.length; i++)
    		dude+= stuff[i];
    	return(dude);
    }//end stringThis
    
    //======================================================	print
    public void print(){
    	System.out.println("\n\t\t\tGuess\tFeedback" );
    	for(int i = 9; i>=0; i--){
    		System.out.println("Guess #"+ (i+1)+"\t"+ daboard[i][0]+"\t"+daboard[i][1] );
    	}//end for
    }//end print
    
    //======================================================	checkVictory
    public boolean checkVictory(){
    	if(nextGuess>=0 && daboard[nextGuess-1][1].equals("PPPP") ){
    		return(true);
    	}
    	else{
    		return(false);
    	}
    }//end checkVictory
    
    //======================================================	getTurnCount
    public int getTurnCount(){
    	return(nextGuess-1);
    }//end getTurnCount

}//end class GameBoard