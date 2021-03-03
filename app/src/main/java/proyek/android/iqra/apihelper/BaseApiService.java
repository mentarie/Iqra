package proyek.android.iqra.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiService {
    @POST("/users")
    Call<SignUpResponse>CreateUserHandler(@Body SignUpResponse SignUpResponse);

    @POST("/login")
    Call<SignInResponse>LoginHandler(@Body SignInResponse SignInResponse);

    @POST("logout")
    Call<Void> logout();
}
