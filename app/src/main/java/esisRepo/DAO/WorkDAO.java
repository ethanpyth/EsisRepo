package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import esisRepo.entity.Work;

@Dao
public interface WorkDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Work work);

    @Query("select * from Work WHERE userId = :userId")
    List<Work> readAll(int userId);

    @Query("select * from Work WHERE id = :id")
    Work readOne(int id);

    @Query("SELECT * from Work LIMIT :nb")
    List<Work> readMany(int nb);

    @Delete
    void delete(Work work);

    @Update
    void update(Work work);
}
