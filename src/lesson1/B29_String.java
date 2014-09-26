package lesson1;

public class B29_String {
	public static void main(String[] args) {
		String name = "Igor";
		String mjQuote = "I'm failed over and over and over again in my life and that is why I succeed!";
		String mtQuote = "Let us always meet each other with smile, for the smile is the beginnig of love.";
		
		System.out.println(name + ":" + name.length());
		System.out.println(name.charAt(0));
		
		System.out.println(mjQuote.indexOf("succeed") + "," + (mjQuote.indexOf("succeed") + "succeed".length()));
		
		System.out.println(mjQuote.substring(mjQuote.indexOf("succeed"), mjQuote.indexOf("succeed") + "succeed".length()));
	
		System.out.println(mtQuote.replace("smile", ":)"));

	}

}