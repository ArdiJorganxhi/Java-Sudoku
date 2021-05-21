import java.util.Random;

public class SudokuCreator {
    static char[] harfler = {'C','N','G','B','I','M','2','1','3'};

    static final int max = 8;
    static final int min = 0;

    static final int harflerMax = 8;
    static final int harflerMin = 0;

    public static final int SIZE = 9;
    //public static final char EMPTY = '-';
    static char[][] board = new char[SIZE][SIZE];

    public static char[][] create() {

        Random random = new Random();

        int row = 0;
        int col = 0;

        int randomNumber = 0;
        int randomEmpty = 0;
        int noOfCellsToBeGenerated = 17;

        for (int i = 1; i <= noOfCellsToBeGenerated; i++){
            row = random.nextInt((max - min) + 1) + min;
            col = random.nextInt((max - min) + 1) + min;
            randomNumber = random.nextInt((harflerMax - harflerMin) + 1) + harflerMin;




            if (board[row][col] == 0 && catisma(board, row, col, randomNumber)) {
                board[row][col] = harfler[randomNumber];
            } else {

                i--;
            }
        }
        return board;
    }
    public static boolean catisma(char[][] array, int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (array[row][i] == harfler[num]) {
                return false;
            }
            if (array[i][col] == harfler[num]) {
                return false;
            }
        }

        int boardRow = row - (row % 3);
        int boardColumn = col - (col % 3);
        for (int p = boardRow; p < boardRow + 3; p++) {
            for (int q = boardColumn; q < boardColumn + 3; q++) {
                if (array[p][q] == harfler[num]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void bastir(){
        create();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
