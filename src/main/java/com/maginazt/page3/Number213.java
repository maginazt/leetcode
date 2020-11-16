package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/9.
 */
public class Number213 {

//    private static void print(int length){
//        print(true, 2, length-2, new StringBuilder("0 "));
//        System.out.println("==============");
//        print(true, 3, length-1, new StringBuilder("1 "));
//        System.out.println("==============");
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(Integer.toString(length-1)+" ");
//        print(true, 1, length-3, sb);
//    }
//
//    private static void print(boolean canskip, int start, int end, StringBuilder path) {
//        int pos = path.length();
//        path.append(start).append(" ");
//        if(start == end){
//            System.out.println(path);
//            return;
//        }
//        if(start+2 <= end)
//            print(true, start+2, end, path);
//        else
//            System.out.println(path);
//        if(canskip){
//            if(start +1 <= end){
//                path.delete(pos, path.length());
//                print(false, start+1, end, path);
//            }
//        }
//    }

    public int rob(int[] nums) {
        switch (nums.length){
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
            case 3:
                return max(nums);
            case 4:
                return max(nums[0]+nums[2], nums[1]+nums[3]);
            case 5:
                return max(nums[0]+nums[2], nums[0]+nums[3], nums[1]+nums[3], nums[1]+nums[4], nums[2]+nums[4]);
            case 6:
                return max(nums[0]+nums[2]+nums[4], nums[1]+nums[3]+nums[5], nums[0]+nums[3], nums[1]+nums[4], nums[2]+nums[5]);
            default:
                return max(nums[0]+rob(nums, 2, nums.length-2), nums[1]+rob(nums, 3, nums.length-1), nums[nums.length-1]+nums[2]+rob(nums, 4, nums.length-3));
        }
    }

    private int rob(int[] nums, int begin, int end){
        int length = end - begin + 1;
        int[] maximums = new int[length+1];
        maximums[length-1] = nums[end];
        for(int i=length-2;i>=0;i--)
            maximums[i] = Math.max(nums[i+begin]+maximums[i+2], maximums[i+1]);
        return maximums[0];
    }

    private int max(int... nums){
        int max = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i] > max)
                max = nums[i];
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Number213().rob(new int[]{1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9,1,7,5,4,3,9}));
    }
}
