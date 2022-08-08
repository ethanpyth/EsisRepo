package esisRepo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String matricule;
    private String pwd;
    private String password;
    private String role;
    private String creationDate;
    private String imageProfileURL;

    @Ignore
    public User(){}

    public User(String name, String matricule, String password){
        this.name = name;
        this.id = id;
        this.matricule = matricule;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImageProfileURL() {
        return imageProfileURL;
    }

    public void setImageProfileURL(String imageProfileURL) {
        this.imageProfileURL = imageProfileURL;
    }
}
