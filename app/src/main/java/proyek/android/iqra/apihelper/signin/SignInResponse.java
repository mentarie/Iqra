package proyek.android.iqra.apihelper.signin;

import com.google.gson.annotations.SerializedName;

import proyek.android.iqra.apihelper.signin.Data;

public class SignInResponse{
	public SignInResponse(int code, Data data, String status) {
		this.code = code;
		this.data = data;
		this.status = status;
	}

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SignInResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}