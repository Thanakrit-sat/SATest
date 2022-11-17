package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Customer;
import ku.cs.system.services.CustomerDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NewCustomerController {
    @FXML
    private TextField addressField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label statusLabel;
    private CustomerDataAccessor customerDataAccessor;
    private List<Customer> customers;
    private Customer customer;
    String check;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        customerDataAccessor = new CustomerDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        customers = customerDataAccessor.getCustomers();
        statusLabel.setText("");
        check = (String) FXRouter.getData();
    }

    @FXML
    public void clickAddCustomer(){
        int id = customers.size() + 1;
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        if(name.isBlank() || phone.isBlank() || address.isBlank()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        customer = new Customer(id, name, phone, address);
        try {
            customerDataAccessor.insertCustomer(customer);
            customerDataAccessor.shutdown();
            if(check.equals("buy"))
                FXRouter.goTo("buyProduct", id);
            else if (check.equals("pre"))
                FXRouter.goTo("pre_order", id);
            else
                return;
        } catch (SQLException e) {
            statusLabel.setText("Add customer to DB failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า buyProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("supply");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า supply ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด supply");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("createSupplier");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createSupplier ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createSupplier");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("checkCustomer", "pre");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด pre_order");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            customerDataAccessor.shutdown();
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
