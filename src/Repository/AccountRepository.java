package Repository;

import DB.SQLConnect;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AccountRepository {
    private static Connection connexion = SQLConnect.getConnexion();

    public static void addUser(Account user) {
        //instancier un Objet User null
        Account userAdd = null;
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "INSERT INTO account (firstname, lastname, email, password) " + "VALUES (?, ?, ?, ?)";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            //Exécution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //test si l'enregistrement est ok
            if (addedRows > 0) {
                //Création d'un Objet User
                userAdd = new Account();
                userAdd.setFirstname(user.getFirstname());
                userAdd.setLastname(user.getLastname());
                userAdd.setEmail(user.getEmail());
                userAdd.setPassword(user.getPassword());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //Retourne un Objet User
    }

}

