Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
  
  
  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            // avoid duplicate entry at the first element in the triplet
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            // use two pointer approach to solve for two sum on remaining array
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
                else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                else {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    // avoid duplicate entry at the 2nd element in the triplet
                    while(nums[left] == nums[left-1] && left < right)left++;
                }
            }
        }
        return triplets;
    }

}
