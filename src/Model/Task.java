package Model;

import java.util.ArrayList;
import java.util.Date;

public class Task {

    private Integer id;
    private String title;
    private String description;
    private Date createAt;
    private Integer status;
    private Integer accountId;
    private ArrayList<Category> categories;
    public Task() {
        this.categories = new ArrayList<>();
    }

    public Task(String title, String description, Date createAt, Integer status, Integer accountId, ArrayList<Category> categories) {
        this.title = title;
        this.description = description;
        this.createAt = createAt;
        this.status = status;
        this.accountId = accountId;
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    static ArrayList<Task> listTasks;
    public static void add(Task task){
        listTasks.add(task);
    }


    public static ArrayList<Task> getListTasks() {
        return listTasks;
    }

    public static void setListTasks(ArrayList<Task> listTasks) {
        Task.listTasks = listTasks;
    }

    public static void findAll() {
        if (listTasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
            return;
        }
        for (Task task: listTasks) {
            System.out.println("task : " + task.getTitle() +
                    " description: " + task.getDescription() +
                    " date: " + task.getCreateAt() +
                    " status: " + task.getStatus()
            );
        }
    }

    public void setAccountId(int i) {

    }

    public Integer getAccountId() {
        return accountId;
    }
}
