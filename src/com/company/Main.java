package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //不能用map
	Scanner sc=new Scanner(System.in);
	Map<String,String> map=new HashMap<>();
	while(sc.hasNextLine()) {
        //输入比赛次数
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String key=sc.next();
            String value=sc.next();
            map.put(key,value);
        }
        //现在数据已经准备好了，通过键值对的方式存在了hash表中
        //甲的手势为key,乙的手势为value
        //用三个变量记录甲每个手势胜负平的次数
        int win = 0;
        int ping = 0;
        int loss = 0;
        for(String key:map.keySet()){
            //String a=key;
            //String b=map.get(key);
            if(key.compareTo(map.get(key))==0){
                ping++;
            }else if(key.compareTo(map.get(key))>0){
                win++;
            }else{
                loss++;
            }
        }


        System.out.println(win +" "+ping+" "+loss);
    }

    }
}
