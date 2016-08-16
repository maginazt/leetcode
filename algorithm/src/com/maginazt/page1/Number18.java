package com.maginazt.page1;

import java.util.*;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Number18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums != null && nums.length >= 4){
            Arrays.sort(nums);
            for(int pointer1 = 0;pointer1 < nums.length - 3;pointer1++){
                for(int pointer2 = pointer1+1;pointer2 < nums.length-2;pointer2++){
                    int left = pointer2+1;
                    int right = nums.length-1;
                    while (left < right){
                        int sum = nums[pointer1] + nums[pointer2] + nums[left] + nums[right];
                        if(sum == target){
                            List<Integer> seq = new ArrayList<>();
                            seq.add(nums[pointer1]);
                            seq.add(nums[pointer2]);
                            seq.add(nums[left]);
                            seq.add(nums[right]);
                            result.add(seq);
                            ++left;
                            --right;
                        }
                        else if(sum < target)
                            ++left;
                        else
                            --right;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
//
//    /**
//     * find @param(number) number from previous @param(frontNumber) of @param(nums) so that their sum equals @param(target)
//     *
//     * and put them into @param(result) with additional @param(others)
//     */
//    private void find(int[] nums, int frontNumber, int number, int target, Set<List<Integer>> result, int... others) {
//        if(frontNumber == number){
//            int sum = 0;
//            for(int i=0;i<frontNumber;i++)
//                sum += nums[i];
//            if(sum == target){
//                List<Integer> seq = new ArrayList<>();
//                for(int i=0;i<frontNumber;i++)
//                    seq.add(nums[i]);
//                for(int i=0;i<others.length;i++)
//                    seq.add(others[i]);
//                Collections.sort(seq);
//                result.add(seq);
//            }
//        }
//        else if(frontNumber > number){
//            if(number == 1){
//                for(int i=0;i<frontNumber;i++){
//                    if(nums[i] == target){
//                        List<Integer> seq = new ArrayList<>();
//                        seq.add(nums[i]);
//                        for(int j=0;j<others.length;j++)
//                            seq.add(others[j]);
//                        Collections.sort(seq);
//                        result.add(seq);
//                    }
//                }
//            }
//            else{
//                //nums[frontNumber-1] is not in result
//                find(nums, frontNumber-1, number, target, result, others);
//                //nums[frontNumber-1] is in result
//                int[] additional = new int[others.length+1];
//                System.arraycopy(others, 0, additional, 1, others.length);
//                additional[0] = nums[frontNumber-1];
//                find(nums, frontNumber-1, number-1, target-nums[frontNumber-1], result, additional);
//            }
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(new Number18().fourSum(new int[]{-499,-483,-463,-461,-431,-417,-390,-381,-366,-365,-342,-339,-321,-290,-285,-272,-265,-258,-228,-211,-188,-182,-146,-144,-123,-120,-112,-97,-92,-60,-58,-53,-53,-41,-36,-28,-15,-12,-7,22,45,57,59,62,77,81,99,103,105,115,119,135,147,154,169,183,187,215,243,258,259,266,272,272,275,309,319,345,370,382,385,389,436,439,442,469,484}, 7189));
        System.out.println(new Number18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
