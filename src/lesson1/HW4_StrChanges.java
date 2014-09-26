package lesson1;


public class HW4_StrChanges {

	public static void main(String[] args) {
		String str = "abcdf";
		System.out.println(str.charAt(0)+str.substring(1)); //str without changes
		System.out.println(("a" + str).substring(0));
		System.out.println(str.substring(0, str.length())); //str without changes
		System.out.println(str.replace("a", "b"));
	}

}
