package csu07419.tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToeController {
    PlayBoard playBoard;
    TokenPosition tokenPosition;
    TicTacToeGUI ticTacToeGUI;
    char currentPlayer = 'X';
    public static int ROWS = 5;
    public static int COLUMNS = 8;
    public TicTacToeController(PlayBoard playBoard,TokenPosition tokenPosition,TicTacToeGUI ticTacToeGUI) {
        this.playBoard = playBoard;
        this.tokenPosition=tokenPosition;
        this.ticTacToeGUI = ticTacToeGUI;

        addRowActionListeners();
        addColumnActionListeners();
        ticTacToeGUI.setVisible(true);
    }
    private class RowActionListener implements ActionListener {
        private int row;

        public RowActionListener(int row) {
            this.row = row;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            tokenPosition = new TokenPosition(row,-1);
            System.out.println("The Current row is " +row);
        }
    }
    private class ColumnActionListener implements ActionListener {
        private int column;

        public ColumnActionListener(int column) {
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tokenPosition!=null){
                tokenPosition = new TokenPosition(tokenPosition.getRow(), column);
                System.out.println("The Current column is " +column);
            }

        }
    }

     void addRowActionListeners(){
         this.ticTacToeGUI.addRow0Listener(new RowActionListener(0));
         this.ticTacToeGUI.addRow1Listener(new RowActionListener(1));
         this.ticTacToeGUI.addRow2Listener(new RowActionListener(2));
         this.ticTacToeGUI.addRow3Listener(new RowActionListener(3));
         this.ticTacToeGUI.addRow4Listener(new RowActionListener(4));
         this.ticTacToeGUI.addRow5Listener(new RowActionListener(5));
         this.ticTacToeGUI.addRow6Listener(new RowActionListener(6));
         this.ticTacToeGUI.addRow7Listener(new RowActionListener(7));
     }
     void addColumnActionListeners(){
         this.ticTacToeGUI.addcolumn0Listener(new ColumnActionListener(0));
         this.ticTacToeGUI.addcolumn1Listener(new ColumnActionListener(1));
         this.ticTacToeGUI.addcolumn2Listener(new ColumnActionListener(2));
         this.ticTacToeGUI.addcolumn3Listener(new ColumnActionListener(3));
         this.ticTacToeGUI.addcolumn4Listener(new ColumnActionListener(4));
         this.ticTacToeGUI.addcolumn5Listener(new ColumnActionListener(5));
         this.ticTacToeGUI.addcolumn6Listener(new ColumnActionListener(6));
         this.ticTacToeGUI.addcolumn7Listener(new ColumnActionListener(7));
        }
    void gameProgress(){
        boolean gameEnded = false;
        while(!gameEnded){

            boolean validMove = false;
            updateGameBoard();
            while (!validMove) {
                ticTacToeGUI.getPlayerTurnLabel().setText("The Current Player is: "+currentPlayer);
                if (tokenPosition.getRow() == -1 && tokenPosition.getColumn() == -1) {
                    ticTacToeGUI.getGameProgressLabel().setText("No position selected yet. Please pick a position.");
                    break;
                }
                if (playBoard.checkFreeSpace(tokenPosition)) {
                    ticTacToeGUI.getPositionSelectedLabel().setText("Position Selected id is " +"["+ tokenPosition.getRow()+" ,"+tokenPosition.getColumn()+" ]");
                    playBoard.placeToken(tokenPosition, currentPlayer);

                    JPanel[] currPanel= ticTacToeGUI.getPlayBoardPanel();
                    JPanel currPanel1=currPanel[tokenPosition.getRow()* COLUMNS+tokenPosition.getColumn()];
                    JLabel label= (JLabel) currPanel1.getComponent(0);
                    label.setText(String.valueOf(currentPlayer));
                    ticTacToeGUI.getGameProgressLabel().setText("GAME IN PROGRESS");
                    System.out.println("GAMe in progress");
                    validMove = true;

                } else {
                        break;
                }

                if (playBoard.checkWinner(tokenPosition)) {

                    ticTacToeGUI.getGameProgressLabel().setText("PLAYER: "+currentPlayer+" WINS");
                    updateGameBoard();
                    gameEnded = true;

                } else if (playBoard.checkTie()) {

                    ticTacToeGUI.getGameProgressLabel().setText("GAME HAS ENDED IN A DRAW");
                    updateGameBoard();
                    gameEnded = true;
                } else {
                    updateGameBoard();
                    if (currentPlayer == 'X') {
                        currentPlayer = 'O';
                    } else {
                        currentPlayer = 'X';
                    }
                }
               }
        }
    }
public void updateGameBoard(){
        ticTacToeGUI.getBoardDisplayArea().setText(String.valueOf(playBoard));
}

}


