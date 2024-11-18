import java.util.Scanner;

public class ticTacToe {
    final static int ROWS = 3;
    final static int COLS = 3;
    static String[][] board = new String[ROWS][COLS];







    public static void main(String[] args) {
        clearBoard();

        showBoard();
        int row = 0;
        int col = 0;
        int turn = 0;
        String player = "x";
        Scanner in = new Scanner(System.in);
        boolean done = false;

        do{
            do {
                System.out.println("Getting move from " + player);
                row = SafeInput.getRangedInt(in, "Enter your row", 1, 3);
                col = SafeInput.getRangedInt(in, "Enter your col", 1, 3);
                row--;
                col--;
                turn ++;

            }while(!isValidMove(row,col));

            recordMove(player,row,col);
            showBoard();
            if (isWin(player)) {
                showBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (isTie(turn = 9)) {
                showBoard();
                System.out.println("It's a tie!");
                break;
            }


            if (player.equals("x"))
                player = "o";
            else
                player = "x";
        }while(!done);

    }

    private static void showBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++)
                System.out.print("| " + board[r][c] + " |");
            System.out.println();

        }
    }

    private static void clearBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++)
                System.out.print("| " + board[r][c] + " |");
            System.out.println();

        }




    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col].equals(" ");
    }
    }
    private static void recordMove(String player, int row, int col) {
        ticTacToe.board[row][col] = player;
    }
private static boolean isWin(String player) {
    return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
}
private static boolean isRowWin(String player)
{
    for(int row=0; row < ROWS; row++)
    {
        if(board[row][0].equals(player) && board[row][1].equals(player) &&
                board[row][2].equals(player))
        {
            return true;
        }
    }
    return false; // no row win
}
private static boolean isColWin(String player)
{
    for(int col=0; col < COLS; col++)
    {
        if(board[col][0].equals(player) && board[col][1].equals(player) &&
                board[col][2].equals(player))
        {
            return true;
        }
    }
    return false; // no row win
}
private static boolean isDiagonalWin(String player) {
    return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
            (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
}
private static boolean isTie(int turn) {
    return turn == 9;
}


}