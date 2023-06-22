//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//Note that you must do this in-place without making a copy of the array.

//Example 1:

//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]


//ANSWER:

class Solution {
    public void moveZeroes(int[] nums) {
        //do this in-place without making a copy of the array
        int lastNonZero=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[lastNonZero++]=nums[i];
            }
        }
        for(int i=lastNonZero;i<n;i++){
            nums[i]=0;
        }
    }
}
