package listaSuper;

import clases.ShoppingItem;
import clases.ShoppingList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NewItemController {
    @FXML
    Button newItemButton;
    @FXML
    Button backButton;
    @FXML
    TextField nameField;
    @FXML
    TextField amountField;
    @FXML
    TextField prizeField;

    @FXML
    public void backButtonAction (Event e){
        try{
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("myList.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Editor");
                stage.setScene(new Scene(root, 600, 400));
                MyListController myListController = loader.getController();
                ShoppingList selectedList = myListController.selectedList;
                myListController.setSelectedList(selectedList);

                myListController.setTitle(selectedList.getName());
                stage.show();
            }catch(Exception z){}

            // get a handle to the stage
            Stage stage = (Stage) backButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        }catch(Exception e1){}
    }

    @FXML
    public void createButtonAction (Event e){
        String nombre = nameField.getText();
        try{
            String cantidad1 = (amountField.getText());
            String precio1 = (prizeField.getText());

            Parent root;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("myListController.fxml"));
            root = loader.load();
            MyListController myListController = loader.getController();

            ShoppingList selectedList = NewListController.getSelectedList();

            if (selectedList!=null){
                int cantidad = Integer.parseInt(cantidad1);
                double precio = Double.parseDouble(precio1);
                selectedList.getList().add(new ShoppingItem(nombre, cantidad, precio));
            }else{
                System.out.println("Algo salió mal...");
            }


        }catch(Exception e0){
            e0.printStackTrace();
            System.out.println("No ingresaste correctamente los datos!");
        }

    }
}
