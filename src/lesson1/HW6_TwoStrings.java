package lesson1;


public class HW6_TwoStrings {

	public static void main(String[] args) {
		String s = "Education is the most powerful weapon which you can use to change the world.";
		String t = "An investment in knowledge pays the best interest.";
		
		int beginPrintIndex = s.indexOf("use"); //52
		int insertBeginIndex = s.indexOf("use") + "use".length() + 1; //56
		int beginIndexInsertable = t.indexOf("knowledge"); //17
		int endIndexInsertable = beginIndexInsertable + "knowledge".length(); //17 + 9 = 26
		int endPrintIndex = s.length() - 1;
		
		System.out.println(s.substring(beginPrintIndex, insertBeginIndex) 
							+ t.substring(beginIndexInsertable, endIndexInsertable) 
							+ s.substring(insertBeginIndex - 1, endPrintIndex));
	}

}
