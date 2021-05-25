package proyek.android.iqra.apihelper.submission;

import com.google.gson.annotations.SerializedName;

public class SubmissionResponse{
	private int code;
	@SerializedName("data")
	private SubmissionModel data;
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setSubmissionModel(SubmissionModel submissionModel){
		this.data = submissionModel;
	}

	public SubmissionModel getSubmissionModel(){
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
			"SubmissionResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}
