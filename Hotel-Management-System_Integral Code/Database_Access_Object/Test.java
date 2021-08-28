package Database_Access_Object;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){


//        System.out.println(ab.insert("10101","11111","2022-02-22","3","Smoke Free!","101 Bank St, Ottawa","103"));
//        ab.close();
        Access_Employees ae = new Access_Employees();
        ae.connect();

        System.out.println(ae.nonBookedToRenting("10101","101 Bank St, Ottawa","101","101001","1","2020-01-11","2020-01-15"));
        System.out.println(ae == null);
        ae.close();

    }
}
