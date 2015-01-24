public class UserUtility {

	public static String createUser(String a, String b)
	{
		//gets the first three characters of string a
		String aa = a.substring(0, 3);
		//gets the first three characters of string a
		String bb = b.substring(b.length()-3);
		return new String(aa+bb);
	}
	
}
