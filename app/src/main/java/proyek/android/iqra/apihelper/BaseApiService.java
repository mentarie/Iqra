package proyek.android.iqra.apihelper;

import android.service.autofill.UserData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody>CreateUserHandler(@Field("username") String username,
                                       @Field("email") String email,
                                       @Field("password") String password
    );

    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody>GetUsersHandler(@Field("email") String email,
                         @Field("password") String password
    );
}
