package proyek.android.iqra.apihelper;

public class AndroidItem{
	private String ver;
	private String name;
	private String api;

	public void setVer(String ver){
		this.ver = ver;
	}

	public String getVer(){
		return ver;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setApi(String api){
		this.api = api;
	}

	public String getApi(){
		return api;
	}

	@Override
 	public String toString(){
		return 
			"AndroidItem{" + 
			"ver = '" + ver + '\'' + 
			",name = '" + name + '\'' + 
			",api = '" + api + '\'' + 
			"}";
		}
}
