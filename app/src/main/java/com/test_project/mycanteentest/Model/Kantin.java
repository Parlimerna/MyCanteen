package com.test_project.mycanteentest.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Kantin {

	@SerializedName("other")
	private List<OtherItem> other;

	@SerializedName("foods")
	private List<FoodsItem> foods;

	@SerializedName("drinks")
	private List<DrinksItem> drinks;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setOther(List<OtherItem> other){
		this.other = other;
	}

	public List<OtherItem> getOther(){
		return other;
	}

	public void setFoods(List<FoodsItem> foods){
		this.foods = foods;
	}

	public List<FoodsItem> getFoods(){
		return foods;
	}

	public void setDrinks(List<DrinksItem> drinks){
		this.drinks = drinks;
	}

	public List<DrinksItem> getDrinks(){
		return drinks;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Kantin{" +
			"other = '" + other + '\'' + 
			",foods = '" + foods + '\'' + 
			",drinks = '" + drinks + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}