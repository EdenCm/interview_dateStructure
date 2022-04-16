package other;

import java.util.HashMap;
import java.util.Map;

public class Ten2ThirtySix {


    /**
     * 思路 用hashMap存放0-Z 36个字符值键值对
     */
    private static final Integer BASE = 36;
    private static final String X36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // 拿到36进制转换10进制的键值对
    private static HashMap<Character,Integer> thiry2ten = createMapThirty2Ten();



    // 拿到10进制时所对应的36制符号

    private static HashMap<Integer,Character> ten2Thiry = createMapTen2Thirty();

    private static HashMap<Integer, Character> createMapTen2Thirty() {
        HashMap<Integer,Character> map = new HashMap<>();
        for (int i = 0; i < X36.length(); i++) {
            map.put(i,X36.charAt(i));
        }
        return map;
    }


    private static HashMap<Character, Integer> createMapThirty2Ten() {

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < X36.length(); i++) {
            map.put(X36.charAt(i),i);
        }
        return map;

    }
    /**
     * 36 -> 10
     */

    public static int Thirtysix2Ten(String pstr){

        if (pstr == "" || pstr == null) return 0;
        int result = 0;
        int power = pstr.length() -1;

        char[] keys = pstr.toCharArray();
        for (int i = 0; i < pstr.length(); i++) {

            int value = thiry2ten.get(keys[i]);
            result = (int) (result + value * Math.pow(BASE,power));
            power --;
        }
        return result;
    }


    public static String Ten2Thirtysix(Integer num){
        StringBuffer sb = new StringBuffer();
        int key;
        int value;
        boolean flag = true;
        while (flag){
            // 除数
            key = num / BASE;
            // 余数
            value = num - key * BASE;
            if (key == 0){
                flag = false;
                sb.append(ten2Thiry.get(value).toString());
            }else{
                 // 如果value小于进制36，说明下次递归会执行上面的语句
                // 而本次循环还没终止，所以要将循环控制设置为false

                if (value < BASE) flag = false;
                sb.append(ten2Thiry.get(key));
                Ten2Thirtysix(value);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = Ten2Thirtysix(73);
        System.out.println(s);
    }
}
