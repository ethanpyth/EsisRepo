package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import esisRepo.entity.Document;

@Dao
public interface DocumentDAO {
    @Insert
    void insert(Document document);

    @Query("select * from Document")
    Document readAll();

    @Query("select * from Document WHERE id = :id")
    Document readOne(int id);

    @Delete
    void delete(Document document);

    @Update
    void update(Document document);
}
