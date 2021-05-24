package proyek.android.iqra.apihelper.allsubmissiondata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllSubmissionRequest {
    @SerializedName("userId")
    @Expose
    private int id_user;

    public AllSubmissionRequest(Integer getId) {
        this.id_user = getId;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}
