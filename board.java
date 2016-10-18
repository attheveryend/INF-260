/**
 * 	Alex Leduc
 *	Connect4 game board
 *
 */


 public class board{
 	char [][] gboard;
 	int [] nextrow ={0,0,0,0,0,0,0};
 	//============================================================ default constructor
 	public board(){
 		gboard = new char[6][7]; 		
 		for(int r = 0; r<6; r++)
 			for(int c = 0; c<7; c++)
 				gboard[r][c]=' ';
 	}//end default constructor
 	
 	//============================================================ board(1) constructor
 	/* 	creates a board in which a draw is easy to reach AS LONG AS THE
 	 *	MOVE COUNTER IN THE playGame METHOD IS SET TO 40, as 2 turns
 	 *	remain for this board.
 	 */
 	public board(int n){
 		if(n==1){
 			gboard = new char[6][7];
 			gboard[0][0] = 'X'; gboard[0][1] = 'X'; gboard[0][2] = 'O'; gboard[0][3] = 'O'; gboard[0][4] = 'X'; gboard[0][5] = ' '; gboard[0][6] = ' ';
 			gboard[1][0] = 'O'; gboard[1][1] = 'O'; gboard[1][2] = 'X'; gboard[1][3] = 'X'; gboard[1][4] = 'O'; gboard[1][5] = 'O'; gboard[1][6] = 'X';
 			gboard[2][0] = 'X'; gboard[2][1] = 'X'; gboard[2][2] = 'O'; gboard[2][3] = 'O'; gboard[2][4] = 'X'; gboard[2][5] = 'X'; gboard[2][6] = 'O';
 			gboard[3][0] = 'O'; gboard[3][1] = 'O'; gboard[3][2] = 'X'; gboard[3][3] = 'X'; gboard[3][4] = 'O'; gboard[3][5] = 'O'; gboard[3][6] = 'X';
 			gboard[4][0] = 'X'; gboard[4][1] = 'X'; gboard[4][2] = 'O'; gboard[4][3] = 'O'; gboard[4][4] = 'X'; gboard[4][5] = 'X'; gboard[4][6] = 'O';
 			gboard[5][0] = 'O'; gboard[5][1] = 'O'; gboard[5][2] = 'X'; gboard[5][3] = 'X'; gboard[5][4] = 'O'; gboard[5][5] = 'O'; gboard[5][6] = 'X';
 			nextrow[0]=6; nextrow[1]=6; nextrow[2]=6; nextrow[3]=6; nextrow[4]=6; nextrow[5]=5; nextrow[6]=5;
 		}//end if
 	}//end draw constructor
 	
 	//============================================================		initialize
 	//	empties the board and the next legal move counter
 	public void initialize(){
 		for(int r = 0; r<6; r++)
 			for(int c = 0; c<7; c++)
 				gboard[r][c]=' ';
 		for(int r = 0; r<7; r++)
 			nextrow[r]=0;
 	}//end initialize
 	
 	//============================================================ 		getPos
 	public char getpos(int row, int col){
 		return(gboard[row][col]);
 	}//end getPos
 	
 	//============================================================		getNextRow
 	public int getNextRow(int col){
 		return(nextrow[col]);
 	}//end getNextRow
 	
 	//============================================================		setPos
 	public void setpos(int row, int col, char chip){
 		gboard[row][col] = chip;
 	}//end setPos
 	
 	//============================================================		show
 	// prints the current state of the board
 	public void show(){
 		System.out.println("\n---------------");
 		for(int r=0; r<6;r++)
 			System.out.println("|"+gboard[r][0]+"|"+gboard[r][1]+"|"+gboard[r][2]+"|"+gboard[r][3]+"|"+gboard[r][4]+"|"+gboard[r][5]+"|"+gboard[r][6]+"|\n---------------");
 		System.out.println("\n|0|1|2|3|4|5|6|\n");
 	}//end show
 	
 	//============================================================		putXIn
 	//	places an X at the next legal move in the chosen column
 	public void putXIn(int col){
		if(nextrow[col]<6){
			gboard[5-nextrow[col]][col]='X';
			nextrow[col]++;
		}
		else{
			System.out.println("\ncannot place an X in that column; it's full");
		}
 	}//end putXIn
 	
 	//============================================================		putOIn
 	//	places an O at the next legal move in the chosen column
 	public void putOIn(int col){
 		if(nextrow[col]<6){
 			gboard[5-nextrow[col]][col]='O';
 			nextrow[col]++;
 		}
 		else{
 			System.out.println("\ncannot place an O in that column; it's full");
 		}
 	}//end putOIn
 	
 	//============================================================		getRtDiag
 	/*	
 	 *these are the right facing diagonals that could possibly contain a win.
 	 *calling an integer will report the diagnonal as a string of characters according to the following convention:
 	 *		3 4 5 6 x x x 
 	 *		2 3 4 5 6 x x 
 	 *		1 2 3 4 5 6 x 
 	 *		x 1 2 3 4 5 6 
 	 *		x x 1 2 3 4 5 
 	 *		x x x 1 2 3 4 
 	 */
 	 public String getRtDiag(int rd){
 	 	String rdiag;
 	 	switch(rd){
 	 		case 1:		rdiag = ""+gboard[2][0]+gboard[3][1]+gboard[4][2]+gboard[5][3];
 	 					return(rdiag);
 	 					
 	 		case 2:		rdiag = ""+gboard[1][0]+gboard[2][1]+gboard[3][2]+gboard[4][3]+gboard[5][4];
 	 					return(rdiag);
 	 		
 	 		case 3:		rdiag = ""+gboard[0][0]+gboard[1][1]+gboard[2][2]+gboard[3][3]+gboard[4][4]+gboard[5][5];
 	 					return(rdiag);
 	 		
 	 		case 4:		rdiag = ""+gboard[0][1]+gboard[1][2]+gboard[2][3]+gboard[3][4]+gboard[4][5]+gboard[5][6];
 	 					return(rdiag);
 	 		
 	 		case 5:		rdiag = ""+gboard[0][2]+gboard[1][3]+gboard[2][4]+gboard[3][5]+gboard[4][6];
 	 					return(rdiag);
 	 					
 	 		case 6:		rdiag = ""+gboard[0][3]+gboard[1][4]+gboard[2][5]+gboard[3][6];
 	 					return(rdiag);
 	 		
 	 		default:	System.out.println("bad getRtDiag input");
 	 					System.exit(-1);
 	 			
 	 	}//end switch
 	 	System.out.println("something Right Diag went horribly wrong");
 	 	return(" ");
 	 }//end getRtDiag
 	 
 	 //============================================================		getLtDiag
 	/*	
 	 *these are the left facing diagonals that could possibly contain a win.
 	 *calling an integer will report the diagnonal as a string of characters according to the following convention:
 	 *		x x x 1 2 3 4 
 	 *		x x 1 2 3 4 5 
 	 *		x 1 2 3 4 5 6 
 	 *		1 2 3 4 5 6 x 
 	 *		2 3 4 5 6 x x 
 	 *		3 4 5 6 x x x 
 	 */
 	 public String getLtDiag(int ld){
 	 	String ldiag;
 	 	switch(ld){
 	 		case 1:		ldiag = ""+gboard[0][3]+gboard[1][2]+gboard[2][1]+gboard[3][0];
 	 					return(ldiag);
 	 					
 	 		case 2:		ldiag = ""+gboard[0][4]+gboard[1][3]+gboard[2][2]+gboard[3][1]+gboard[4][0];
 	 					return(ldiag);
 	 		
 	 		case 3:		ldiag = ""+gboard[0][5]+gboard[1][4]+gboard[2][3]+gboard[3][2]+gboard[4][1]+gboard[5][0];
 	 					return(ldiag);
 	 		
 	 		case 4:		ldiag = ""+gboard[0][6]+gboard[1][5]+gboard[2][4]+gboard[3][3]+gboard[4][2]+gboard[5][1];
 	 					return(ldiag);
 	 		
 	 		case 5:		ldiag = ""+gboard[1][6]+gboard[2][5]+gboard[3][4]+gboard[4][3]+gboard[5][2];
 	 					return(ldiag);
 	 					
 	 		case 6:		ldiag = ""+gboard[2][6]+gboard[3][5]+gboard[4][4]+gboard[5][3];
 	 					return(ldiag);
 	 		
 	 		default:	System.out.println("\nbad getLtDiag input\n");
 	 					System.exit(-1);
 	 			
 	 	}//end switch
 	 	System.out.println("something left Diag went horribly wrong");
 	 	return(" ");
 	 }//end getLtDiag
 	 
 	 //============================================================		getRow
 	 public String getRow(int row){
 	 	String sRow = ""+gboard[row][0]+gboard[row][1]+gboard[row][2]+gboard[row][3]+gboard[row][4]+gboard[row][5]+gboard[row][6];
 	 	return(sRow); 	 	
 	 }//end getRow
 	 
 	 //============================================================		getCol
 	 public String getCol(int col){
 	 	String sCol = ""+gboard[0][col]+gboard[1][col]+gboard[2][col]+gboard[3][col]+gboard[4][col]+gboard[5][col];
 	 	return(sCol);
 	 }//end getCol
 }