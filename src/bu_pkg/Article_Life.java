package bu_pkg;

public class Article_Life {
	
	String Result;
	
	public String ArtLife()
	{
		String url="https://www.policybazaar.com/life-insurance/general-info/articles/10-risky-cities-in-india-where-one-must-have-life-insurance/";

		BU_Life BuArtLife=new BU_Life();
		String ResultArt=BuArtLife.LifeBU();
		return(ResultArt);
        }
}
