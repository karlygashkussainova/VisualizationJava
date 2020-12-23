package Contacts;

import coverViewer.Book;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ContactAppController {

    @FXML    private TextField nameTextField;
    @FXML    private TextField secondNameTextField;
    @FXML    private TextField emailTextFiled;
    @FXML    private TextField phoneTextField;
    @FXML    private TextField majorTextField;
    @FXML    private Button updateButton;
    @FXML    private Button deleteButton;
    @FXML    private Button addButton;
    @FXML    private ListView studentsListView;

    private final ObservableList<Students> students = FXCollections.observableArrayList();

    public void initialize(){ //initialize and populate listView with some vallues
        students.add(new Students("Adelina", "Almazova", "almazova@gmail.com", "06679954","CS"));
        students.add(new Students("Eldiiar", "Dzhunusov", "eliiar@gmail.com", "06665435", "CS"));
        students.add(new Students("Zarastin", "Kholbash", "kholbash_2021ucentralasia.org", "+99234563356","Coms and Media"));
        students.add(new Students("Iskender", "Berdiev", "berdiev@mail.ru", "+996445335", "CS"));
        students.add(new Students("Zere", "Anuarbekova", "zere_98@mail.ru", "+77074457788", "Medicine"));
        studentsListView.setItems(students);

        studentsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Students>() { //function of the studentView
            @Override
            public void changed(ObservableValue<? extends Students> observableValue, Students students, Students t1) { 
                nameTextField.setText(t1.getName());
                secondNameTextField.setText(t1.getLastName());
                emailTextFiled.setText(t1.getEmail());
                phoneTextField.setText(t1.getPhone());
                majorTextField.setText(t1.getMajor());
            }
        });

    }
    @FXML
    void onUpdatePressed(ActionEvent event) { //when press on Add button
        students.add(new Students(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(),majorTextField.getText()));
        studentsListView.setItems(students);
    }

    @FXML
    void onDeletePressed(ActionEvent event) { //when press on delete button
        Students student = new Students(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(),majorTextField.getText());
        students.removeIf(i-> i.getName().equals(student.getName()) && i.getLastName().equals(student.getLastName()) && i.getEmail().equals(student.getEmail()) && i.getPhone().equals(student.getPhone()) && i.getMajor().equals(student.getMajor()));
        studentsListView.setItems(students);

    }
    @FXML
    void onCLearPressed(ActionEvent event) { //when press on clear button
        nameTextField.setText("");
        secondNameTextField.setText("");
        emailTextFiled.setText("");
        phoneTextField.setText("");
        majorTextField.setText("");



    }

}
