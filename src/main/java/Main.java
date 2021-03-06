import Services.ApplicationService;
import Services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserService.loadUsersFromFile();
        ApplicationService.loadApplicationsFromFile();

        Parent root= FXMLLoader.load((getClass().getClassLoader().getResource("LoginPage.fxml")));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
