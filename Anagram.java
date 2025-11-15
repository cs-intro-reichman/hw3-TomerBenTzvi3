/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
			if (str1.length() == str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					for (int j = 0; j < str2.length(); j++) {
						if (str1.indexOf(i) == str2.indexOf(j)) {
						continue;
						} else {
							return false;
						}	
					}
				}
			}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String fill = "";
		String bin = "";
		String special = "!?@#$%^&* ";
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (special.indexOf(temp) == -1) {
				fill = fill + temp;
			}else {
				bin = bin + str.charAt(i);
			}
		}
		return fill;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String fill = "";
		String bin = "";
		int wordnum = str.length();
		int random = (int)(Math.random() * wordnum);
		str = str.toLowerCase();
		int i = 0;
		do {
			fill = fill + str.charAt(random);
			char index = fill.charAt(i);
			while (str.charAt(i) == fill.charAt(i)) {
				fill = fill + str.charAt(random);
				if (str.charAt(i) != fill.charAt(i) && fill.indexOf(index) == -1) {
					fill = fill + str.charAt(i);
					str = str.substring(i, random) + str.substring(random + 1);
				} else {
					bin = bin + str.charAt(i);
				}
				i++;
			}
			}while (fill.length() < str.length());
		return fill;
	}  
}
