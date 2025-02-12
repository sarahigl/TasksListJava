package Repository;

import DB.SQLConnect;
import Model.Category;
import Model.Task;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;


public class TaskRepository {
    private static Connection connexion = SQLConnect.getConnexion();

    public static void addTask(Task task){
        Task taskAdded = null;


        String sql = "INSERT INTO task (title, description, createAt, status) VALUES (?, ?, NOW(), ?)";

        try (PreparedStatement statement = connexion.prepareStatement(sql)) {
            // Préparation de la requête
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getStatus());
            //statement.setInt(4, task.getAccountId());
            int addRows = statement.executeUpdate();
            if(addRows>0){
                taskAdded = new Task();
                taskAdded.setTitle(task.getTitle());
                taskAdded.setDescription(task.getDescription());
                //taskAdded.setCreateAt(task.getCreateAt());
                taskAdded.setStatus(task.getStatus());
//taskAdded.setAccountId(task.getAccountId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void associateCategoryTask(int taskId, int categoryId){
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            String sql = "INSERT INTO task_category (task_id, category_id) VALUES (?, ?)";
            //Préparation de la requête
            PreparedStatement statement =
                    connexion.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.setInt(2, categoryId);
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Task> getAllTasks(){
        ArrayList<Task> todo = new ArrayList<>();
        Task taskGet = null;
        try{
            // Connection à la BDD ...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "SELECT id, title, status FROM task";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                //Si la réponse est différente de null
                if (rs.getString(1)!= null){
                    taskGet = new Task();
                    taskGet.setId(rs.getInt("id"));
                    taskGet.setTitle(rs.getString("title"));
                    taskGet.setStatus(rs.getInt("status"));
                    todo.add(taskGet);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return todo;
    }
    public static void updateStatus(int taskId){
        Task statusChanged = null;
        try{
            //Connection à la BDD...
            Statement stmt = connexion.createStatement();
            //requête SQL
            String sql = "UPDATE task SET status = 1 WHERE id = (?)";
            //Préparation de la requête
            PreparedStatement preparedStatement =
                    connexion.prepareStatement(sql);
            //Bind des paramètres
//            preparedStatement.setInt(1, task.getStatus());
            preparedStatement.setInt(1, taskId);

            //Exécution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //test si l'enregistrement est ok
            if (addedRows > 0) {
                //Création d'un Objet User
                statusChanged= new Task();
                statusChanged.setStatus(taskId);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
