
public class ZigZagConversion {
	
	public String convert(String s, int nRows) {
		if (nRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int step = nRows + nRows - 2; //on step equals one zigzag length
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < length; j += step) {
            	ret.append(s.charAt(j));
            	//still need to think about it
            	if (i !=0 && i < nRows - 1 && j + step -2*i < length) 
            		ret.append(s.charAt(j + step -2*i));
            }
        }
        return ret.toString();
    }

	public static void main(String[] args) {
		ZigZagConversion zigC = new ZigZagConversion();
		System.out.println(zigC.convert("ABCD", 1));
	}

}
