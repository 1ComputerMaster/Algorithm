package BOJ.simulation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BOJ_16170 {
    public static void main(String[] args) throws Exception{
        Date cur = new Date();
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat mm = new SimpleDateFormat("MM");
        SimpleDateFormat dd = new SimpleDateFormat("dd");

        System.out.println(yyyy.format(cur) + "\n" + mm.format(cur) + "\n" + dd.format(cur));

    }
}
