package esisRepo.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import esisRepo.DAO.UserDAO;
import esisRepo.DAO.WorkDAO;
import esisRepo.entity.Category;
import esisRepo.entity.Document;
import esisRepo.entity.Promotion;
import esisRepo.entity.State;
import esisRepo.entity.User;
import esisRepo.entity.Work;

@Database(
        entities = {
                User.class,
                Category.class,
                State.class,
                Document.class,
                Promotion.class,
                Work.class
        },
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract WorkDAO workDAO();
}
