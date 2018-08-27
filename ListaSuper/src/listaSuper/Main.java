package listaSuper;

import clases.ShoppingList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
        primaryStage.setTitle("Control de Listas de Compras");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    //Lista de objetos ShoppingList principal
    public static ArrayList<ShoppingList> lista = new ArrayList<ShoppingList>();



    public static void main(String[] args) {

        launch(args);
    }
}
