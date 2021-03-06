package cn.practice.Algorithm.Leetcode.cys2018._04_Binarysearch;

/**
 * 2. 大于给定元素的最小元素
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
 */
public class _02_nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target){
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h){
            int m = l + (h - l) / 2;
            if (letters[m] <= target){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
