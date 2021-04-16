package proyek.android.iqra.apihelper.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpRequest {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("userId")
    @Expose
    private String id_user;
    @SerializedName("id")
    @Expose
    private Integer id;

    public SignUpRequest(String username, String email, String password, String id_user){
        this.username = username;
        this.email = email;
        this.password = password;
        this.id_user = id_user;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", id_user=" + id_user +
                ", id=" + id +
                '}';
    }
}
