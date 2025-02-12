package Repository;

import DB.SQLConnect;
import Model.Account;
import Model.Category;
import Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryRepository {
    private static Connection connexion = SQLConnect.getConnexion();

    public static void addCategory(Category category) {
        //instancier un Objet User null
        Category categoryAdded = null;
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "INSERT INTO category (name) " + "VALUES (?)";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            preparedStatement.setString(1, category.getName());

            //Exécution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //test si l'enregistrement est ok
            if (addedRows > 0) {
                //Création d'un Objet User
                categoryAdded = new Category();
                categoryAdded.setName(category.getName());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Category> getAllCategories(){
        ArrayList<Category> categoryList = new ArrayList<>();
        Category categoryGet = null;
        try{
            // Connection à la BDD ...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "SELECT id, name FROM category";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                //Si la réponse est différente de null
                if (rs.getString(1)!= null){
                    categoryGet = new Category();
                    categoryGet.setId(rs.getInt("id"));
                    categoryGet.setName(rs.getString("name"));
                    categoryList.add(categoryGet);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return categoryList;
    }
}
