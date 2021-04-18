package proyek.android.iqra.apihelper;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import proyek.android.iqra.apihelper.signin.SignInRequest;
import proyek.android.iqra.apihelper.signin.SignInResponse;
import proyek.android.iqra.apihelper.signup.SignUpRequest;
import proyek.android.iqra.apihelper.submission.SubmissionResponse;
import proyek.android.iqra.apihelper.updatedata.UpdateDataRequest;
import proyek.android.iqra.apihelper.updatedata.UpdateDataResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface BaseApiService {
    @POST("/create")
    Call<SignUpRequest>CreateUserHandler(@Body SignUpRequest SignUpResponse);

    @POST("/login")
    Call<SignInResponse>LoginHandler(@Body SignInRequest SignInRequest);

    @PUT("/update")
    Call<UpdateDataResponse>UpdateUserHandler(@Body UpdateDataRequest UpdateDataRequest);

    @Multipart
    @POST("/submission")
    Call<SubmissionResponse> UploadFileHandler (
            @Part MultipartBody.Part file
    );

}
