package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;
import ku.cs.system.services.ProductService;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddProductController {

    @FXML
    Label amountLabel;

    @FXML
    TextField IDField;

    @FXML
    TextField amountField;

    @FXML
    Label nameLabel;

    @FXML
    Label priceLabel;

    @FXML
    Label statusLabel;
    private ProductService service = new ProductService();
    private List<Product> products = new ArrayList();
    private Product product;

    @FXML
    public void initialize(){
        nameLabel.setText("");
        priceLabel.setText("");
        amountLabel.setText("");
        statusLabel.setText("");
        products = service.getAll();
    }

    @FXML
    public void clickFindProduct(ActionEvent actionEvent){
        int id = Integer.parseInt(IDField.getText());
        product = service.getProduct(id);
        nameLabel.setText(product.getP_Name());
        priceLabel.setText(""+product.getP_Price());
        amountLabel.setText(""+product.getP_Amount());
        System.out.println(product.getP_Name());
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        int amount = Integer.parseInt(amountField.getText());
        product.setP_Amount(product.AddProduct(amount));
        try {
            service.create(product);
        }
        catch (RuntimeException r) {
            System.out.println(r);
        }
        statusLabel.setText("เพิ่มสินค้าสำเร็จ");
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            FXRouter.goTo("supply");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า supply ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด supply");
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("createProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createProduct");
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("buyProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า buyProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            FXRouter.goTo("pre_order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า pre_order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด pre_order");
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        }
    }
}
