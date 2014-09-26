package lesson2;

public class B25_27_Tanks {

	public static void main(String[] args) {
		System.out.println(getQuadrant("a", "1"));
		System.out.println(getQuadrant("a", "2"));
		System.out.println(getQuadrant("b", "1"));
		System.out.println(getQuadrant("b", "2"));
		System.out.println(getQuadrant("b", "4"));
		System.out.println(getQuadrant("e", "6"));
		System.out.println(getQuadrant("i", "9"));
//		System.out.println(getQuadrant("j", "2"));
//		System.out.println(getQuadrant("i", null));
		
		printCoordinates("a", "1");
		printCoordinates("a", "2");
		printCoordinates("b", "1");
		printCoordinates("b", "2");
		printCoordinates("b", "4");
		printCoordinates("e", "6");
		printCoordinates("i", "9");
		
	}
	
	/**
	 * - TANKS -
	 * B25
	 */
	static String getQuadrant(String v, String h) {
		int vertical = 0;
		int horizontal = Integer.valueOf(h);
		
		if ( horizontal < 1 || horizontal > 9 ) {
			return "-1";
		}
		
		if ( v.equals("a")) {
			vertical = 1;
		} else if ( v.equals("b")) {
			vertical = 2;
		} else if ( v.equals("c")) {
			vertical = 3;
		}  else if ( v.equals("d")) {
			vertical = 4;
		} else if ( v.equals("e")) {
			vertical = 5;
		} else if ( v.equals("f")) {
			vertical = 6;
		} else if ( v.equals("g")) {
			vertical = 7;
		} else if ( v.equals("h")) {
			vertical = 8;
		} else if ( v.equals("i")) {
			vertical = 9;
		} else {
			return "-1";
		}
		
		return  ( horizontal - 1) * 64 + "_" + ( vertical - 1) * 64;
	}
	
	/**
	 * - Tanks theme -
	 * B27
	 */
	static void printCoordinates(String v, String h) {
		String pxCoord = getQuadrant(v, h);
		int spaceIndex = pxCoord.indexOf("_");
		
		System.out.println(v + h + ":(" + pxCoord.substring(0, spaceIndex) + "px; " + pxCoord.substring(spaceIndex + 1) + "px)");
	}
	
}
