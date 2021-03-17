package proyek.android.iqra.apihelper;

import proyek.android.iqra.apihelper.signin.SignInRequest;
import proyek.android.iqra.apihelper.signin.SignInResponse;
import proyek.android.iqra.apihelper.signup.SignUpResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BaseApiService {
    @POST("/create")
    Call<SignUpResponse>CreateUserHandler(@Body SignUpResponse SignUpResponse);

    @POST("/login")
    Call<SignInResponse>LoginHandler(@Body SignInRequest SignInRequest);
}
