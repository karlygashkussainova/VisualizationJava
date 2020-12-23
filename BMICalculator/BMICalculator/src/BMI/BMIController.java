package BMI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BMIController {

    @FXML    private Button metricsButton;
    @FXML    private Button englishButton;
    @FXML    private TextField weightMetricsTextField;
    @FXML    private TextField heightMetricsTextField;
    @FXML    private TextField weightEnglishTextField;
    @FXML    private TextField heightEnglishTextField;
    @FXML    private TextField bmiValueTextField;
    
    @FXML
    void onEnglishPressed(ActionEvent event) { //When use Button for english metrics
        try{
            double bmiIndex;
            double weight = Double.parseDouble(weightEnglishTextField.getText());
            double height = Double.parseDouble(heightEnglishTextField.getText());
            bmiIndex = (703 * weight) / (height * height);

            if (bmiIndex <= 18.5){
                bmiValueTextField.setText("Underweight");
            }
            else if (bmiIndex <= 24.9){
                bmiValueTextField.setText("Normal");
            }
            else if (bmiIndex <= 29.9){
                bmiValueTextField.setText("Overweight");
            }
            else if (bmiIndex > 30.0){
                bmiValueTextField.setText("Obese");
            }

        }
        catch (NumberFormatException e){
            weightEnglishTextField.setText("Enter weight");
            weightEnglishTextField.selectAll();
            weightEnglishTextField.requestFocus();

            heightEnglishTextField.setText("Enter height");
            heightEnglishTextField.selectAll();
            heightEnglishTextField.requestFocus();
        }

    }

    @FXML
    void onMetricsPressed(ActionEvent event) { //When standart metrics are chosen
        try{
            double bmiIndex;
            double weight = Double.parseDouble(weightMetricsTextField.getText());
            double height = Double.parseDouble(heightMetricsTextField.getText());
            bmiIndex = (weight) / (height * height);

            if (bmiIndex <= 18.5){
                bmiValueTextField.setText("Underweight");
            }
            else if (bmiIndex <= 24.9){
                bmiValueTextField.setText("Normal");
            }
            else if (bmiIndex <= 29.9){
                bmiValueTextField.setText("Overweight");
            }
            else if (bmiIndex > 30.0){
                bmiValueTextField.setText("Obese");
            }

        }
        catch (NumberFormatException e){
            weightMetricsTextField.setText("Enter weight");
            weightMetricsTextField.selectAll();
            weightMetricsTextField.requestFocus();

            heightMetricsTextField.setText("Enter height");
            heightMetricsTextField.selectAll();
            heightMetricsTextField.requestFocus();
        }

    }

}
