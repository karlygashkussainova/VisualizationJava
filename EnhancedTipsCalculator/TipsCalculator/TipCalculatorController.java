package TipsCalculator;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;
import java.text.NumberFormat;

public class TipCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    @FXML
    private Label amountLabel;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private Button calculateButton;

    @FXML
    private Label partyMembersLabel;

    @FXML
    private TextField partyMembersTextField;

    @FXML
    private TextField paidByEveryoneTextField;


    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal partyMembers = new BigDecimal(partyMembersTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            BigDecimal paidByEveryone = total.divide(partyMembers);


            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
            paidByEveryoneTextField.setText(currency.format(paidByEveryone));

        }
        catch (NumberFormatException e){
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }

    }

    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        tipPercentageSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                        tipPercentageLabel.setText(percent.format(tipPercentage));
                    }
                }
        );

    }

}
