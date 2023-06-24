package csu07419.tictactoe;

public class TicTacToeApp {

    public static int ROWS = 5;
    public static int COLUMNS = 8;

    public static void main(String[] args) {
        PlayBoard playBoard = new PlayBoard(ROWS, COLUMNS);
        TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
        TokenPosition tokenPosition = new TokenPosition(-1, -1);
        TicTacToeController theController = new TicTacToeController(playBoard, tokenPosition, ticTacToeGUI);
        theController.gameProgress();

    }
}