package com.company;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-07-09
 * Time:10:46
 * 一万年太久，只争朝夕，加油
 */
import java.util.Scanner;
public class Main2 {
    static int m = 0, n = 0, p = 0;
    static int b1,c1,j1;
    static int b2,c2,j2;
    public static void main(String[] args) {
            Scanner sca = new Scanner(System.in);
            int num = sca.nextInt();
            String arr[][] = new String[num][2];
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sca.next();
                }
            }
            for (int i = 0; i < num; i++) {
                win(arr[i][0],arr[i][1]);
            }
            System.out.println(m+" "+p+" "+n);
            System.out.println(n+" "+p+" "+m);
            num(b1,c1,j1);
            System.out.print(" ");
            num(b2,c2,j2);
    }
    private static void num(int b,int c,int j) {
        if (b>=c&&b>=j) {
            System.out.print("B");
        } else if (c>=b&&c>=j) {
            System.out.print("C");
        } else {
            System.out.print("J");
        }
    }
    private static void win(String a,String b) {
        if (a.equals("C")&&b.equals("J")) {
            m = m+1;
            c1 = c1+1;
        } else if (a.equals("J")&&b.equals("B")) {
            m = m+1;
            j1 = j1+1;
        } else if (a.equals("B")&&b.equals("C")) {
            m = m+1;
            b1 = b1+1;
        } else if (a.equals("J")&&b.equals("C")) {
            n = n+1;
            c2 = c2+1;
        } else if (a.equals("B")&&b.equals("J")) {
            n = n+1;
            j2 = j2+1;
        } else if (a.equals("C")&&b.equals("B")) {
            n = n+1;
            b2 = b2+1;
        } else {
            p = p+1;
        }
    }
}
