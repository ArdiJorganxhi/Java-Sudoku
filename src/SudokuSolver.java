public class SudokuSolver {

    private boolean isInRow(int row, char harf) {
        for (int i = 0; i < SudokuCreator.SIZE; i++)
            if (SudokuCreator.board[row][i] == harf)
                return true;

        return false;

    }

    private boolean isInCol(int col, char harf) {
        for (int i = 0; i < SudokuCreator.SIZE; i++)
            if (SudokuCreator.board[i][col] == harf)
                return true;
        return false;
    }

    private boolean isInBox(int row, int col, char harf) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (SudokuCreator.board[i][j] == harf)
                    return true;
        return false;
    }

    private boolean isOk(int row, int col, char harf) {
        return !isInRow(row, harf) && !isInCol(col, harf) && !isInBox(row, col, harf);


    }
    public boolean solve(){
        for(int row = 0; row < SudokuCreator.SIZE; row++){
            for(int col = 0; col < SudokuCreator.SIZE; col++){
                if(SudokuCreator.board[row][col]== 0){
                    for(char c : SudokuCreator.harfler){
                        if(isOk(row,col,c)){
                            SudokuCreator.board[row][col] = c;
                            if(solve()){
                                return true;
                            }else{
                                SudokuCreator.board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display(){
        for(int i = 0; i < SudokuCreator.SIZE; i++) {
            for (int j = 0; j < SudokuCreator.SIZE; j++) {
                System.out.print(SudokuCreator.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
