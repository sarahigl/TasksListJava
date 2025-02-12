package Model;

import java.util.ArrayList;

public class Category {
    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static ArrayList<Category> listCategories;
    public static void addCategory(Category category){
        listCategories.add(category);
    }
    public static void removeCategory (Category category){
        listCategories.remove(category);
    }
    public static void findAllCategories() {
        for (Category category: listCategories) {
            System.out.println("category : " + category.getName());
        }
    }

}
