public class MineSweeper{
public static void recShowMines(char[][] board, int row, int col) {
		
    //check if its on the board
    if(!onBoard(board,row,col))
        return;
    
    if (board[row][col] != '-' && !isMine(board, row, col)) 
        return; 

    //if its a mine
    if(isMine(board,row,col)) 
    return;	
    
    //not a mine
    else if(!isMine(board,row,col)) {
        //the returned number of adjacent mines around the specified row and column != 0
        if(numAdjacentMines(board,row,col) != 0) {

            //update at [row][col] with the return count of adjacent mines
        board[row][col] = (char)(numAdjacentMines(board, row, col) + '0');

        //recursive calls for cells at (r, c-1), (r, c+1), (r+1, c), and (r-1, c).
        recShowMines(board,row,col-1);
        recShowMines(board,row,col+1);
        recShowMines(board,row+1,col);
        recShowMines(board,row-1,col);
        }

}

}

//method to check if the element at the specified rorw and column is a mine
public static void showMines(char[][] board, int row, int col) {
    if(isMine(board,row,col)) {
        replaceMines(board);
    }
    else {
        recShowMines(board, row, col);
    }
}

//method to display the board
private static void  displayMines(char[][] board) {

    for(int i=0;i<board.length;i++) {
        for(int j=0;j<board[i].length;j++) {

            System.out.print(board[i][j]);
        }
        System.out.println();
    }


}

//replace the board, with the number of adjacent mines around the row and column number
private static void replaceMines(char [][] board) {
    int count;
    for(int i=0;i<board.length;++i) {
        for(int j=0;j<board[i].length;++j) {
            if(!isMine(board, i, j)) {
                count = numAdjacentMines(board,i,j);
                board[i][j] = (char) (count + '0');
            }

        }
    }
}

//method to check if its a valid row and column
public static boolean onBoard(char [][] board, int row, int col) {
    return row >= 0  && row < board.length && col >=0 && col < board[row].length;

}

//method to check if the cell clicked is a mine
private static boolean isMine(char[][] board, int row, int col) {
    return onBoard(board, row, col) && board[row][col] == '*';
}

//counting the number of adjacent mines around the specified row and column number
    private static int numAdjacentMines(char[][] board, int row, int col) {

        int count = 0;

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
            if (!(i == 0 && j == 0) && isMine(board, row-i, col-j))
                    count++;

        return count;
    }
 
public static void main(String[] args) {
    char[][] actual = { 
            { '*', '-', '-', '-', '-' }, 
            { '*', '-', '*', '*', '-' }, 
            { '*', '-', '-', '*', '-' },
            { '*', '*', '*', '*', '-' }, 
            { '-', '-', '-', '-', '*' }, 
    };
    showMines(actual, 0, 1);
}
}