package cn.practice.Interview.zijietiaodong.jinritoutiao_2018._03_zhuzi;
/**
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，
 * 要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），
 * 在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
 * 手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，
 * 每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。
 * 即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 *
 * 输入描述:
 *
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50)
 * 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
 * 接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
         * n:珠子的个数
         * m:最多要相隔几个位置
         * c:珠子的颜色总数
 *
 * 输出描述:
 *
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 *
 * 输入例子1:
 *
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 *
 * 输出例子1:
 *
 * 2
 *
 * 例子说明1:
 *
 * 第一种颜色出现在第1颗串珠，与规则无冲突。
 * 第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
 * 第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
 * 总计有2种颜色的分布是有问题的。
 *  * 这里第2颗串珠是透明的。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BraceletsTest {

    public static void main(String[] args) {
        method1();
    }

    public static void method1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    //n个串珠
        int m = sc.nextInt();    //手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次
        int c = sc.nextInt();    //颜色一共有c种
        int count = 0;
        Map<Integer,List<Integer>> map = new HashMap<>(); // 存放的是每个颜色对应的珠子的下标
        for(int i=0;i < n;i++) {
            int num = sc.nextInt();
            for(int j=0;j < num;j++) {
                int key = sc.nextInt();
                if(!map.containsKey(key)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key, list);
                }
                else {
                    List<Integer> list = map.get(key);
                    list.add(i);
                }
            }
        }
        for(int i=1;i <= c;i++) {
            boolean flag = false;
            List<Integer> list = map.get(i);
            if(list.size() == 1) {
                continue;
            }
            else {
                for(int j=0;j < list.size()-1;j++) {
                    if(list.get(j+1) - list.get(j) < m) {// 已经连续出现了，不符合要求的
                        count++;
                        flag = true;
                        break;
                    }
                }
                // 首尾的情况
                if(!flag) {
                    // 实际上就是判断得是最后一个元素和第一个元素之间的举例
                    /**
                     * 先算最后一个元素到末尾得距离
                     * 再加上第一个元素到开头的长度
                     */
                    if((n-list.get(list.size()-1)+list.get(0)) < m){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

}
