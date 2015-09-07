import java.util.Scanner;

public class CaeserCipher {
	
	public static int mod( int num, int divisor){
		int val = num % divisor;
		if(val<0){
			val+=divisor;
		}
		return val;
	}//mod

		//method to encrypt a string
	public static String encrypt(String un_str, int key){
		char[] charArray = un_str.toCharArray();
		int base = (int) 'a';
		for(int x = 0; x< un_str.length();x++){
			int intVal = (int)charArray[x] + key - base;
			charArray[x] = (char)(mod(intVal,26) + base);
		}
		return new String(charArray);
	}//encrypt
	
	//function to decrypt a string
	public static String decrypt(String en_str, int key){
		return encrypt(en_str, (- key));
	}//decrypt

	public static void main(String[] args) {
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.print("Would you like to encode or decode a message?");
		//Get the user input
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		if(!(response.equals("encode") || response.equals("decode"))){
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}else if(response.equals("encode")){
			System.out.print("Enter the string to encode:");
			String str = in.nextLine();
			System.out.println("Your encrypted message is:");
			for (int n = 0; n < 26; n++){
				System.out.println("n = " + n + ": " + encrypt(str, n));
			}
		}
		else {
			System.out.print("Enter the string to decode:");
			String str = in.nextLine();
			System.out.println("Your decrypted message is:");
			for (int n = 0; n < 26; n++){
				System.out.println("n = " + n + ": " + decrypt(str, n));
			}
		}
	}//main
}

