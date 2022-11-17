package ku.cs.system.services;

import ku.cs.system.models.DO;
import ku.cs.system.models.Product;
import ku.cs.system.models.SO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DODataAccessor {
    private Connection connection;

    public DODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<DO> getDOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM do");
        ){
            List<DO> doList = new ArrayList<>();
            while(resultSet.next()){
                int do_id = Integer.parseInt(resultSet.getString("DO_ID"));
                int co_id = Integer.parseInt(resultSet.getString("CO_ID"));
                float price = Float.parseFloat(resultSet.getString("DO_Price"));
                String status = resultSet.getString("DO_Status");
                DO delivery = new DO(do_id, co_id, price, status);
                doList.add(delivery);
            }
            return doList;
        }
    }

    public List<DO> getDOListOnGoing() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM do WHERE DO_Status = 'On Going'");
        ){
            List<DO> doList = new ArrayList<>();
            while(resultSet.next()){
                int do_id = Integer.parseInt(resultSet.getString("DO_ID"));
                int co_id = Integer.parseInt(resultSet.getString("CO_ID"));
                float price = Float.parseFloat(resultSet.getString("DO_Price"));
                String status = resultSet.getString("DO_Status");
                DO delivery = new DO(do_id, co_id, price, status);
                doList.add(delivery);
            }
            return doList;
        }
    }

    public void insertDO(DO delivery) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int do_ID = delivery.getDO_ID();
            int co_ID = delivery.getCO_ID();
            float price = delivery.getDO_Price();
            String status = delivery.getStatus();
            String query =
                    "INSERT INTO DO (DO_ID, CO_ID, DO_Price, DO_Status) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, do_ID);
            preparedStatement.setInt(2, co_ID);
            preparedStatement.setFloat(3, price);
            preparedStatement.setString(4, status);

            preparedStatement.executeUpdate();

            System.out.println("add DO successfully!");
        }catch (Exception e){
            System.out.println("add DO failed!");
        }
    }

    public void updateStatus(int id){
        PreparedStatement preparedStatement=null;
        try{
            String query = "UPDATE DO set DO_Status = ? WHERE DO_ID = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "Done");
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            System.out.println("Update DO successfully!");
        } catch (SQLException e) {
            System.out.println("Update DO failed!");
        }
    }
}
