package ku.cs.system.services;


import ku.cs.system.models.SO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SODataAccessor {
    private Connection connection;

    public SODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<SO> getSOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM supplyorder");
        ){
            List<SO> soList = new ArrayList<>();
            while(resultSet.next()){
                int SO_ID = Integer.parseInt(resultSet.getString("SO_ID"));
                int S_ID = Integer.parseInt(resultSet.getString("S_ID"));
                int P_ID = Integer.parseInt(resultSet.getString("P_ID"));
                float cost = Float.parseFloat(resultSet.getString("SO_Cost"));
                int amount = Integer.parseInt(resultSet.getString("SO_Amount"));
                SO so = new SO(SO_ID, S_ID, P_ID, cost, amount);
                soList.add(so);
            }
            return soList;
        }
    }

    public void insertSO(SO so) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int SO_ID = so.getSO_ID();
            int s_ID = so.getS_ID();
            int p_ID = so.getP_ID();
            float SO_Cost = so.getSO_Cost();
            int SO_Amount = so.getSO_Amount();
            String query =
                    "INSERT INTO SUPPLYORDER (SO_ID, S_ID, P_ID, SO_COST, SO_Amount) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,SO_ID);
            preparedStatement.setInt(2,s_ID);
            preparedStatement.setInt(3,p_ID);
            preparedStatement.setFloat(4,SO_Cost);
            preparedStatement.setInt(5,SO_Amount);

            preparedStatement.executeUpdate();

            System.out.println("add SO successfully!");
        }catch (Exception e){
            System.out.println("add SO failed!");
        }
    }
}
