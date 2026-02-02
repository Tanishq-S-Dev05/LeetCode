class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int evenCount = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2 == 0) {
                evenCount++;

                if(evenCount > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}