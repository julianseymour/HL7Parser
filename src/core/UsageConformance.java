package core;

public abstract class UsageConformance{
	
	public static String USAGE_REQUIRED = "R";
	public static String USAGE_REQUIRED_EMPTY = "RE";
	public static String USAGE_CONDITIONAL = "C";
	public static String USAGE_UNSUPPORTED = "X";
	public static String USAGE_OPTIONAL = "O";
	
	public static boolean validate(String symbol){
		switch(symbol){
			case "R":
			case "RE":
			case "C":
			case "X":
			case "O":
				return true;
			default:
				return false;
		}
	}
}
