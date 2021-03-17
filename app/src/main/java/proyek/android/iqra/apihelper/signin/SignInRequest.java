package proyek.android.iqra.apihelper.signin;

import com.google.gson.annotations.SerializedName;

public class SignInRequest{
	public SignInRequest(String password, String username) {
		this.password = password;
		this.username = username;
	}

	@SerializedName("password")
	private String password;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"SignInRequest{" + 
			"password = '" + password + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}