package lk.ijse.rentabike;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/WelcomePageForm.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Welcome");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }
}
