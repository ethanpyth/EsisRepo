package esisRepo.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import esisRepo.User;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Query("select * from User")
    List<User> readAll();

    @Query("select * from User WHERE id = :id")
    User readOne(int id);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
