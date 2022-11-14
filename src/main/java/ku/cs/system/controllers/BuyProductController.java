package ku.cs.system.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;

import java.io.IOException;
import java.util.List;

public class BuyProductController {
    @FXML
    private TableColumn<Product, String> amountColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> priceColumn;

    @FXML
    private TableView<Product> productTableView;
    @FXML
    Label nameLabel;
    @FXML
    Label priceLabel;
    @FXML
    Label amountLabel;
    private Product selectedProduct;
    private ObservableList<Product> productObservableList;
    private List<Product> products;

    @FXML void initialize(){
        nameLabel.setText("");
        priceLabel.setText("");
        amountLabel.setText("");
        productTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showSelectedProduct(newValue);
            }
        });
    }

    public void showProductData(){
        productObservableList = FXCollections.observableArrayList(products);
        productTableView.setItems(productObservableList);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("username"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("timeLogin"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("timeLogin"));
    }

    public void showSelectedProduct(Product product){
        selectedProduct = product;
        nameLabel.setText(selectedProduct.getP_Name());
        priceLabel.setText(""+selectedProduct.getP_Price());
        amountLabel.setText(""+selectedProduct.getP_Amount());
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
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
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
