package painter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML    private Slider redSlider;
    @FXML    private TextField redTextField;
    @FXML    private Slider blueSlider;
    @FXML    private TextField blueTextField;
    @FXML    private Slider greenSlider;
    @FXML    private TextField greenTextField;
    @FXML    private Rectangle rectangleShape;
    @FXML    private RadioButton smallRadioButton;
    @FXML    private ToggleGroup sizeToggleGroup;
    @FXML    private RadioButton mediumRadioButton;
    @FXML    private RadioButton largeRadioButton;
    @FXML    private Button undoButton;
    @FXML    private Button clearButton;
    @FXML    private Pane drawingreaPane;

    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private final int radius;
        PenSize(int radius){
            this.radius = radius;
        }

        public int getRadius(){
            return radius;
        }
    };

    private PenSize radius = PenSize.MEDIUM;
    private Color brushColor = Color.BLACK;
    private int red = 0;
    private int green = 0;
    private int blue = 0;

    public void initialize(){
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);

        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bind(
                redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(
                greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(
                blueSlider.valueProperty().asString("%.0f"));


        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        rectangleShape.setFill(Color.rgb(red, green, blue));
                        brushColor = Color.rgb(red, green, blue);
                    }

                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        rectangleShape.setFill(Color.rgb(red, green, blue));
                        brushColor = Color.rgb(red, green, blue);
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        rectangleShape.setFill(Color.rgb(red, green, blue));
                        brushColor = Color.rgb(red, green, blue);
                    }
                }
        );



    }

    @FXML
    void clearButtoPressed(ActionEvent event) {
        drawingreaPane.getChildren().clear();

    }

    @FXML
    void colorRadioButtonSelected(MouseEvent event) {
        //brushColor =  (Color) colorToggleGroup.getSelectedToggle().getUserData();

    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        drawingreaPane.getChildren().add(newCircle);

    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();

    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = drawingreaPane.getChildren().size();

        if (count > 0){
            drawingreaPane.getChildren().remove(count-1);
        }

    }

}
