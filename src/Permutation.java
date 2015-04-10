
public class Permutation {
	public String getPermutation(int n, int k) {
        StringBuilder ret = new StringBuilder();
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Character.forDigit(i + 1, 10);
        }
        helper(nums, k, ret);
        return ret.toString();
    }
    
    private void helper(char[] nums, int k, StringBuilder ret) {
        if (k == 0 || nums.length == 0) return;
        int unit = factorial(nums.length - 1);
        int index = 0;
        if (unit != 0) index = k/unit;
        if (unit != 0 && k%unit == 0) index--;
        char val = nums[index];
        ret.append(val);
        char[] temp = new char[nums.length - 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) temp[j++] = nums[i];
        }
        helper(temp, k - index*unit, ret);
        return;
    }
    
    private int factorial(int k) {
        int ret = 1;
        for (int i = 1; i <= k; i++) {
            ret *= i;
        }
        return ret;
    }
	public static void main(String[] args) {
		Permutation p = new Permutation();
		System.out.println("result = :" + p.getPermutation(2, 2));

	}

}
