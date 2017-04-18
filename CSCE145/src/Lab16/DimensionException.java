package Lab16;

public class DimensionException extends Exception{
	public DimensionException(){
		super("it is an invalid dimension");
	}
	
	public DimensionException(String message){
		super(message);
	}
}
