package esisRepo;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/users/{id}")
    void getUser(@Path("id") int id);
}
