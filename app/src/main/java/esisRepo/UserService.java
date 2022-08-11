package esisRepo;

import java.util.List;

import esisRepo.entity.Repos;
import esisRepo.entity.User;
import esisRepo.entity.Work;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("users/ethanpyth/repos")
    Call<List<Repos>> getUser();
}
