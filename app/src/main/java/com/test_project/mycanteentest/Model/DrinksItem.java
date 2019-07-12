package com.test_project.mycanteentest.Model;


import com.google.gson.annotations.SerializedName;


public class DrinksItem{

	@SerializedName("img")
	private String img;

	@SerializedName("harga")
	private int harga;

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"DrinksItem{" + 
			"img = '" + img + '\'' + 
			",harga = '" + harga + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}