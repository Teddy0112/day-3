class Solution {
    public int sumOfPower(int[] nums) {
        final long MOD = 1_000_000_007L;

        Arrays.sort(nums);

        long ans = 0;
        long sumMins = 0;

        for (int x : nums) {
            long val = x % MOD;

            // x is the maximum, and sumMins + x gives the sum of possible minimums
            long minSum = (sumMins + val) % MOD;

            ans = (ans + val * val % MOD * minSum) % MOD;

            // Update for the next maximum
            sumMins = (2 * sumMins + val) % MOD;
        }

        return (int) ans;
    }
}
