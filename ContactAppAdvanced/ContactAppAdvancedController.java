package ContactAppAdvanced;

import Contacts.Students;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.Collections;
import java.util.Comparator;

public class ContactAppAdvancedController {

    @FXML    private ListView<Student> studentsListView;
    @FXML    private ImageView avatarImageView;
    @FXML    private TextField nameTextField;
    @FXML    private TextField secondNameTextField;
    @FXML    private TextField emailTextFiled;
    @FXML    private TextField phoneTextField;
    @FXML    private TextField majorTextField;
    @FXML    private Button addButton;
    @FXML    private Button deleteButton;
    @FXML    private Button clearButton;
    @FXML    private TextField imagePathTextField;


    private final ObservableList<Student> students = FXCollections.observableArrayList();

    public void initialize(){
        students.add(new Student("Adelina", "Almazova", "almazova@gmail.com", "06679954","CS", "ContactAppAdvanced/Images/ImagesContacts/Adelina.jpeg"));
        students.add(new Student("Eldiiar", "Dzhunusov", "eliiar@gmail.com", "06665435", "CS","ContactAppAdvanced/Images/ImagesContacts/Eldiiar.jpeg"));
        students.add(new Student("Zarastin", "Kholbash", "kholbash_2021ucentralasia.org", "+99234563356","Coms and Media","ContactAppAdvanced/Images/ImagesContacts/Zarastin.jpeg"));
        students.add(new Student("Iskender", "Berdiev", "berdiev@mail.ru", "+996445335", "CS","ContactAppAdvanced/Images/ImagesContacts/Iskender.jpeg"));
        students.add(new Student("Zere", "Anuarbekova", "zere_98@mail.ru", "+77074457788", "Medicine","ContactAppAdvanced/Images/ImagesContacts/Zere.jpeg"));
        //Collections.sort(students);
        students.stream().sorted().map((s -> s.getLastName()));

        studentsListView.setItems(students);

        // when ListView selection changes, show large cover in ImageView
        studentsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Student>() {
                            @Override
                            public void changed(ObservableValue<? extends Student> ov, Student oldValue, Student t1) {
                                avatarImageView.setImage(new Image(t1.getImage()));
                                nameTextField.setText(t1.getName());
                                secondNameTextField.setText(t1.getLastName());
                                emailTextFiled.setText(t1.getEmail());
                                phoneTextField.setText(t1.getPhone());
                                majorTextField.setText(t1.getMajor());

                            }
                        }
                );

        // set custom ListView cell factory
        studentsListView.setCellFactory(
                new Callback<ListView<Student>, ListCell<Student>>() {
                    @Override
                    public ListCell<Student> call(ListView<Student> listView) {
                        return new ImageTextCell();
                    }
                }
        );



    }



    @FXML    void onAddPressed(ActionEvent event) {
        students.add(new Student(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(),majorTextField.getText(), imagePathTextField.getText()));
        studentsListView.setItems(students);
    }

    @FXML
    void onCLearPressed(ActionEvent event) {
        nameTextField.setText("");
        secondNameTextField.setText("");
        emailTextFiled.setText("");
        phoneTextField.setText("");
        majorTextField.setText("");
        imagePathTextField.setText("");

    }

    @FXML
    void onDeletePressed(ActionEvent event) {
        Student student = new Student(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(),majorTextField.getText(), imagePathTextField.getText());
        students.removeIf(i-> i.getName().equals(student.getName()) && i.getLastName().equals(student.getLastName()) && i.getEmail().equals(student.getEmail()) && i.getPhone().equals(student.getPhone()) && i.getMajor().equals(student.getMajor()) && i.getImage().equals(student.getImage()));
        studentsListView.setItems(students);

    }

}
