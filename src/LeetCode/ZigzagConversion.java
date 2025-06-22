package LeetCode;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"
    }
    public static String convert(String s, int numRows) {
        String[][] srr = new String[numRows][s.length()];
        boolean convertor = true;
        int idx = 0;
        if(numRows == 1){
            return s;
        }
        for(int j = 0; j < s.length(); j++){
            if(idx >= s.length()){
                break;
            }
            if(convertor){
                for(int i = 0; i < numRows; i++){
                    if(idx >= s.length()){
                        break;
                    }

                    srr[i][j] = s.charAt(idx++) + "";
                }
            }else{
                for(int i = numRows - 2; i >= 1; i--){
                    if(idx >= s.length()){
                        break;
                    }

                    srr[i][j++] = s.charAt(idx++) + "";
                }
            }
            convertor = !convertor;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < srr.length; i++){
            for(int j = 0; j < srr[0].length; j++){
                if(srr[i][j] != null)
                    sb.append(srr[i][j]);
            }
        }
        return sb.toString();
    }
}
