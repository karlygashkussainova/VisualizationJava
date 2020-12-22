package coverViewer;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoverViewerController {

    @FXML    private ListView<Book> booksListView;
    @FXML    private ImageView coverImageView;

    private final ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize(){
        books.add(new Book("Harry Potter", "coverViewer/Images/Images/HarryPotter.jpg"));
        books.add(new Book("JAWS", "coverViewer/Images/Images/Jaws.jpg"));
        books.add(new Book("Little Prince", "coverViewer/Images/Images/LittlePrince.jpg"));
        books.add(new Book("Gatsby", "coverViewer/Images/Images/GreaGatsby.jpg"));

        booksListView.setItems(books);

        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book oldValue, Book newValue) {
                coverImageView.setImage(new Image(newValue.getImage()));
            }
        });
    }


}
