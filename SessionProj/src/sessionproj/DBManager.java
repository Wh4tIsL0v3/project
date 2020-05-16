package sessionproj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/drugs?useUnicode=true&serverTimezone=UTC","root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDrug(Drug drug){
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO drug (id, name, price, count) " +
                    "VALUES (NULL, ?, ?, ?)"
            );
            statement.setString(1, drug.getName());
            statement.setDouble(2, drug.getPrice());
            statement.setInt(3, drug.getCount());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void buyDrug(int count, String name, double price){
        ArrayList<Drug> drugList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM drug");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                double Price = resultSet.getInt("price");
                Integer Count = resultSet.getInt("count");

                drugList.add(new Drug(id, Name, Price, Count));
            }
            for(int i = 0; i < drugList.size(); i++){
                
            }
            statement.close();
        } catch (Exception e) {
        }
    }
    public ArrayList<Drug> getAllDrugs(){
        ArrayList<Drug> drugList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM drug");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getInt("price");
                Integer count = resultSet.getInt("count");

                drugList.add(new Drug(id, name, price, count));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return drugList;
    }
    /*
    public void deleteDrug(Integer id){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM drug WHERE id = ?");
        } catch (Exception e) {
        }
    }
    */
}
