package com.xqd.javatest.leetcode;

/**
 * Created by 谢邱东 on 2019/10/23 15:07.
 * NO bug
 */

class LeetCodeTest {
    public static void main(String[] args) {

        LeetCodeTest test = new LeetCodeTest();
//        test.treeMapSortTest();
//        int[] nums = {3, 2, 7, 11, 15};
//        int[] t = test.twoSum(nums, 9);
//
//        System.out.println(t[0]);
//        System.out.println(t[1]);

        int num = test.strStr("aaaaa", "bba");
        System.out.println(num);
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

    //最长公共前缀（我的）
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        String cur = "";
        for (int i = 1; i < str.length() + 1; i++) {
            String select = str.substring(0, i);
            for (String s : strs) {
                if (s.contains(select)) {
                    cur = select;
                }
            }
        }
        return cur;
    }

    //最长公共前缀(官方)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //删除数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    //移除给定的数组元素
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

    //实现indexOf方法
    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int len = needle.length();
        int index = -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + len <= haystack.length() && needle.equals(haystack.substring(i, i + len))) {
                index = i;
                break;
            }

        }
        return index;

    }
}


