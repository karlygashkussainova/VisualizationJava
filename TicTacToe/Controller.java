package TicTacToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Circle CircleOne;
    @FXML    private Circle CircleTwo;
    @FXML    private Circle CircleThree;
    @FXML    private Circle CircleFour;
    @FXML    private Circle CircleFive;
    @FXML    private Circle CircleSix;
    @FXML    private Circle CircleSeven;
    @FXML    private Circle CircleEight;
    @FXML    private Circle CircleNine;
    @FXML    private Label XOne;
    @FXML    private Label XTwo;
    @FXML    private Label XThree;
    @FXML    private Label XFour;
    @FXML    private Label XFive;
    @FXML    private Label XSix;
    @FXML    private Label XSeven;
    @FXML    private Label XEight;
    @FXML    private Label XNine;
    @FXML    private Label lblMessages;

    private int[] filledSquares = new int[9];
    private int[] filledCircles = new int[5];
    private int[] filledX = new int[5];

    private int filledSquaresCounter = 0;
    private int filledCirclesCounter = 0;
    private int filledXCounter = 0;

    private char winningTeam;

    final private int[][] winningPositions = {
            {1, 5, 9},
            {3, 5, 7},
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
    };

    private boolean allowMoves = true;

    private boolean tie = false;
    private String currentPlayer = "O";

    @FXML
    public void handleSquareOneClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(1);
        }
        else if(currentPlayer.equals("X")){
            this.openX(1);
        }
    }

    @FXML
    public void handleSquareTwoClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(2);
        }
        else if(currentPlayer.equals("X")){
            this.openX(2);
        }
    }

    @FXML
    public void handleSquareThreeClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(3);
        }
        else if(currentPlayer.equals("X")){
            this.openX(3);
        }
    }

    @FXML
    public void handleSquareFourClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(4);
        }
        else if(currentPlayer.equals("X")){
            this.openX(4);
        }
    }

    @FXML
    public void handleSquareFiveClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(5);
        }
        else if(currentPlayer.equals("X")){
            this.openX(5);
        }
    }

    @FXML
    public void handleSquareSixClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(6);
        }
        else if(currentPlayer.equals("X")){
            this.openX(6);
        }
    }

    @FXML
    public void handleSquareSevenClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(7);
        }
        else if(currentPlayer.equals("X")){
            this.openX(7);
        }
    }

    @FXML
    public void handleSquareEightClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(8);
        }
        else if(currentPlayer.equals("X")){
            this.openX(8);
        }
    }

    @FXML
    public void handleSquareNineClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(9);
        }
        else if(currentPlayer.equals("X")){
            this.openX(9);
        }
    }


    public void showCircleOne() {
        this.CircleOne.setVisible(true);
    }

    public void showCircleTwo() {
        this.CircleTwo.setVisible(true);
    }

    public void showCircleThree() {
        this.CircleThree.setVisible(true);
    }

    public void showCircleFour() {
        this.CircleFour.setVisible(true);
    }

    public void showCircleFive() {
        this.CircleFive.setVisible(true);
    }

    public void showCircleSix() {
        this.CircleSix.setVisible(true);
    }

    public void showCircleSeven() {
        this.CircleSeven.setVisible(true);
    }

    public void showCircleEight() {
        this.CircleEight.setVisible(true);
    }

    public void showCircleNine() {
        this.CircleNine.setVisible(true);
    }


    public void showXOne() {
        this.XOne.setVisible(true);
    }

    public void showXTwo() {
        this.XTwo.setVisible(true);
    }

    public void showXThree() {
        this.XThree.setVisible(true);
    }

    public void showXFour() {
        this.XFour.setVisible(true);
    }

    public void showXFive() {
        this.XFive.setVisible(true);
    }

    public void showXSix() {
        this.XSix.setVisible(true);
    }

    public void showXSeven() {
        this.XSeven.setVisible(true);
    }

    public void showXEight() {
        this.XEight.setVisible(true);
    }

    public void showXNine() {
        this.XNine.setVisible(true);
    }

    public void openO(int squarePosition){
        if(!isAlreadySelectedBox(squarePosition) && this.allowMoves == true){
                switch(squarePosition) {
                    case 1:
                        this.showCircleOne();
                        break;
                    case 2:
                        this.showCircleTwo();
                        break;
                    case 3:
                        this.showCircleThree();
                        break;
                    case 4:
                        this.showCircleFour();
                        break;
                    case 5:
                        this.showCircleFive();
                        break;
                    case 6:
                        this.showCircleSix();
                        break;
                    case 7:
                        this.showCircleSeven();
                        break;
                    case 8:
                        this.showCircleEight();
                        break;
                    case 9:
                        this.showCircleNine();
                        break;
                    default:
                        System.out.println("Impossible choice");
                        break;
                }
                currentPlayer = "X";
                this.filledSquares[this.filledSquaresCounter] = squarePosition;
                this.filledCircles[this.filledCirclesCounter] = squarePosition;
                this.filledSquaresCounter++;
                this.filledCirclesCounter++;
                if(this.checkVictory()) {
                    this.endGame();
                }
                }


    }

    public void openX(int squarePosition){
        if(!isAlreadySelectedBox(squarePosition) && this.allowMoves == true){
                    switch(squarePosition) {
                    case 1:
                        this.showXOne();
                        break;
                    case 2:
                        this.showXTwo();
                        break;
                    case 3:
                        this.showXThree();
                        break;
                    case 4:
                        this.showXFour();
                        break;
                    case 5:
                        this.showXFive();
                        break;
                    case 6:
                        this.showXSix();
                        break;
                    case 7:
                        this.showXSeven();
                        break;
                    case 8:
                        this.showXEight();
                        break;
                    case 9:
                        this.showXNine();
                        break;
                    default:
                        System.out.println("Impossible choice");
                        break;
                }

                this.filledSquares[this.filledSquaresCounter] = squarePosition;
                this.filledCircles[this.filledXCounter] = squarePosition;
                this.filledSquaresCounter++;
                this.filledXCounter++;
                this.currentPlayer = "O";
                if(this.checkVictory()) {
                    this.endGame();
                }
                }}


    public boolean checkVictory() {
        int slotOcounter = 0;
        int slotXcounter = 0;
        if(this.filledSquaresCounter ==9){
            endGame();
        }
        if(this.filledCirclesCounter < 3 && this.filledXCounter < 3) {
            return false;
        }
        else{
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 2; j++){
                if(this.isOccupiedByCircle(winningPositions[i][j])){
                    slotOcounter ++;
                }
            }
            if (slotOcounter == 3){
                this.winningTeam = 'O';
                this.allowMoves = false;
                return true;
            }
        }


        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 2; j++){
                if(this.isOccupiedByX(winningPositions[i][j])){
                    slotXcounter ++;
                }
            }
            if (slotOcounter == 3){
                this.winningTeam = 'X';
                this.allowMoves = false;
                return true;
            }}
        }


        return false;
    }

    public boolean isOccupiedByCircle(int circlePosition) {
        boolean found = false;

        for(int filledCircle : this.filledCircles) {
            if(filledCircle == circlePosition) {
                found = true;
            }
        }

        return found == true;
    }

    public boolean isOccupiedByX(int xPosition) {
        boolean found = false;

        for(int filled : this.filledX) {
            if(filled == xPosition) {
                found = true;
            }
        }

        return found == true;
    }

    public void endGame() {
        this.allowMoves = false;

        if(this.tie == true) {
            this.lblMessages.setText("It was a tie!");
        } else if(String.valueOf(this.winningTeam).equals("O")) {
            this.lblMessages.setText("O is a winner!");
        } else if(String.valueOf(this.winningTeam).equals("X")) {
            this.lblMessages.setText("X is a winner!");
        }
    }



    public boolean isAlreadySelectedBox(int squareNumber) {
        boolean found = false;

        for(int filledSquare : this.filledSquares) {
            if(squareNumber == filledSquare) {
                found = true;
            }
        }

        return found == true;
    }


    @FXML
    public void handleResetButton(ActionEvent event) {
        this.CircleOne.setVisible(false);
        this.CircleTwo.setVisible(false);
        this.CircleThree.setVisible(false);
        this.CircleFour.setVisible(false);
        this.CircleFive.setVisible(false);
        this.CircleSix.setVisible(false);
        this.CircleSeven.setVisible(false);
        this.CircleEight.setVisible(false);
        this.CircleNine.setVisible(false);

        this.XOne.setVisible(false);
        this.XTwo.setVisible(false);
        this.XThree.setVisible(false);
        this.XFour.setVisible(false);
        this.XFive.setVisible(false);
        this.XSix.setVisible(false);
        this.XSeven.setVisible(false);
        this.XEight.setVisible(false);
        this.XNine.setVisible(false);

        this.winningTeam = 0;

        this.allowMoves = true;
        this.tie = false;

        this.lblMessages.setText("");

        this.filledSquares = new int[9];
        this.filledCircles = new int[5];
        this.filledX = new int[5];

        this.filledSquaresCounter = 0;
        this.filledCirclesCounter = 0;
        this.filledXCounter = 0;
        this.currentPlayer = "O";
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
