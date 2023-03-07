# Minesweeper
Recursion can be a very powerful tool for solving difficult problems. Let's solve a problem using recursion related to this game. Some of the cells contain "mines" and some don't. Clicking on a cell reveals whether the cell is a mine or not. If a player clicks on a mine, they lose. If the player clicks on a cell that is not a mine, the cells are revealed using an interesting algorithm. We are going to create and implement such an algorithm using recursion. Here's the idea behind the algorithm. When a cell is clicked at some row, r,  and column, c.

If (r, c) is not a valid row and column, do nothing. (The player didn't even click on the board.)
If (r, c) is not a covered cell, do nothing. (The player has already click the cell.)
If the cell at (r, c) is a mine, then show the entire board. (The game is over.)
If the cell at (r, c) is not a mine, count the number of adjacent cells that contain mines. There are 8 adjacent cells as diagonal cells count as adjacent. We will call the count the "mine count for the cell at (r, c)".
Show the mine count instead of a covered cell at (r, c) and do steps 1 - 5 for cells at (r-1, c), (r+1, c), (r, c-1), and (r, c+1).

To implement this algorithm, we will need a game board. We'll use a 2D array like this:
        char[][] board = { 
                    { '*', '-', '-', '-', '-' }, 
                    { '*', '-', '*', '*', '-' }, 
                    { '*', '-', '-', '*', '-' },
                    { '*', '*', '*', '*', '-' }, 
                    { '-', '-', '-', '-', '*' }, 
                };
                
                Here are some examples using the board above as input.

Calling showMines(board, 4, 1) modifies board to give:

        board = { 
                    { '*', '-', '-', '-', '-' }, 
                    { '*', '-', '*', '*', '-' }, 
                    { '*', '-', '-', '*', '-' },
                    { '*', '*', '*', '*', '-' }, 
                    { '2', '3', '3', '3', '*' }, 
                };
Calling showMines(board, 2, 4) instead modifies board to give:

        board = { 
                    { '*', '3', '2', '2', '1' }, 
                    { '*', '4', '*', '*', '2' }, 
                    { '*', '6', '6', '*', '3' },
                    { '*', '*', '*', '*', '3' }, 
                    { '-', '-', '-', '-', '*' }, 
                };
Calling showMines(board, 3, 2) instead modifies board to give:

        board = { 
                    { '*', '3', '2', '2', '1' }, 
                    { '*', '4', '*', '*', '2' }, 
                    { '*', '6', '6', '*', '3' },
                    { '*', '*', '*', '*', '3' }, 
                    { '2', '3', '3', '3', '*' }, 
                };
For the last call, note that its a mine
