class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer at each end
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int currSum = numbers[i] + numbers[j];

            if (currSum < target) {
                i++;
            } else if (currSum > target) {
                j--;
            } else
                 {
                    return new int[] {i + 1, j + 1};
                }
        }
        return new int[0];
    }
}
