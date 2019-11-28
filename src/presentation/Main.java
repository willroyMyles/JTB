package presentation;

import fileOperations.FileProcess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Parent root;
    public static Stage mainStage;

    private static Scene scene;
    private static Stage stage;
    private static FXMLLoader loader;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FileProcess.readPlacesFromFile();
        FileProcess.readRequestsFromFile();

        mainStage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 640, 405));
        primaryStage.show();
    }

    public static void  genericLoad(FXMLLoader fxmlLoader) {
        try {
            // System.out.println(root+" "+"this is from generic");

            root = fxmlLoader.load();
            // System.out.println(root+" "+"this is from generic");
            scene = new Scene(root, 560,450);
            mainStage.hide();
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
