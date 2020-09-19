package MyPackage;
import java.io.*;

public class CreditCardVal {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		String input[] = br.readLine().trim().split(" ");
		int length = input.length;
	    
		if(checkingLength(length))
	    	System.out.println("Valid Credit Card Number length." + "\n");
	    else
	    	System.out.println("Length must be between 14-19 digits." + "\n");
	    
		int[] arr = new int[length-1];
	 	for(int i = 0; i < length-1; i++)
	    	arr[i] = Integer.parseInt(input[i]);
	 	
	 	int checkDigit = Integer.parseInt(input[length - 1]);
	    System.out.println("Check Digit = " + checkDigit + "\n");
	    
	    int arrLength = arr.length;
	    reverse(arr, arrLength);
	    
	    selectiveDoubling(arr, arrLength);
	    
	    int sum = addAllDigit(arr, arrLength);
	    System.out.println("\n\nSum of all digit = " + sum);
	    
	    if(validateCard(sum,checkDigit))
	    	System.out.println("\nCard is Valid");
	    else
	    	System.out.println("\nCard is Invalid");
	        
	}
	
	public static Boolean checkingLength(int length) {
		
		if(length >= 14 && length <= 19 )
			return true;
		else 
			return false;
	}
	
	public static void reverse(int[] arr, int n) {
		
		int temp;
		for(int i = 0; i < n/2; i++) {
			temp = arr[i];
			arr[i] = arr[n - i -1];
			arr[n - i - 1] = temp;
		}
		System.out.println("Reverse Number");
		for(int i = 0; i < n; i++)
			System.out.print(arr[i]);
		
	}
	
	public static void selectiveDoubling(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			
			if((i % 2) != 0)
				arr[i] = arr[i];
			
			else {
				int doubleVal = arr[i] * 2;
				if(doubleVal > 9) {
					int firstDigit = doubleVal/10;
					int lastDigit = doubleVal%10;
					
					arr[i] = firstDigit + lastDigit;
				}
				else
					arr[i] = doubleVal;
			}
		}
		System.out.println("\n\nDigit array after selective doubling.");
		for(int i = 0; i < n; i++)
			System.out.print(arr[i]);
	}
	
	public static int addAllDigit(int[] arr, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += arr[i];
		return sum;
	}
	
	public static Boolean validateCard(int sum, int checkDigit) {
		int lastDigitOfSum = sum % 10;
		if((10-lastDigitOfSum) == checkDigit)
			return true;
		else
			return false;
	}
	
	
}
