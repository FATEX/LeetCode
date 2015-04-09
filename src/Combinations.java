import java.util.LinkedList;
import java.util.List;


public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        buildList(ret, n, k, 1, new LinkedList<Integer>());
        return ret;
    }
    
    private void buildList(List<List<Integer>> ret, int n, int k, 
                                            int index, List<Integer> list) {
        if (k == 0) {
            List<Integer> l = new LinkedList<Integer>(list);
            ret.add(l);
            return;
        }
        
        for (int i = index; i <= n; i++) {
            list.add(i);
            buildList(ret, n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
