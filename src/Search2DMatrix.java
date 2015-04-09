
public class Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int index = 0;
        while (index < row) {
        	if (matrix[index][col - 1] == target) return true;
            if (matrix[index][col - 1] > target) break; 
            index++;
        }
        //System.out.println("index is: " + index);
        if (index == row) return false;
        return binSearch(matrix, index, 0, col - 1, target);
    }
    
    private boolean binSearch(int[][] matrix, int index, int lo, int hi, int target) {
        if (lo > hi) return false;
        //System.out.println(lo);
        //System.out.println(hi);
        int mid = (hi + lo)/2;
        if (target == matrix[index][mid]) return true;
        else if (target < matrix[index][mid]) return binSearch(matrix, index, lo, mid - 1, target);
        else if (target > matrix[index][mid]) return binSearch(matrix, index, mid + 1, hi, target);
        return false;
    }
    
	public static void main(String[] args) {
		Search2DMatrix search = new Search2DMatrix();
		int[][] matrix = {{1, 3, 5}};
		System.out.println(search.searchMatrix(matrix, 1));
	}

}
