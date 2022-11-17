package ku.cs.system.services;

import ku.cs.system.models.Customer;
import ku.cs.system.models.SO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataAccessor {
    private Connection connection;

    public CustomerDataAccessor(String dbURL, String user, String password) throws SQLException , ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Customer> getCustomers() throws SQLException{
        try(
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        ){
            List<Customer> customers = new ArrayList<>();
            while(resultSet.next()){
                int ID = Integer.parseInt(resultSet.getString("C_ID"));
                String name = resultSet.getString("C_Name");
                String phone = resultSet.getString("C_Phone");
                String address = resultSet.getString("C_Adress");
                Customer customer = new Customer(ID, name, phone, address);
                customers.add(customer);
            }
            return customers;
        }
    }

    public void insertCustomer(Customer customer) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int ID = customer.getC_ID();
            String name = customer.getC_Name();
            String phone = customer.getC_Phone();
            String address = customer.getC_Addrs();

            String query =
                    "INSERT INTO CUSTOMER (C_ID, C_Phone, C_Name, C_Adress) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, address);

            preparedStatement.executeUpdate();

            System.out.println("add Customer successfully!");
        }catch (Exception e){
            System.out.println("add Customer failed!");
        }
    }
}
