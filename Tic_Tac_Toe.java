
import java.util.*;
public class Tic_Tac_Toe {
	
static String board[];
static String turn;
     //for checking the Winner
      public static String checkWinner()
      { 
    	    
    	    for(int i=0;i<8;i++)
    	    { 
    	    	String line=null;
    	    	  switch(i)
    	    	  {
    	    	  case 0:
    	    		  line=board[0]+board[1]+board[2];
    	    		  break;
    	    	  case 1:
    	    		  line=board[3]+board[4]+board[5];
    	    		  break;
    	    	  case 2:
    	    		  line=board[6]+board[7]+board[8];
    	    		  break;
    	    	  case 3:
    	    		  line=board[0]+board[3]+board[6];
    	    		  break;
    	    	  case 4:
    	    		  line=board[1]+board[4]+board[7];
    	    		  break;
    	    	  case 5:
    	    		  line=board[2]+board[5]+board[8];
    	    		  break;
    	    	  case 6:
    	    		  line=board[0]+board[4]+board[8];
    	    		  break;
    	    	  case 7:
    	    		  line=board[2]+board[4]+board[8];
    	    		  break;
    	    		  
    	    	  }
    	    
    	    //checking for x winner 
    	    if(line.equalsIgnoreCase("xxx"))
    	    {
    	    	 return "x";
    	    }else if(line.equalsIgnoreCase("ooo")) {
    	    	 return "o";
    	    }
    	  } 
    	    	 //For checking the draw Condition
    	    	 for (int a = 0; a < 9; a++) {
    	             if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
    	                 break;
    	             } else if (a == 8) {
    	                 return "draw";
    	             }
    	    	 }
      
     
      System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
	    return null;
}
      public static void printBoard()
      { 
    	   System.out.println("|---|---|---|");
    	   System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
    	   System.out.println("|-----------|");
    	   System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
    	   System.out.println("|-----------|");
    	   System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
    	   System.out.println("|-----------|");
      }

	public static void main(String[] args) {
		
		board = new String[9];
		turn="x";
		String winner=null;
		Scanner sc = new Scanner(System.in);
		//set values initially
		for(int i=0;i<9;i++)
		{
			board[i]=String.valueOf(i+1);
		}
		System.out.println("Welcome To the TIC TAC TOE Game.");
		printBoard();
		System.out.println("X' Will Play First.Enter a slot Number");
		while(winner==null)
		{ 
			int numInput;
			try {
				numInput = sc.nextInt();
				if(!(numInput>0&&numInput<=9))
				{
					System.out.println("Invalid input..! re_enter the solt");
					continue;
				}
				
					
				
				
				//Checking for Slot Availability
				if(board[numInput-1].equals(String.valueOf(numInput)))
				{ 
					board[numInput-1]=turn;
					turn=turn.equals("x")?"o":"x";
					printBoard();
					winner=checkWinner();
				}
				else
				{ 
					System.out.println("Slot Already Taken ! re-enter the slot number");
				}
				
			}catch(InputMismatchException e)
			{ 
				System.out.println("Invalid Input.... Re-Enter the number");
				sc.nextLine();
			}
			
		}
		
		//for Final Winning Check
		if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
	}

}
