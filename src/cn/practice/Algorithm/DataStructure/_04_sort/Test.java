package cn.practice.Algorithm.DataStructure._04_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 字串在主串中出现的次数
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(indexList("abcaafdsaa gafaaafa","aa"));
    }

    public static List<Integer> indexList(String s, String ss){
        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        String str = s;
        int index = 0,count = 0;
        while (flag){
            flag = false;
            if (str.contains(ss)){
                count++;
                flag = true;
                if (count!=1){
                    index = s.indexOf(ss, index + 2);
                } else {
                    index = s.indexOf(ss);
                }
                list.add(index);
                str = s.substring(index + 2,s.length());
            }
        }
        return list;
    }
}
