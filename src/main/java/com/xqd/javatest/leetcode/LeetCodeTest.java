package com.xqd.javatest.leetcode;

/**
 * Created by 谢邱东 on 2019/10/23 15:07.
 * NO bug
 */

class LeetCodeTest {
    public static void main(String[] args) {

        LeetCodeTest test = new LeetCodeTest();
//        test.treeMapSortTest();
        int[] nums = {3, 2, 7, 11, 15};
        int[] t = test.twoSum(nums, 9);

        System.out.println(t[0]);
        System.out.println(t[1]);

    }

    //两书相加
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String str=strs[0];
        String cur="";
        for(int i=1;i<str.length()+1;i++){
            String select=str.substring(0,i);
            for(String s:strs){
                if(s.contains(select)){
                    cur=select;
                }
            }
        }
        return cur;

    }
}


