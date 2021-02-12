package proyek.android.iqra.apihelper;

import android.service.autofill.UserData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    @POST("/users")
    Call<SignUpResponse>CreateUserHandler(@Body SignUpResponse SignUpResponse);

    @FormUrlEncoded
    @POST("/users")
    Call<ResponseBody>GetUsersHandler(@Field("email") String email,
                         @Field("password") String password
    );
}
