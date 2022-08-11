package esisRepo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Work {
    private int categoryId;
    private String creationDate;
    private int promotionId;
    private int stateId;
    private int userId;
    @PrimaryKey
    private int id;
    private String imageURL;
    private String description;
    private String workDate;

    public Work(int userId, int promotionId, int stateId, String description, String workDate, String imageURL, String creationDate, int categoryId){
        this.userId = userId;
        this.workDate = workDate;
        this.categoryId = categoryId;
        this.creationDate = creationDate;
        this.imageURL = imageURL;
        this.description = description;
        this.promotionId = promotionId;
        this.stateId = stateId;
    }

    public Work(String workName, int workId, int userId){
        this.userId = userId;
        this.id = workId;
        this.description = workName;
    }

    public Work(){}

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

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotion) {
        this.promotionId = promotion;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int state) {
        this.stateId = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user) {
        this.userId = user;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int category) {
        this.categoryId = category;
    }
}
