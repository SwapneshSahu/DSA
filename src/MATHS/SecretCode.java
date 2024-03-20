package MATHS;

import java.util.HashMap;

public class SecretCode {

	public static void main(String[] args) {
		
		String word = "my name is swapnesh ";
		HashMap<Character,String> enc= encryption();
		HashMap<String,Character> dec = decryption();
		StringBuffer ans =new StringBuffer();
		
		for (int i = 0 ; i<word.length();i++) {
			ans.append(enc.get(word.charAt(i)));
		}
		System.out.println(ans);
		StringBuffer ans_1 =new StringBuffer();
	
		int count=0;
		for (int i = 0 ; i<ans.length(); i =i+3) {
			String temp = ans.substring(i, i+3);
			
				 ans_1.append(dec.get(temp));
		
		}
		
		System.out.println(ans_1);
	}

	
	
	
	
	public  static HashMap<String,Character> decryption(){
		HashMap<String,Character> lang = new HashMap<>();
		
		lang.put("000",' ');
		lang.put("001",'a');
		lang.put("002",'b');
		lang.put("003",'c');
		lang.put("004",'d');
		lang.put("005",'e');
		lang.put("006",'f');
		lang.put("007",'g');
		lang.put("008",'h');
		lang.put("009",'i');
		lang.put("010",'j');
		lang.put("011",'k');
		lang.put("012",'l');
		lang.put("013",'m');
		lang.put("014",'n');
		lang.put("015",'o');
		lang.put("016",'p');
		lang.put("017",'q');
		lang.put("018",'r');
		lang.put("019",'s');
		lang.put("020",'t');
		lang.put("021",'u');
		lang.put("022",'v');
		lang.put("023",'w');
		lang.put("024",'x');
		lang.put("025",'y');
		lang.put("026",'z');
		
		
		return lang;
	}
	public static HashMap<Character,String> encryption(){
		HashMap<Character,String> lang = new HashMap<>();
		
		lang.put(' ',"000");
		lang.put('a',"001");
		lang.put('b',"002");
		lang.put('c',"003");
		lang.put('d', "004");
		lang.put('e', "005");
		lang.put('f', "006");
		lang.put('g', "007");
		lang.put('h', "008");
		lang.put('i', "009");
		lang.put('j', "010");
		lang.put('k', "011");
		lang.put('l', "012");
		lang.put('m', "013");
		lang.put('n', "014");
		lang.put('o', "015");
		lang.put('p', "016");
		lang.put('q', "017");
		lang.put('r', "018");
		lang.put('s', "019");
		lang.put('t', "020");
		lang.put('u', "021");
		lang.put('v', "022");
		lang.put('w', "023");
		lang.put('x', "024");
		lang.put('y', "025");
		lang.put('z', "026");

		
		
		return lang;
	}
}
