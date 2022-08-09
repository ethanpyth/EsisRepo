package esisRepo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity
public class Document {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String imageURL;

    private int workId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int work) {
        this.workId = work;
    }
}
