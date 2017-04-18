package Lab13;

public class SecretWord {
	private String secretWord = "";
	private String hintWord = "";
	private int numberOfTurns;
	public SecretWord(){
		secretWord = "beefy";
		hintWord = "*****";
		numberOfTurns = 0;
	}
	
	//Accessors
	public String getSecretWord()
	{
		return this.secretWord;
	}
	public String getHintWord()
	{
		return this.hintWord;
	}
	public int getNumberOfTurns()
	{
		return this.numberOfTurns;
	}
	//Mutators
	public void setSecreteWord(String aSecreteWord){
		this.secretWord = aSecreteWord;
	}
	
	public void setHintWord(String aHintWord){
		this.hintWord = aHintWord;
	}
	
	public void setNumberOfTurns(int aNumberOfTurns){
		if(aNumberOfTurns < 0 )
		{
			System.out.println("This is an incorrect number");
			return;
		}
		this.numberOfTurns = aNumberOfTurns;
	}
	
	public void guessLetter(char ch){
		char[] charHint = hintWord.toCharArray();
		char[] charAry = secretWord.toCharArray();
		for (int i=0; i<charAry.length; i++)
		{
			if (charAry[i] == ch)
			{
				charHint[i] = ch;
			}
		}

		setHintWord(String.valueOf(charHint));
		
	}
}
