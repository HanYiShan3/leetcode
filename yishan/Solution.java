package org.yishan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static String majorityElement(List<Integer> nums) {
        int count=1;
        int l=0;
        int maj = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (maj == nums.get(i)) { //遇到相同的加1
                l++;
                count++;
            }else {                 //遇到不同的数减1
                count--;
                if (count == 0) {   //换下一个数重新开始计数
                    maj = nums.get(i+1);
                }
            }
        }
        return String.valueOf(maj)+'-'+String.valueOf(l);
    }
    public static void main(String[] args) throws ParseException {
        /*int[] num={2,1,1,1,1,1,2,3,2,2,2};*/
//        List<Integer> dataList=new ArrayList<>();
//        for (int i=0;i<10;i++){
//            dataList.add(i);
//        }
//        dataList.add(2);
//        dataList.add(3);
//        dataList.add(1);
//        dataList.add(2);
//






    }

}

