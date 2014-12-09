package add;

public class Solution {
	public String add(int radix_in, int radix_out, String a, String b) {
		if(a == null || b == null) {
			return "";
		}
		int lena = a.length();
		int lenb = b.length();
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int i = lena-1, j = lenb-1;
		while(i >= 0 || j >= 0 || carry > 0) {
			int numa = 0, numb = 0;
			if(i >= 0) {
				numa = getNum(a.charAt(i--));
			}
			if(j >= 0) {
				numb = getNum(b.charAt(j--));
			}
			int sum = carry + numa + numb;
			
		}
		return "";
	}
	//input has to be base of 10
	public String TentoAny(int num, int radix_out) {
		if(num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		String table = "0123456789ABCDEF";
		while(num > 0) {
			sb.insert(0, table.charAt(num % radix_out));
			num /= radix_out;
		}
		return sb.toString();
	}
	
	public String radixConversion(int from, int to, String num) {
		if(from == to) {
			return num;
		}
		String table = "0123456789ABCDEF";
		if(to != 10) {
			num = radixConversion(from, 10, num);
			return TentoAny(Integer.valueOf(num), to);
		}
		else {
			int num_ten = 0;
			for(int i = num.length()-1; i >= 0; --i) {
				num_ten += table.indexOf(num.charAt(i)) * Math.pow(from, num.length()-i-1);
			}
			return String.valueOf(num_ten);
		}
		
	}
	
	public int getNum(char c) {
		return c - '0';
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.radixConversion(16, 10, "10"));
	}
 }
