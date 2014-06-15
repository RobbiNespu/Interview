import java.util.Hashtable;


public class StringHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "areerta";
		System.out.println(firstNoneRepeated(str));

	}

	public static Character firstNoneRepeated(String str){
		
		Hashtable charHash = new Hashtable();
		Character c;
		boolean flag;
		Object seenOnce = new Object();
		Object seenTwice = new Object();
		int length = str.length();
		for(int i=0;i<length;i++){
			if(charHash.get(str.charAt(i)) == null){
				// false defines the character shown just once
				charHash.put(str.charAt(i), seenOnce);
			}else{
				charHash.put(str.charAt(i), seenTwice);
			}
		}
		
		for(int i=0; i<str.length();i++){
			if(charHash.get(str.charAt(i)) == seenOnce)
				return str.charAt(i);			
		}		
		return null;
	}
}
