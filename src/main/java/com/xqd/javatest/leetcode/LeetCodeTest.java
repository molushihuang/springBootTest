package com.xqd.javatest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;

    }

    //最大字序和
    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;

    }

    //最后一个单词的长度
    public int lengthOfLastWord(String s) {

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yang = new ArrayList<>();
        if (numRows == 0) {
            return yang;
        }
        yang.add(new ArrayList<Integer>());
        yang.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            List<Integer> preRows = yang.get(i - 1);

            rows.add(1);
            for (int j = 1; j < i; j++) {
                rows.add(preRows.get(j - 1) + preRows.get(j));
            }
            rows.add(1);

            yang.add(rows);

        }
        return yang;
    }
}


