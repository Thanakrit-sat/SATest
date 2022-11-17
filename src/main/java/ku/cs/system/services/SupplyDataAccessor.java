package ku.cs.system.services;

import ku.cs.system.models.SO;
import ku.cs.system.models.Supply;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplyDataAccessor {
    private Connection connection;

    public SupplyDataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Supply> getSupplyList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM supply");
        ){
            List<Supply> soList = new ArrayList<>();
            while(resultSet.next()){
                int S_ID = Integer.parseInt(resultSet.getString("S_ID"));
                int P_ID =  Integer.parseInt(resultSet.getString("P_ID"));
                String name = resultSet.getString("S_Name");
                String phone = resultSet.getString("S_Phone");
                String address = resultSet.getString("S_Address");
                Supply supply = new Supply(S_ID, P_ID, name, phone, address);
                soList.add(supply);
            }
            return soList;
        }
    }

    public void insertSupply(Supply supply) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int s_ID = supply.getS_ID();
            int p_ID = supply.getP_ID();
            String name = supply.getS_Name();
            String phone = supply.getS_Phone();
            String address = supply.getS_Address();

            String query =
                    "INSERT INTO SUPPLY (S_ID, P_ID, S_Name, S_Phone, S_Address) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,s_ID);
            preparedStatement.setInt(2,p_ID);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,address);

            preparedStatement.executeUpdate();

            System.out.println("add Supplier successfully!");
        }catch (Exception e){
            System.out.println("add Supplier failed!");
        }
    }
}
