package BMI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class BMI extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BMI.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("BMI calculator");
        stage.setScene(scene);
        stage.show();}


    public static void main(String[] args) {
        launch(args);
    }
}
