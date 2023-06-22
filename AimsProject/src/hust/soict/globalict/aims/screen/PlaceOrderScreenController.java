package hust.soict.globalict.aims.screen;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.globalict.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PlaceOrderScreenController implements Initializable{

   private Cart cart;

   public Cart getCart() {
      return cart;
   }

   public PlaceOrderScreenController(Cart cart) {
      this.cart = cart;
   }

   @FXML
   private Button btnCancel;

   @FXML
   private Button btnConfirm;

   @FXML
   private VBox root;

   @FXML
   void tbnCancelPressed(ActionEvent event) {
      
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      
   }
   

}
