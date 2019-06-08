package com.cotton.oj.Main1001;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author wuke
 * @date 2019-05-11 21:53
 */

/**
 * 95.123 12
 * 0.4321 20
 * 5.1234 15
 * 6.7592  9
 * 98.999 10
 * 1.0100 12
 * Sample Output
 *
 * 548815620517731830194541.899025343415715973535967221869852721
 * .00000005148554641076956121994511276767154838481760200726351203835429763013462401
 * 43992025569.928573701266488041146654993318703707511666295476720493953024
 * 29448126.764121021618164430206909037173276672
 * 90429072743629540498.107596019456651774561044010001
 * 1.126825030131969720661201
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String inputStr = sc.nextLine();
            double baseNum = Double.valueOf(inputStr.substring(0, 6));
            int powerNum = Integer.valueOf(inputStr.substring(7).trim());
            String decimalPower = bigDecimalPower(baseNum, powerNum);

            if(decimalPower.startsWith("0")){
                System.out.println(decimalPower.substring(1)) ;
            }else{
                System.out.println(decimalPower);
            }

        }
        sc.close();

    }

    private static String  bigDecimalPower(double baseNum,int powerNum){
        BigDecimal baseNumBigDecimal = BigDecimal.valueOf(baseNum);
        BigDecimal bigDecimal = baseNumBigDecimal.pow(powerNum);

       return bigDecimal.stripTrailingZeros().toPlainString();

    }
}
