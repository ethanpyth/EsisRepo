package esisRepo;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.Date;

@Entity
public class Work {
//    @Relation(entity = Category.class, parentColumn = "categoryId", entityColumn = "id")
    private Category category;
    private String creationDate;
    private String promotion;

//    @Relation(entity = Category.class, parentColumn = "stateId", entityColumn = "id")
    private State state;

//    @Relation(entity = Category.class, parentColumn = "userId", entityColumn = "id")
    private User user;
//    @PrimaryKey(autoGenerate = true)
    private int id;
    private String imageURL;
    private String description;
    private String workDate;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String date) {
        this.workDate = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
