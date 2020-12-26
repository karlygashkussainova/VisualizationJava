package TicTacToe;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class TicTacToeController implements Initializable {
    @FXML    private Circle CircleOne;
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
    @FXML    private Label resultTextLabel;

    private int[] filledSquares = new int[9]; //create space for the filled squares regardless their sign
    private int[] filledCircles = new int[5];// create 5 spots for circles
    private int[] filledX = new int[5]; //create 5 spots for X-s
    private int filledSquaresCounter = 0;
    private int filledCirclesCounter = 0;
    private int filledXCounter = 0;
    private char winningTeam;
    final private int[][] winningPositions = { //declare winning positions
            {1, 5, 9},
            {3, 5, 7},
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}};
    private boolean allowMoves = true;
    private boolean tie = false;

    // Create activities when one of the squares appears
    @FXML    public void onSquareOneClick(MouseEvent event) {this.onSquareClick(1); }
    @FXML    public void onSquareTwoClick(MouseEvent event) {this.onSquareClick(2);    }
    @FXML    public void onSquareThreeClick(MouseEvent event) {this.onSquareClick(3);    }
    @FXML    public void onSquareFourClick(MouseEvent event) {this.onSquareClick(4);    }
    @FXML    public void onSquareFiveClick(MouseEvent event) {this.onSquareClick(5);    }
    @FXML    public void onSquareSixClick(MouseEvent event) {this.onSquareClick(6);    }
    @FXML    public void onSquareSevenClick(MouseEvent event) {this.onSquareClick(7);    }
    @FXML    public void onSquareEightClick(MouseEvent event) {this.onSquareClick(8);    }
    @FXML    public void onSquareNineClick(MouseEvent event) {this.onSquareClick(9);    }

// activate signs and make them visible
    public void showCircleOne() {       this.CircleOne.setVisible(true);    }
    public void showCircleTwo() {       this.CircleTwo.setVisible(true);    }
    public void showCircleThree() {     this.CircleThree.setVisible(true);    }
    public void showCircleFour() {        this.CircleFour.setVisible(true);    }
    public void showCircleFive() {        this.CircleFive.setVisible(true);    }
    public void showCircleSix() {        this.CircleSix.setVisible(true);    }
    public void showCircleSeven() {        this.CircleSeven.setVisible(true);    }
    public void showCircleEight() {        this.CircleEight.setVisible(true);    }
    public void showCircleNine() {        this.CircleNine.setVisible(true);    }
    public void showXOne() {        this.XOne.setVisible(true);    }
    public void showXTwo() {        this.XTwo.setVisible(true);    }
    public void showXThree() {        this.XThree.setVisible(true);    }
    public void showXFour() {        this.XFour.setVisible(true);    }
    public void showXFive() {        this.XFive.setVisible(true);    }
    public void showXSix() {        this.XSix.setVisible(true);    }
    public void showXSeven() {        this.XSeven.setVisible(true);    }
    public void showXEight() {        this.XEight.setVisible(true);    }
    public void showXNine() {        this.XNine.setVisible(true);    }

    //activate your choice
    public void onSquareClick(int squarePosition) {
        if(!isSelectedSquare(squarePosition) && this.allowMoves == true) {
            switch(squarePosition) { //activate one of the circles by the position of the square
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
                    break;}
            this.filledSquares[this.filledSquaresCounter] = squarePosition;
            this.filledCircles[this.filledCirclesCounter] = squarePosition;
            this.filledSquaresCounter++;
            this.filledCirclesCounter++;
            if(this.checkVictory()) { //check if anyone has won
                this.endGame();}
            else {
                this.playRandomMove(); //randomly generate a new move
                if(this.checkVictory()) {
                    this.endGame(); }}} //end the game is someone has won
        else if(this.filledSquaresCounter >= 9) {
            this.tie = true; //activate tie
            this.endGame();}}

    public boolean isSelectedSquare(int squarePosition) { //check if the square is lready selected
        boolean found = false;
        for(int filledSquare : this.filledSquares) {
            if(squarePosition == filledSquare) {
                found = true;}}
        return found == true;}

    public boolean checkVictory() { //check if someone has already won
        if(this.filledCirclesCounter < 3 && this.filledXCounter < 3) { //in case there are only 2 moves, keep playing
            return false;}
        for(int[] filled : this.winningPositions) {
            int slotCounter = 0;
            for(int singleFilled : filled) {
                if(this.isOccupiedByCircle(singleFilled)) {//check if the circles has occupied the winning positions
                    slotCounter++;}}
            if(slotCounter == 3) {
                this.winningTeam = 'O';
                this.allowMoves = false;
                return true;}
            slotCounter = 0;
            for(int singleFilled : filled) {
                if(this.isOccupiedByX(singleFilled)) {//check if the X-s has occupied the winning positions
                    slotCounter++;}}
            if(slotCounter == 3) {
                this.winningTeam = 'X';
                this.allowMoves = false;
                return true;}}
        return false;}


    public void playRandomMove() { //generate a random move
        Random random = new Random();
        int result = random.nextInt(9 - 1 + 1) + 1;;
        if(this.filledSquaresCounter < 9) {
            while(this.isSelectedSquare(result)) {//show any square that has not been opened yet
                result = random.nextInt(9 - 1 + 1) + 1;}
            switch(result) {
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
                    break;}
            this.filledSquares[this.filledSquaresCounter] = result;
            this.filledX[this.filledXCounter] = result;
            this.filledSquaresCounter++;
            this.filledXCounter++;}
        else {this.tie = true;
            this.endGame(); }}


    public boolean isOccupiedByCircle(int circlePosition) {
        boolean found = false;
        for(int filledCircle : this.filledCircles) {//check if the square is occupied by circle
            if(filledCircle == circlePosition) {
                found = true;}}
        return found == true;}

    public boolean isOccupiedByX(int xPosition) {
        boolean found = false;
        for(int filled : this.filledX) {//check if the square is occupied by the X
            if(filled == xPosition) {
                found = true;}}
        return found;}

    public void endGame() { //print necessary output results
        this.allowMoves = false;
        if(this.tie == true) {
            this.resultTextLabel.setText("It was a tie!");
        } else if(String.valueOf(this.winningTeam).equals("O")) {
            this.resultTextLabel.setText("You win!");
        } else if(String.valueOf(this.winningTeam).equals("X")) {
            this.resultTextLabel.setText("You lost to X!");}}

    @FXML
    public void onResetPressedButton(ActionEvent event) { //set all of the values to their initial points to restart the game
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
        this.resultTextLabel.setText("");
        this.filledSquares = new int[9];
        this.filledCircles = new int[5];
        this.filledX = new int[5];
        this.filledSquaresCounter = 0;
        this.filledCirclesCounter = 0;
        this.filledXCounter = 0;}


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
