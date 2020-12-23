package HeartRateClculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class HeartRateDriver {

    @FXML    private TextField ageTextField;
    @FXML    private TextField maxRateTextField;
    @FXML    private TextField targetRateTextField;
    @FXML    private Button okButton;
    @FXML
    void onButtonPressed(ActionEvent event) { //when button pressed
        try{
            int age = Integer.parseInt(ageTextField.getText());
            int maxRate = 220 - age;
            int lowerBound = (int) (maxRate * 0.5);
            int upperBound = (int) (maxRate * 0.85);
            maxRateTextField.setText(String.valueOf(maxRate));
            targetRateTextField.setText(String.valueOf(lowerBound) + "-" + String.valueOf(upperBound));
        }
        catch (NumberFormatException e){
            ageTextField.setText("Enter age");
            ageTextField.selectAll();
            ageTextField.requestFocus();
        }
    }

    public void onButtonPressed(javafx.event.ActionEvent actionEvent) {
        try{
            int age = Integer.parseInt(ageTextField.getText());
            int maxRate = 220 - age;
            int lowerBound = (int) (maxRate * 0.5);
            int upperBound = (int) (maxRate * 0.85);
            maxRateTextField.setText(String.valueOf(maxRate));
            targetRateTextField.setText(String.valueOf(lowerBound) + "-" + String.valueOf(upperBound));
        }
        catch (NumberFormatException e){
            ageTextField.setText("Enter age");
            ageTextField.selectAll();
            ageTextField.requestFocus();
        }
    }
}
