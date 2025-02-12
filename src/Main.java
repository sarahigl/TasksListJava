import Model.Account;
import Model.Category;
import Model.Task;
import Repository.AccountRepository;
import Repository.CategoryRepository;
import Repository.TaskRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static Model.Account.findAll;
import static Model.Category.addCategory;
import static Model.Task.getListTasks;
import static Repository.CategoryRepository.getAllCategories;
import static Repository.TaskRepository.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);

    }
    private static void menu(Scanner scanner){
        boolean arret = true;
        while (arret){
            System.out.println("Veuillez choisir une option :");
            System.out.println("1 pour ajouter un compte:");
            System.out.println("2 pour ajouter une categorie :");
            System.out.println("3 pour ajouter une tâche :");
            System.out.println("4 pour valider une tâche comme faite :");
            System.out.println("5 pour afficher toutes les tâches :");
            System.out.println("6 pour arrêter le programme :");
            int choix = scanner.nextInt();

            switch (choix){
                case 1 :
                    Account account = new Account();
                    AccountRepository repository = new AccountRepository();
                    System.out.println("Veuillez saisir le prenom :");
                    account.setFirstname(scanner.next());

                    System.out.println("Veuillez saisir le nom :");
                    account.setLastname(scanner.next());

                    System.out.println("Veuillez saisir l'email :");
                    account.setEmail(scanner.next());

                    System.out.println("Veuillez saisir le mot de passe :");
                    account.setPassword(scanner.next());

                    repository.addUser(account);
                    System.out.println("Le compte a été créé");
                    break;
                case 2:
                    Category category = new Category();
                    CategoryRepository categoryRepository = new CategoryRepository();
                    System.out.println("Veuillez saisir le nom de la catégorie :");
                    //ajouter condition si la categorie existe
                    category.setName(scanner.next());
                    categoryRepository.addCategory(category);
                    System.out.println("La catégorie a été ajoutée.");
                    break;
                case 3 :
                    Task task = new Task();
                    Account account1 = new Account();
                    ArrayList<Task> listTasks = new ArrayList<>();
                    findAll();
//                    if(task.setAccountId(scanner.nextInt()){ condition if id exist
//                    }
                    System.out.println("Veuillez saisir le titre de la tâche :");
                    task.setTitle(scanner.next());

                    System.out.println("Veuillez saisir la description de la tâche :");
                    task.setDescription(scanner.next());

                    System.out.println("Veuillez saisir le statut de la tâche (0 pour non complété, 1 pour complété) :");
                    task.setStatus(scanner.nextInt());

                    System.out.println("Veuillez saisir l'id auquel est destiné la tache :");
                    task.setAccountId(scanner.nextInt());
                    //scanner.nextLine();

                    addTask(task);
                    System.out.println("Voici toutes les catégories dispo pour la tache :");
                    getAllCategories(); //liste à faire fonctionner
                    System.out.println("Si vous souhaitez ajouter une new categorie => new si non tapez le nom de la catégorie :");
                    //scanner.nextInt();
//faire la logique pour choisir ou ajouter une categorie
                    //associateCategoryTask();
                    System.out.println("La tâche a été créée.");
                    break;
                case 4 :
                    listTasks = TaskRepository.getAllTasks();
                    Task taskValidate = new Task();
                    if (listTasks.isEmpty()) {
                        System.out.println("Aucune tâche trouvée.");
                    }
                    try{
                        Task tache = new Task();
                        for (Task listTask : listTasks) {
                            tache = listTask;
                            System.out.println("numero : " + tache.getId() + " task : " + tache.getTitle() + " status: " + tache.getStatus());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Veuillez saisir le numero de la tâche");
                    int taskChosen = scanner.nextInt();
                    int statusNew = 1;
                    boolean taskFound = false;
                    for (Task value : listTasks) {
                        if (value.getId() == taskChosen) {
                            updateStatus(taskChosen);
                            //value.setStatus(statusNew);
                            taskFound = true;
                            System.out.println("Le statut de la tâche '" + value.getTitle()+ " : Validé");
                            break;
                        }
                    }

                    if (!taskFound) {
                        System.out.println("La tâche n'a pas été trouvée.");
                    }

                case 5 :
                    System.out.println("Liste des tâches :");
                    listTasks = TaskRepository.getAllTasks();

                    if (listTasks.isEmpty()) {
                        System.out.println("Aucune tâche trouvée.");
                    }
                    try{
                        Task tache = new Task();
                        for (Task listTask : listTasks) {
                            tache = listTask;
                            System.out.println("task : " + tache.getTitle() + " status: " + tache.getStatus());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Arret du programme :");
                    break;
            }

        }


    }
}