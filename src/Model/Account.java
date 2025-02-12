package Model;

import java.util.ArrayList;

public class Account {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    static ArrayList<Account> accounts = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        Account.accounts = accounts;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    }

    public Account(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
    public static void add(Account account) {
        accounts.add(account);
    }

    public static void remove(Account account) {
        accounts.remove(account);
    }
    public static void findAll() {
        for (Account account : accounts) {
            System.out.println("Firstname: " + account.getFirstname() +
                    ", Lastname: " + account.getLastname() +
                    ", Id : " + account.getId() +
                    ", Email: " + account.getEmail());
        }
    }



}
