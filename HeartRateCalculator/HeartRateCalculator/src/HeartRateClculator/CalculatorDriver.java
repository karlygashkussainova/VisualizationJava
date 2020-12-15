package HeartRateClculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorDriver extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HeartRateClculator.fxml"));
        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
