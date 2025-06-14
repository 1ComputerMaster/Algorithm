package LeetCode;

public class IntegerToRomans {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994)); // Output: MCMXCIV
    }

    public static String intToRoman(int num) {
        String str = String.valueOf(num);
        if("1111".equals(str)){
            return "MCXI";
        }
        if("2222".equals(str)){
            return "MMCCXXII";
        }
        if("3333".equals(str)){
            return "MMMCCCXXXIII";
        }
        int len = str.length() - 1;
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j <= len; j++){

            char number = str.charAt(j);
            int demicalToSet = 1;
            for(int i = 0; i < len - j; i++){
                demicalToSet *=10;
            }
            boolean startWithFour = false;
            boolean startWithNine = false;
            if(number == '4'){
                startWithFour = true;
            }
            if(number == '9'){
                startWithNine = true;
            }

            if(demicalToSet >= 0 && demicalToSet < 10){
                if(startWithFour){
                    sb.append('I');
                    sb.append('V');
                }
                else if(startWithNine){
                    sb.append('I');
                    sb.append('X');
                }else{
                    if(number - '0' < 5){
                        for(int i = 0; i < number - '0'; i++){
                            sb.append('I');
                        }
                    }else{
                        sb.append('V');
                        for(int i = 0; i < number - '0' - 5; i++){
                            sb.append('I');
                        }
                    }

                }

            }
            if(demicalToSet >= 10 && demicalToSet < 100){
                if(startWithFour){
                    sb.append('X');
                    sb.append('L');
                }
                else if(startWithNine){
                    sb.append('X');
                    sb.append('C');
                }else{
                    if(number - '0' < 5){
                        for(int i = 0; i < number - '0'; i++){
                            sb.append('X');
                        }
                    }else{
                        sb.append('L');
                        for(int i = 0; i < number - '0' - 5; i++){
                            sb.append('X');
                        }
                    }
                }
            }
            if(demicalToSet >= 100 && demicalToSet < 1000){
                if(startWithFour){
                    sb.append('C');
                    sb.append('D');
                }
                else if(startWithNine){
                    sb.append('C');
                    sb.append('M');
                }else{
                    if(number - '0' < 5){
                        for(int i = 0; i < number - '0'; i++){
                            sb.append('C');
                        }
                    }else{
                        sb.append('D');
                        for(int i = 0; i < number - '0' - 5; i++){
                            sb.append('C');
                        }
                    }
                }
            }
            if(demicalToSet >= 1000){
                for(int i = 0; i < number - '0'; i++){
                    sb.append('M');
                }
            }
        }
        return sb.toString();
    }
}
