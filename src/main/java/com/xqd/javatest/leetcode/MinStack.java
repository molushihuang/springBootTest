package com.xqd.javatest.leetcode;

import java.util.Stack;

/**
 * Created by 谢邱东 on 2019/11/20 10:01.
 * 最小栈
 * NO bug
 */

class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minData;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();

    }

    public void push(int x) {
        data.add(x);
        if (minData.isEmpty() || minData.peek() >= x) {
            minData.add(x);
        } else {
            minData.add(minData.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
        }
        if (!minData.isEmpty()) {
            minData.pop();
        }
    }

    public int top() {

        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("sd");
    }

    public int getMin() {

        if (!minData.isEmpty()) {
            return minData.peek();
        }

        throw new RuntimeException("fsd");

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
