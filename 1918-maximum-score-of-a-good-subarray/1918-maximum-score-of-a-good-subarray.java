class Solution {
    public int maximumScore(int[] nums, int k) {
	int n = nums.length;
	int l = k;
	int r = k;
	int min = nums[k];
	int maxScore = nums[k];

	while(true) {
		while(r + 1 < n && nums[r + 1] >= min) {
			r++;
		}
		while(l - 1 >= 0 && nums[l - 1] >= min) {
			l--;
		}

		maxScore = Math.max(maxScore, min * (r - l + 1));

		if(l == 0 && r == n - 1) {
			break;
		}
		if(l == 0) {
			min = nums[r + 1];
		} else if(r == n - 1) {
			min = nums[l - 1];
		} else {
			min = Math.max(nums[r + 1], nums[l - 1]);
		}
	}

	return maxScore;
}
}