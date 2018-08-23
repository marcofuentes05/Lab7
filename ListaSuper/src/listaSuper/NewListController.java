package listaSuper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewListController {
    @FXML
    Button backButton;
    @FXML
    TextField nameField;
    @FXML
    TextArea descriptionField;
    @FXML
    Button newListButton;
/*
    @FXML
    void backButtonActionHandle(ActionEvent event){
        try{
            FXMLLoader fxmlloader  = new FXMLLoader(getClass().getResource("newList.fxml"));
            Parent root1 = (Parent) fxmlloader.load();
            Stage stage= new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root1));
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(Exception e){}

    }*/
}
