package proyek.android.iqra.model;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TesBacaModel{
	private int Id, numberColor, imageSource, rekamHasil, rekamLine, rekamIcon;
	private String number;

	public TesBacaModel(Integer Id, String number, Integer numberColor, Integer imageSource, Integer rekamHasil, Integer rekamLine, Integer rekamIcon){
		this.Id = Id;
		this.number = number;
		this.numberColor = numberColor;
		this.imageSource = imageSource;
		this.rekamHasil = rekamHasil;
		this.rekamLine = rekamLine;
		this.rekamIcon = rekamIcon;
	}

	public Integer getId(){
		return Id;
	}
	public Integer getRekamLine(){
		return rekamLine;
	}
	public String getNumber(){
		return number;
	}
	public Integer getNumberColor(){
		return numberColor;
	}
	public Integer getRekamHasil(){
		return rekamHasil;
	}
	public Integer getRekamIcon(){
		return rekamIcon;
	}
	public Integer getImageSource(){
		return imageSource;
	}
}
