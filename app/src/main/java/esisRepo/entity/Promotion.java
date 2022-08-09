package esisRepo.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Promotion {
    public Promotion(int id, String promotion){
        this.promotion = promotion;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    @PrimaryKey
    private int id;
    private String promotion;
}
