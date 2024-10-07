package src.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String profil;
    public User() {

    }
    public User(int id,String username, String password,String profil) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profil = profil;
    }
    public User(String username, String password,String profil) {
        this.username = username;
        this.password = password;
        this.profil = profil;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getProfil() {
        return this.profil;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setProfil(String profil) {
        this.profil = profil;
    }






}
