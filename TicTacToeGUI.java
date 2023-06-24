package csu07419.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {


    private Buttons Row0;
    private JLabel playerTurnLabel;
    private JLabel rowsLabel;
    private Buttons Row1;
    private Buttons Row2;
    private Buttons Row3;
    private Buttons Row4;
    private Buttons Row5;
    private Buttons Row6;
    private Buttons Row7;
    private Buttons column0;
    private Buttons column1;
    private Buttons column2;
    private Buttons column3;
    private Buttons column4;
    private Buttons column5;
    private Buttons column6;
    private Buttons column7;
    private JLabel columnLabel;
    private JLabel positionSelectedLabel;
    private JTextArea boardDisplayArea;



    private JLabel insideText;
    JPanel boardContainerPanel ;
    JPanel mainBoardPanel;


    private  JPanel[] playBoardPanel= new JPanel[40];;
    private JLabel gameProgressLabel;


    public TicTacToeGUI(){
        super("TIC TAC TOE APP");
        this.setSize(500,1200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(50,200,200));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        Row0 = new Buttons ("0");
        playerTurnLabel =new JLabel("Current Player  is : ");
        rowsLabel = new JLabel ("ROWS :");
        Row1 = new Buttons ("1");
        Row2 = new Buttons ("2");
        Row3 = new Buttons ("3");
        Row4 = new Buttons ("4");
        Row5 = new Buttons ("5");
        Row6 = new Buttons ("6");
        Row7 = new Buttons ("7");
        column0 = new Buttons ("0");
        column1 = new Buttons ("1");
        column2 = new Buttons ("2");
        column3 = new Buttons ("3");
        column4 = new Buttons ("4");
        column5 = new Buttons ("5");
        column6 = new Buttons ("6");
        column7 = new Buttons ("7");
        columnLabel = new JLabel ("COLUMN :");
        positionSelectedLabel = new JLabel ("POSITION SELECTED");
        //Here's where i have to introduce the  new board

        boardContainerPanel = new JPanel();
        boardContainerPanel.setLayout(new GridLayout(5, 8, 5, 5)); // Adjust the layout as per your requirements

        boardDisplayArea = new JTextArea (5, 5);
        gameProgressLabel = new JLabel ("GAME INFO :");
        setPreferredSize (new Dimension (911, 569));
        setLayout (null);
        /**
         * From here to the intended target is where i will put code for the boardArea
         */
        // Create a container panel to hold the play board panels

        boardContainerPanel.setLayout(new GridLayout(5, 8, 5, 5)); // Adjust the layout as per your requirements


        for (int i = 0; i < 40; i++) {
            playBoardPanel[i] = createPlayBoardPanel(i);
            boardContainerPanel.add(playBoardPanel[i]);
        }


        JPanel rowIndicesPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        for (int i = 0; i < 5; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i));
            rowLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rowIndicesPanel.add(rowLabel);
        }

        // Create a main panel to hold the container panel and row indices panel
        mainBoardPanel = new JPanel(new BorderLayout());
        mainBoardPanel.add(rowIndicesPanel, BorderLayout.WEST);
        mainBoardPanel.add(boardContainerPanel, BorderLayout.CENTER);

        JPanel columnIndicesPanel = new JPanel(new GridLayout(1, 8, 5, 5));
        for (int i = 0; i < 8; i++) {
            JLabel columnLabel = new JLabel(String.valueOf(i));
            columnLabel.setHorizontalAlignment(SwingConstants.CENTER);
            columnIndicesPanel.add(columnLabel);
        }
        mainBoardPanel.add(columnIndicesPanel, BorderLayout.NORTH);




        /**
         * End of board code
         */

        //add components to container
        add (Row0);
        add (playerTurnLabel);
        add (rowsLabel);
        add (Row1);
        add (Row2);
        add (Row3);
        add (Row4);
        add (Row5);
        add (Row6);
        add (Row7);
        add (column0);
        add (column1);
        add (column2);
        add (column3);
        add (column4);
        add (column5);
        add (column6);
        add (column7);
        add (columnLabel);
        add (positionSelectedLabel);
//        add (boardDisplayArea);
        add(mainBoardPanel);
        add (gameProgressLabel);

        playerTurnLabel.setBounds (35, 35, 225, 25);
        rowsLabel.setBounds (35, 70, 100, 25);
        Row0.setBounds (100, 65, 50, 25);
        playerTurnLabel.setBounds (35, 35, 225, 25);
        rowsLabel.setBounds (35, 70, 100, 25);
        Row1.setBounds (160, 65, 50, 25);
        Row2.setBounds (220, 65, 50, 25);
        Row3.setBounds (280, 65, 50, 25);
        Row4.setBounds (340, 65, 50, 25);
        Row5.setBounds (400, 65, 50, 25);
        Row6.setBounds (460, 65, 50, 25);
        Row7.setBounds (520, 65, 50, 25);
        column0.setBounds (100, 95, 50, 25);
        column1.setBounds (160, 95, 50, 25);
        column2.setBounds (220, 95, 50, 25);
        column3.setBounds (280, 95, 50, 25);
        column4.setBounds (340, 95, 50, 25);
        column5.setBounds (400, 95, 50, 25);
        column6.setBounds (460, 95, 50, 25);
        column7.setBounds (520, 95, 50, 25);
        columnLabel.setBounds (35, 100, 65, 25);
        positionSelectedLabel.setBounds (35, 130, 305, 25);
//        boardDisplayArea.setBounds (35, 170, 375, 190);
        mainBoardPanel.setBounds (35, 170, 375, 190);
        gameProgressLabel.setBounds (35, 375, 200, 25);
        pack();
    }
    public JPanel[] getPlayBoardPanel() {

        return playBoardPanel;
    }

    private JPanel createPlayBoardPanel(int panelIndex) {
        playBoardPanel[panelIndex] = new JPanel();
        insideText =new JLabel();
        playBoardPanel[panelIndex].setPreferredSize(new Dimension(50, 50)); // Adjust the size as per your requirements
        playBoardPanel[panelIndex].setBackground(Color.gray); // Set the background color as per your preference
        playBoardPanel[panelIndex].setBorder(BorderFactory.createLineBorder(Color.black)); // Add a border to the panel

        // Create a smaller label for the cell content
        JLabel cellLabel = new JLabel();
        cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cellLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        playBoardPanel[panelIndex].add(cellLabel);
        playBoardPanel[panelIndex].add(insideText);

        return playBoardPanel[panelIndex];
    }
    public JLabel getPlayerTurnLabel() {
        return playerTurnLabel;
    }

    public JLabel getPositionSelectedLabel() {
        return positionSelectedLabel;
    }

    public JTextArea getBoardDisplayArea() {
        return boardDisplayArea;
    }

    public JLabel getGameProgressLabel() {
        return gameProgressLabel;
    }

      void addRow0Listener(ActionListener listenForButton){
        Row0.addActionListener(listenForButton);
    }
    void addRow1Listener(ActionListener listenForButton){
        Row1.addActionListener(listenForButton);
    }
    void addRow2Listener(ActionListener listenForButton){
        Row2.addActionListener(listenForButton);
    }
    void addRow3Listener(ActionListener listenForButton){
        Row3.addActionListener(listenForButton);
    }
    void addRow4Listener(ActionListener listenForButton){
        Row4.addActionListener(listenForButton);
    }
    void addRow5Listener(ActionListener listenForButton){
        Row5.addActionListener(listenForButton);
    }
    void addRow6Listener(ActionListener listenForButton){
        Row6.addActionListener(listenForButton);
    }
    void addRow7Listener(ActionListener listenForButton){
        Row7.addActionListener(listenForButton);
    }

    void addcolumn0Listener(ActionListener listenForButton){
        column0.addActionListener(listenForButton);
    }
    void addcolumn1Listener(ActionListener listenForButton){
        column1.addActionListener(listenForButton);
    }
    void addcolumn2Listener(ActionListener listenForButton){
        column2.addActionListener(listenForButton);
    }
    void addcolumn3Listener(ActionListener listenForButton){
        column3.addActionListener(listenForButton);
    }
    void addcolumn4Listener(ActionListener listenForButton){
        column4.addActionListener(listenForButton);
    }
    void addcolumn5Listener(ActionListener listenForButton){
        column5.addActionListener(listenForButton);
    }
    void addcolumn6Listener(ActionListener listenForButton){
        column6.addActionListener(listenForButton);
    }
    void addcolumn7Listener(ActionListener listenForButton){
        column7.addActionListener(listenForButton);
    }
}
 class Buttons extends JButton{
    Buttons(String text){
        super(text);
        setSize(50,100);
        setBackground(new Color(202,200,149));

    }
}