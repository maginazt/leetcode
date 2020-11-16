package com.maginazt.page1;

/**
 * Created by zhaotao on 2019/2/17.
 */
public class Number41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!isPositionFixed(nums[i], nums.length, i + 1) && nums[i] != nums[nums[i] - 1]) {
                //把当前数交换到正确的位置上
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private boolean isPositionFixed(int num, int length, int order) {
        //不是正整数，或正整数位置正确
        return num <= 0 || num > length || num == order;
    }

    public static void main(String[] args) {
        Number41 solution = new Number41();
        assert solution.firstMissingPositive(new int[]{1, 1}) == 2;
        assert solution.firstMissingPositive(new int[]{1}) == 2;
        assert solution.firstMissingPositive(new int[]{1, 2, 0}) == 3;
        assert solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}) == 1;
        assert solution.firstMissingPositive(new int[]{3, 4, -1, 1}) == 2;
    }
}
