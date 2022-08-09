package esisRepo.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserPromotion {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Relation(
            entityColumn = "idPromotion",
            parentColumn = "id"
    )
    private User user;
    @Embedded
    private Promotion promotion;
}
