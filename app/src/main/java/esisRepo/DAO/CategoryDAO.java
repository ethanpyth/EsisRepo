package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import esisRepo.entity.Category;

@Dao
public interface CategoryDAO {
    @Insert
    void insert(Category category);

    @Query("select * from Category")
    Category readAll();

    @Query("select * from Category WHERE id = :id")
    Category readOne(int id);

    @Delete
    void delete(Category category);

    @Update
    void update(Category category);
}
