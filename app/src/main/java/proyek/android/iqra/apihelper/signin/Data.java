package proyek.android.iqra.apihelper.signin;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setRefreshToken(String refreshToken){
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken(){
		return refreshToken;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
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
			"Data{" + 
			"access_token = '" + accessToken + '\'' + 
			",refresh_token = '" + refreshToken + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}