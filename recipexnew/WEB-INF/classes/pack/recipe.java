package org.o7planning.servletexamples.model;

public class Recipe{
	private int recipeid;
	private String recipename;
	private int recipetimetaken;
	private String recipeingredient;
	private String recipesteps;
	private String photoname;
	private int uploaddatetime;
	private byte[]recipephoto;

	public Recipe(){

	}

	public recipe(int recipeid, String recipename, int recipetimetaken,String recipeingredient, String recipesteps, String photoname, int uploaddatetime,byte[]recipephoto ){
		this recipeid=recipeid;
		this recipename=recipename;
		this recipetimetaken=recipetimetaken;
		this recipeingredient=recipeingredient;
		this recipesteps=recipesteps;
		this photoname=photoname;
		this uploaddatetime=uploaddatetime;
		this recipephoto=recipephoto;
	}
	// getter 
	public int getrecipeid(){
		return recipeid;
	}
	public String getrecipename(){
		return recipename;
	}
	public int getrecipetimetaken(){
		return recipetimetaken;
	}
	public String getrecipeingredient(){
		return recipeingredient;
	}
	public String getrecipesteps(){
		return recipesteps;
	}
	public int getuploaddatetime(){
		return uploaddatetime;
	}
	public byte []getrecipephoto(){
		return recipephoto;
	}
	public String getphotoname(){
		return photoname;
	}
	//setter
	public void setrecipeid(int recipeid){
		this.recipeid = recipeid;
	}
	public String setrecipename(){
		this.recipename = recipename;
	}
	public void setrecipetimetaken(int recipetimetaken){
		this.recipetimetaken=recipetimetaken;
	}
	public String setrecipeingredient(){
		this.recipeingredient = recipeingredient;
	}
	public void setuploaddatetime(int uploaddatetime){
		this.uploaddatetime = uploaddatetime;
	}
	public void setrecipephoto(byte[]recipephoto){
		this.recipephoto=recipephoto;
	}

	public String setphotoname(){
			this.photoname=photoname;
	}
	public String setrecipesteps(){
			this.recipesteps=recipesteps;
		}

}




