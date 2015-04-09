import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {
    public int x;
    public int y;
    private int sum;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        this.sum = x + y;
    }
    
    public int getSum() { return sum;}
    
    public int getX() { return this.x;}
    
    public int getY() { return this.y;}
    
    public boolean contains(int index) {
        if (index == x || index == y) return true;
        else return false;
    }
}
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) { //try use set here
                int low = i + 1;
                int high = num.length - 1;
                int remain = 0 - num[i];
                while (low < high) {
                    if (num[low] + num[high] == remain) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[low]);
                        temp.add(num[high]);
                        ret.add(temp);
                        while (low < high && num[low] == num[low + 1]) low++;
                        while (low < high && num[high] == num[high - 1]) high--;
                        low++;
                        high--;
                    } else if (num[low] + num[high] < remain) low++;
                    else high--;
                }
            }
            
        }
        return (List)ret;
    }
    
    
    public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		int num[] = {0, 1, -1};
		System.out.println(sum.threeSum(num));

	}
}