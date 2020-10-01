import java.io.Serializable;

public class recipe implements Serializable {
	private int recipeid;
	private String recipename;
	private int recipetimetaken;
	private String recipeingredient;
	private String recipesteps;
	private String photoname;
	private String uploaddatetime;
	private byte[]recipephoto;

	public recipe(){

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
	public String getuploaddatetime(){
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
	public void setrecipename(String recipename){
		this.recipename = recipename;
	}
	public void setrecipetimetaken(int recipetimetaken){
		this.recipetimetaken=recipetimetaken;
	}
    public void setrecipeingredient(String recipeingredient) {
        this.recipeingredient = recipeingredient;
    }
	public void setuploaddatetime(String uploaddatetime){
		this.uploaddatetime = uploaddatetime;
	}
	public void setrecipephoto(byte[]recipephoto){
		this.recipephoto=recipephoto;
	}

	public void setphotoname(String photoname) {
        this.photoname = photoname;
    }
	public void setrecipesteps(String recipesteps){
			this.recipesteps=recipesteps;
		}

}




