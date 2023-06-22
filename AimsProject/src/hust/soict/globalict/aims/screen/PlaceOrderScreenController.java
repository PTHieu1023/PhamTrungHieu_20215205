package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlaceOrderScreenController {

   private Cart cart;

   @FXML
   private Button btnCancel;

   @FXML
   private Button btnConfirm;

   @FXML
   private VBox root;

   @FXML
   private Label tfTotalPay;

   @FXML
   void tbnCancelPressed(ActionEvent event) {

   }

   public PlaceOrderScreenController(Cart cart) {
      this.cart = cart;
   }

   public void setTotalPayText() {
      tfTotalPay.setText("Total pay: " + cart.totalCost() + " $");
   }
}
