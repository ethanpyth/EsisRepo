package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import esisRepo.entity.Promotion;

@Dao
public interface PromotionDAO {
    @Insert
    void insert(Promotion promotion);

    @Update
    void update(Promotion promotion);

    @Delete
    void delete(Promotion promotion);

    @Query("SELECT * FROM Promotion WHERE id = :id")
    Promotion readOne(int id);

    @Query("SELECT * FROM Promotion")
    List<Promotion> readAll();
}
