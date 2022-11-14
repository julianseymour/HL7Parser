package core;

import java.util.regex.Pattern;

public abstract class Hl7RegexHelper{

	public static boolean isJoined(String subject, String separator){
		return Pattern.compile("[^"+separator+"]+("+separator+"[^"+separator+"]*)+$", Pattern.CASE_INSENSITIVE).matcher(subject).find();
	}
}
