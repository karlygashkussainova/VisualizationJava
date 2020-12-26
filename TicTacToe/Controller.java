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
    final private int[][] winningPositions = {
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
    private String currentPlayer = "O";

    // Create activities when one of the squares appears
    @FXML
    public void onSquareOneClick(MouseEvent event) {
        if (currentPlayer.equals("O")){ //if it's first player's turn, open circle
            this.openO(1);}
        else if(currentPlayer.equals("X")){ //if it's second player's turn, open X
            this.openX(1);}}

    @FXML
    public void onSquareTwoClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(2);}
        else if(currentPlayer.equals("X")){
            this.openX(2);}}

    @FXML
    public void onSquareThreeClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(3);}
        else if(currentPlayer.equals("X")){
            this.openX(3);}}

    @FXML
    public void onSquareFourClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(4);}
        else if(currentPlayer.equals("X")){
            this.openX(4);}}

    @FXML
    public void onSquareFiveClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(5);}
        else if(currentPlayer.equals("X")){
            this.openX(5);}}

    @FXML
    public void onSquareSixClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(6);}
        else if(currentPlayer.equals("X")){
            this.openX(6);}}

    @FXML
    public void onSquareSevenClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(7);}
        else if(currentPlayer.equals("X")){
            this.openX(7);}}

    @FXML
    public void onSquareEightClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(8);}
        else if(currentPlayer.equals("X")){
            this.openX(8);}}

    @FXML
    public void onSquareNineClick(MouseEvent event) {
        if (currentPlayer.equals("O")){
            this.openO(9);}
        else if(currentPlayer.equals("X")){
            this.openX(9);}}

    // activate signs and make them visible
    public void showCircleOne() {        this.CircleOne.setVisible(true);    }
    public void showCircleTwo() {        this.CircleTwo.setVisible(true);    }
    public void showCircleThree() {        this.CircleThree.setVisible(true);    }
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

    public void openO(int squarePosition){// open the circle position
        if(!isSelectedSquare(squarePosition) && this.allowMoves == true){//activate one of the circles by the position of the square
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
                    break;}
            this.filledSquares[this.filledSquaresCounter] = squarePosition; //fill filled squares array with this position
            this.filledCircles[this.filledCirclesCounter] = squarePosition;// fill filled circles array with this position
            this.filledSquaresCounter++; //increase the counter of the squares
            this.filledCirclesCounter++;//increase the counter of the circles
            currentPlayer = "X"; // change the current player to X
            if(this.checkVictory()) {//check if anyone has won
                this.endGame();}}
        else if(this.filledSquaresCounter >= 9) {
            this.tie = true;
            this.endGame();}}

    public void openX(int squarePosition){
        if(!isSelectedSquare(squarePosition) && this.allowMoves == true){//activate one of the X-s by the position of the square
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
                    break;}
            this.filledSquares[this.filledSquaresCounter] = squarePosition;//fill filled squares array with this position
            this.filledCircles[this.filledXCounter] = squarePosition;//fill filled X-s array with this position
            this.filledSquaresCounter++;//increase the counter of the squares
            this.filledXCounter++;//increase the counter of the X-s
            this.currentPlayer = "O";//change the current player to O
            if(this.checkVictory()) {
                this.endGame();}}
        else if(this.filledSquaresCounter == 9) {
            this.tie = true;
            this.endGame();}}


    public boolean checkVictory() {//check if someone has already won
        if(this.filledCirclesCounter < 3 && this.filledXCounter < 3) {//in case there are only 2 moves, keep playing
            return false;}
        for(int[] filled : this.winningPositions) {
            int slotCounter = 0;
            for(int singleFilled : filled) {
                if(this.isOccupiedByX(singleFilled)) {//check if the X-s has occupied the winning positions
                    slotCounter++;}}
            if(slotCounter == 3) {
                this.winningTeam = 'X';
                this.allowMoves = false;
                return true;}
            slotCounter = 0;
            for(int singleFilled : filled) {
                if(this.isOccupiedByCircle(singleFilled)) {//check if the circles has occupied the winning positions
                    slotCounter++;}}
            if(slotCounter == 3) {
                this.winningTeam = 'O';
                this.allowMoves = false;
                return true;}}
        return false;}


    public boolean isOccupiedByCircle(int circlePosition) {//check if the square is occupied by circle
        boolean found = false;
        for(int filledCircle : this.filledCircles) {
            if(filledCircle == circlePosition) {
                found = true;}}
        return found;}

    public boolean isOccupiedByX(int xPosition) {//check if the square is occupied by X-s
        boolean found = false;
        for(int filled : this.filledX) {
            if(filled == xPosition) {
                found = true;}}
        return found;}

    public void endGame() { //print necessary output results
        this.allowMoves = false;
        if(this.tie == true) {
            this.resultTextLabel.setText("It was a tie!");
        } else if(String.valueOf(this.winningTeam).equals("O")) {
            this.resultTextLabel.setText("Game is over!");
        } else if(String.valueOf(this.winningTeam).equals("X")) {
            this.resultTextLabel.setText("Game is over!");}}


    public boolean isSelectedSquare(int squarePosition) {//check if the square is already selected
        boolean found = false;
        for(int filledSquare : this.filledSquares) {
            if(squarePosition == filledSquare) {
                found = true;}}
        return found;}

    @FXML
    public void onResetPressedButton(ActionEvent event) {//set all of the values to their initial points to restart the game
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
        this.filledXCounter = 0;
        this.currentPlayer = "O";
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
