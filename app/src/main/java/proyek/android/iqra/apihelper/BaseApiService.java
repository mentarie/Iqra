package proyek.android.iqra.apihelper;

import proyek.android.iqra.apihelper.signin.SignInRequest;
import proyek.android.iqra.apihelper.signin.SignInResponse;
import proyek.android.iqra.apihelper.signup.SignUpRequest;
import proyek.android.iqra.apihelper.updatedata.UpdateDataRequest;
import proyek.android.iqra.apihelper.updatedata.UpdateDataResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface BaseApiService {
    @POST("/create")
    Call<SignUpRequest>CreateUserHandler(@Body SignUpRequest SignUpResponse);

    @POST("/login")
    Call<SignInResponse>LoginHandler(@Body SignInRequest SignInRequest);

    @PUT("/update")
    Call<UpdateDataResponse>UpdateUserHandler(@Body UpdateDataRequest UpdateDataRequest);
}
