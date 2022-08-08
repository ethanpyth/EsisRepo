package esisRepo.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import esisRepo.State;

public interface StateDAO {
    @Insert
    void insert(State state);

    @Query("select * from State")
    State readAll();

    @Query("select * from State WHERE id = :id")
    State readOne(int id);

    @Delete
    void delete(State state);

    @Update
    void update(State state);
}
