package hzc.com.utils;

import java.util.Scanner;

/**
 * @Auther: HZC
 * @Date: 2018/7/6 14:47
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            System.out.println(inversion(in.nextLine()));
        }
    }

    /**
     * 输入倒置展示
     * @param objString
     * @return
     */
    static String inversion(String objString){
        String obj[]=objString.split(" ");
        StringBuffer buffer=new StringBuffer();
        for(int i=obj.length-1 ; i>=0 ; i--){
            buffer.append(obj[i]+" ");
        }
        return buffer.toString();
    }



}
