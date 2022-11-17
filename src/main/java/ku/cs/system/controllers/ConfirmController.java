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
import ku.cs.system.models.CO;
import ku.cs.system.models.DO;
import ku.cs.system.models.Product;
import ku.cs.system.services.CODataAccessor;
import ku.cs.system.services.DODataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ConfirmController {
    @FXML
    private TableView<DO> doTableView;
    @FXML
    private Label amountLabel;
    @FXML
    private TableColumn<DO, String> idColumn;
    @FXML
    private TableColumn<DO, String> co_idColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private TableColumn<DO, String> priceColumn;
    @FXML
    private Label priceLabel;
    @FXML
    private Label statusLabel;
    private ObservableList<DO> DOObservableList;
    private CODataAccessor coDataAccessor;
    private DODataAccessor doDataAccessor;
    private List<CO> coList;
    private List<DO> doList;
    private CO selectedCO;
    private DO selectedDO;
    @FXML void initialize() throws SQLException, ClassNotFoundException {
        statusLabel.setText("");
        coDataAccessor = new CODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        doDataAccessor = new DODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        coList = coDataAccessor.getCOList();
        doList = doDataAccessor.getDOListOnGoing();
        nameLabel.setText("None");
        priceLabel.setText("None");
        amountLabel.setText("None");
        showDOData();
        doTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showSelectedDO(newValue);
            }
        });
    }

    @FXML
    public void clickConfirm(){
        try{
            doDataAccessor.updateStatus(selectedDO.getDO_ID());
            statusLabel.setText("Change confirmation successfully");
            statusLabel.setStyle("-fx-text-fill: #42ed6a;");
        } catch (Exception e) {
            statusLabel.setText("Change confirmation failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        }
    }

    public void showDOData(){
        DOObservableList = FXCollections.observableArrayList(doList);
        doTableView.setItems(DOObservableList);
        idColumn.setCellValueFactory(new PropertyValueFactory<DO, String>("DO_ID"));
        co_idColumn.setCellValueFactory(new PropertyValueFactory<DO, String>("CO_ID"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<DO, String>("DO_Price"));
    }

    public void showSelectedDO(DO delivery){
        int id = delivery.getCO_ID();
        selectedDO = delivery;
        selectedCO = coList.get(id-1);
        nameLabel.setText(selectedCO.getCO_Prod());
        priceLabel.setText(""+selectedCO.getCO_Price());
        amountLabel.setText(""+selectedCO.getCO_Amount());
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
            FXRouter.goTo("createSupplier");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createSupplier ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createSupplier");
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("checkCustomer", "buy");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด checkCustomer");
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            FXRouter.goTo("checkCustomer", "pre");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด checkCustomer");
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
}
