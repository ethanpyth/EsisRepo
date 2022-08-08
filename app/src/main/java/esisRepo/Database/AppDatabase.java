package esisRepo.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import esisRepo.Category;
import esisRepo.DAO.UserDAO;
import esisRepo.Document;
import esisRepo.State;
import esisRepo.User;
import esisRepo.Work;

@Database(
        entities = {User.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
