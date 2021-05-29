package proyek.android.iqra.apihelper.updatedata;

public class UpdateDataRequest {
	private String password;
	private Integer id;
	private String email;
	private String username;

	public UpdateDataRequest(Integer id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
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
			"UpdateDataResponse{" +
			"id = '" + id + '\'' +
			",password = '" + password + '\'' +
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
