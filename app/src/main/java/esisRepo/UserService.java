package esisRepo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);
}
