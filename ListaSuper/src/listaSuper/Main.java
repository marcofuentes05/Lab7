package listaSuper;

import clases.ShoppingItem;
import clases.ShoppingList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application{

    private static LocalDate date =java.time.LocalDate.now();
    public static ObservableList<ShoppingList> list = FXCollections.observableArrayList(
            new ShoppingList("Mercado",date,""),
            new ShoppingList("Walmart",date,""),
            new ShoppingList("Utiles",date,"")
    );


    @Override
    public void start(Stage primaryStage) throws Exception{
        list.get(0).getList().add(new ShoppingItem("Lapices",5,2.5));
        list.get(0).refresh();
        list.get(1).getList().add(new ShoppingItem("Carne",2,2.5));
        list.get(1).refresh();
        Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
        primaryStage.setTitle("Control de Listas de Compras");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static ObservableList<ShoppingList> getMainList(){
        return list;
    }
}
