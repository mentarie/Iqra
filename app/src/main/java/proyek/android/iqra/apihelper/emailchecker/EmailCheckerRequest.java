package proyek.android.iqra.apihelper.emailchecker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailCheckerRequest{
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("email")
	@Expose
	private String email;

	public String getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public EmailCheckerRequest(String id, String email){
		this.id = id;
		this.email = email;
	}
}
