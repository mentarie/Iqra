package proyek.android.iqra.apihelper.submission;

public class SubmissionResponse{
	private int code;
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
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
			"SubmissionResponse{" + 
			"code = '" + code + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
