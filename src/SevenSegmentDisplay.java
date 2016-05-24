import java.util.Scanner;


public class SevenSegmentDisplay {

	/**
	 * @param args
	 */
	private static int magnifiedSize = 25;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char zero[][] = {
				{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*',' ',' ',' ','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'}};
		
		char one[][] = {
				{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '},
				{' ',' ','*',' ',' '}};
		
		char two[][] = {
				{'*','*','*','*','*'},
				{' ',' ',' ',' ','*'},
				{'*','*','*','*','*'},
				{'*',' ',' ',' ',' '},
				{'*','*','*','*','*'}};
		
		char three[][] = {
			    {'*','*','*','*','*'},
			    {' ',' ',' ',' ','*'},
			    {'*','*','*','*','*'},
			    {' ',' ',' ',' ','*'},
			    {'*','*','*','*','*'}};
		
		char four[][] = {
				{'*',' ',' ',' ','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'},
				{' ',' ',' ',' ','*'},
				{' ',' ',' ',' ','*'}};
		
		char five[][] = {
				{'*','*','*','*','*'},
				{'*',' ',' ',' ',' '},
				{'*','*','*','*','*'},
				{' ',' ',' ',' ','*'},
				{'*','*','*','*','*'}};
		
		char six[][] = {
				{'*','*','*','*','*'},
				{'*',' ',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'}};
		
		char seven[][] = {
				{'*','*','*','*','*'},
				{' ',' ',' ','*',' '},
				{' ',' ','*',' ',' '},
				{' ','*',' ',' ',' '},
				{'*',' ',' ',' ',' '}};	
		
		char eight[][] = {
				{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'}};
		char nine[][] = {
				{'*','*','*','*','*'},
				{'*',' ',' ',' ','*'},
				{'*','*','*','*','*'},
				{' ',' ',' ',' ','*'},
				{'*','*','*','*','*'}};	
		
		
		
	
	Scanner in = new Scanner(System.in);
	String input = in.next();
	//Print the rows
	for(int i = 0; i < magnifiedSize; i++)
	{
		// Print the individual elements
		for(int j = 0; j < input.length(); j++)
		{
			char temp[][];
			switch(input.charAt(j))
			{
			case '0':temp = magnify(zero);
						break;
			case '1':temp = magnify(one);
			break;
			case '2':temp = magnify(two);
			break;
			case '3':temp = magnify(three);
			break;
			case '4':temp = magnify(four);
			break;
			case '5':temp = magnify(five);
			break;
			case '6':temp = magnify(six);
			break;
			case '7':temp = magnify(seven);
			break;
			case '8':temp = magnify(eight);
			break;
			case '9':temp = magnify(nine);
			break;
			default:continue;
			}
			//Print the columns of a digit
			for(int k = 0; k < magnifiedSize; k++)
				System.out.print(temp[i][k]);
			System.out.print("   ");
		}
		System.out.println();
	}
	in.close();
	
	
	}
	
	public static char[][] magnify2(char input[][])
	{
		int SIZE = 9;
		char magnifiedArray[][] = new char[SIZE][SIZE];
		boolean allAsterickt;
		//Row by Row  
		for(int i = 0; i < 5; i++)
		{
			allAsterickt = true;
			for(int j = 0; j < 5; j++)
			{
				if(input[i][j] != '*')
				{
					allAsterickt = false;
					break;
				}
			}
			if(allAsterickt)
			for(int j = 0; j < SIZE; j++)
			{
				magnifiedArray[(int)Math.ceil ((SIZE/5.0)*i)][j] = '*';
			}
		}
		
		//Column By Column
		for(int i = 0; i < 5; i++)
		{
			allAsterickt = true;
			for(int j = 0; j < 5; j++)
			{
				if(input[j][i] != '*')
				{
					allAsterickt = false;
					break;
				}
			}
			if(allAsterickt)
			for(int j = 0; j < SIZE; j++)
			{
				magnifiedArray[j][(int) Math.ceil((SIZE/5.0)*i)] = '*';
			}
		}
		
		//half filled columns
		for(int i = 0; i < 5; i++ )
		{
			//upper half filled column
			boolean UpperHalfFilled = true;
			for(int j = 0; j < 2; j++)
			{
				if(input[j][i] != '*')
				{
					UpperHalfFilled = false;
					break;
				}
			}
			if(UpperHalfFilled && input[3][i] == ' ')
			{
				for(int j = 0;  j < SIZE/2;j++)
					magnifiedArray[(int)Math.ceil ((SIZE/5.0)*j)][i] = '*';
			}
			//lower half filled column
			boolean lowerHalfFilled = true;
			for(int j = 0; j < 2; j++)
			{
				if(input[j][i] != '*')
				{
					lowerHalfFilled = false;
					break;
				}
			}
			if(lowerHalfFilled && input[1][i]== ' ' )
			{
				for(int j = 0;  j < SIZE/2;j++)
					magnifiedArray[(int)Math.ceil ((SIZE/5.0)*j)][i] = '*';
			}
		}
		
		return magnifiedArray;
	}
	
	public static char[][] magnify(char input[][])
	{
		char magnifiedArray[][] = new char[magnifiedSize][magnifiedSize];
		int scaleFactor = magnifiedSize/5;
		for(int i=0; i < 5; i++)
		{
			for(int j = 0 ; j < 5 ; j++)
			{
				char c = input[i][j];
		    	int x = i*scaleFactor;
		    	int y = j*scaleFactor;
		    	for(int s = x; s < x + scaleFactor; s++)
		    	{
		    		for(int r = y; r < y + scaleFactor; r++)
		    		{
		    			magnifiedArray[s][r] = c;
		    		}
		    	}
		    	
			}
		}
		
		return magnifiedArray;
	}
	
}


