package proyek.android.iqra.apihelper;

public class UtilsApi {
    // https://192.168.100.6:8081/ ini adalah localhost.
    public static final String BASE_URL_API = "http://192.168.100.6:8081";
//    public static final String BASE_URL_API = "http://52.231.206.245:8081";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
