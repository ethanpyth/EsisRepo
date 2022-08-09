package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import esisRepo.entity.Work;

@Dao
public interface WorkDAO {
    @Insert
    void insert(Work work);

    @Query("select * from Work")
    Work readAll();

    @Query("select * from Work WHERE id = :id")
    Work readOne(int id);

    @Delete
    void delete(Work work);

    @Update
    void update(Work work);
}
