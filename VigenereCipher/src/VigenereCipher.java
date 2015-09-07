import java.util.Scanner;

public class VigenereCipher {

	public static int mod( int num, int divisor) {
		int val = num % divisor;
		if( val < 0) {
			val += divisor;
		}
		return val;
	}//mod
	
	//method to encrypt a string
	static int base = (int) 'a';
	
	public static String encrypt(String un_str, String key) {
		int strLeng = un_str.length(); // length of the un_str
		int keyLeng = key.length(); // length of the key
		char[] strArray = un_str.toCharArray(); //convert un_str to an array
		char[] keyArray = key.toCharArray(); // convert key to an array
		for (int i = 0; i < strLeng; i++) {
			int remain = i % keyLeng; // choose the right character in the key
			// calculate the raw int value of the ith character in str
			int intVal = (int) strArray[i] + (int) keyArray[remain] - 2 * base;
			// convert the inVal to the appropriate int value
			strArray[i] = (char) (mod(intVal, 26) + base);
		}
		// Convert strArray to a String and return it
		return new String(strArray);
	}//encrypt
	
	public static String decrypt(String un_str, String key){
		int strLeng = un_str.length(); // length of the un_str
		int keyLeng = key.length(); // length of the key
		char[] strArray = un_str.toCharArray(); //convert un_str to an array
		char[] keyArray = key.toCharArray(); // convert key to an array
		for (int i = 0; i < strLeng; i++) {
			int remain = i % keyLeng; // choose the right character in the key
			// calculate the raw int value of the ith character in str
			int intVal = (int) strArray[i] - (int) keyArray[remain];
			// convert the inVal to the appropriate int value
			strArray[i] = (char) (mod(intVal, 26) + base);
		}
		// Convert strArray to a String and return it
		return new String(strArray);
	}
	
	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message?");
		//Get the user input
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		// if the input is not valid
		if(!(response.equals("encode") || response.equals("decode"))){
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}else if(response.equals("encode")){
			System.out.print("Enter the string to encode:");
			String str = in.nextLine();
			System.out.print("Enter your keyword:");
			String key = in.nextLine();
			System.out.println("Your encrypted message is:");
			System.out.println(encrypt(str, key));
		}
		else {
			System.out.print("Enter the string to decode:");
			String str = in.nextLine();
			System.out.print("Enter your keyword:");
			String key = in.nextLine();
			System.out.println("Your decrypted message is:");
			System.out.println(decrypt(str, key));
		}
		
	}
}
