//Implementation
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (;;) {
			String str = in.nextLine();
			if(str.equals("halt")) {
				break;
			}
			int time = 0;
			
	
			Map<String, BigDecimal> dictionary = new HashMap<String, BigDecimal>();
			BigDecimal tmp = new BigDecimal("0.1");
			char tmp_char = 'a';
			for(int i=0; i < 26; i++) {
				tmp_char = (char)('a' + i);
				if(tmp_char == 'd'||tmp_char =='g'||tmp_char =='j'||tmp_char =='m'||tmp_char =='p'||tmp_char =='t'||tmp_char =='w') {
					tmp = tmp.setScale(0, BigDecimal.ROUND_HALF_DOWN) ;
					tmp.setScale(1, BigDecimal.ROUND_HALF_DOWN);
					tmp = tmp.add(new BigDecimal("1.1"));
				}
				dictionary.put(String.valueOf(tmp_char), tmp);
				tmp = tmp.add(new BigDecimal("0.1"));
			}
	
			BigDecimal num = new BigDecimal("0");
			BigDecimal cost = new BigDecimal("0");
			BigDecimal tmp_num;
			for(int j = 0; j < str.length(); j++) {	
				tmp = dictionary.get(String.valueOf(str.charAt(j)));
				num = tmp.setScale(0, BigDecimal.ROUND_HALF_DOWN);
				cost = tmp.subtract(num).multiply(new BigDecimal("10"));
				time += cost.intValue();
				if((j + 1) != str.length()) {
					tmp_num = dictionary.get(String.valueOf(str.charAt(j+1))).setScale(0, BigDecimal.ROUND_HALF_DOWN);				
					if(tmp.intValue() == tmp_num.intValue()) {
						time += 2;
					}
				}
			}
			System.out.println(time);
	}	

	}

}
