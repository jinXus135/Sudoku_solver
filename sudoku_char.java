package sudoku_char;

public class sudoku_char {
	static char [][]board_to_solve = {{'9','.','.','1','.','.','.','.','5'},{'.','.','5','.','9','.','2','.','1'},{'8','.','.','.','4','.','.','.','.'},
			{'.','.','.','.','8','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','.','2','6','.','.','9'},
			{'2','.','.','3','.','.','.','.','6'},{'.','.','.','2','.','.','9','.','.'} ,{'.','.','1','9','.','4','5','7','.'}};

private char phold = '.';
private int size = 9;
private char [][] board = new char[size][size];


// initialization of board
public sudoku_char(char [][]board)
{
for (int i =0; i< size; i++) {
for (int j = 0; j < size; j++) {
this.board[i][j] = board[i][j];
}
}
}
//process for checking if a value is in row
public boolean isPossibleRow(int row, char n) {

for (int i = 0;i<size; i++) {

if(board[row][i] == (char)n)
return true;

}
return false;
}

//process for checking if a value is in column
public boolean isPossibleCol(int col, char n) {

for (int i = 0;i<size; i++) {
if(board[i][col] == (char)n)
return true;
}
	return false;
}
//process for checking if value is in its 3x3 box
public boolean isInSq(int row, int column, char n) {

int Row = row - row%3;
int Col = column - column%3;
for(int i = Row; i < Row+3;i++)
	for (int j = Col; j< Col+3; j++) {
	if(board[i][j] == (char)n)
		return true;
	}
return false;
}
//confirming the given value is not in a given row, column, or within its box
public boolean valid( int col, int row, char n ){
return !isPossibleRow(row, n) && !isPossibleCol(col, n) && !isInSq(row, col, n);

}
// recursive backtracking method for solving the puzzle
public boolean solve()
{
for (int row = 0; row<size; row++){
for(int col = 0; col<size; col++) {
if(board[row][col] == phold) { // searching for an empty space on grid
for(int num = 1; num <=size; num++){ // trying all possible values
	char n = (char) (num+'0');
	if(this.valid(col, row, n)) {
	board[row][col] = n; // if the current value is not present then place on grid
	
	if(solve()) {   //solve returns true when there are no more empty spaces on grid
		return true;
	}
	else board[row][col]= phold;  // place a zero if the number is already in row, col, or box
	}

}	
return false; // returning false whenever a number cannot be placed, in order to try next number
}
}
}
return true; //when there are no more empty spaces, we return true
}

public void display() {
for (int i = 0; i< size; i++) {
for (int j = 0; j < size; j++) {
System.out.print(" "+ board[i][j]);
}
System.out.println();
}
}

public static void main(String args[])
{
sudoku_char sud = new sudoku_char(board_to_solve);
System.out.println("original, unsolved sudoku puzzle");
sud.display();
System.out.println("Solving Algorith");
System.out.println();
if(sud.solve()) {
sud.display();
System.out.println("Sudoku solved!!!");
}
else
System.out.println("algorithm failed to solve puzzle");
}

}

