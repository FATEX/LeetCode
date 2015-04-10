import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NQueens {
	
	public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();
        fillQueens(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new String[n], ret);
        return ret;
    }
    
    private void fillQueens(int row, boolean[] cols, boolean[] dia1, boolean[] dia2, String[] board, List<String[]> ret) {
        int boardL = board.length;
        if (row == boardL) {
            ret.add(board.clone());
            return;
        }
        for (int col = 0; col < boardL; col++) {
            int d1 = row + col;
            int d2 = boardL - 1 - row + col;
            if (!cols[col] || !dia1[d1] || !dia2[d2]) {
                cols[col] = true;
                dia1[d1] = true;
                dia2[d2] = true;
                char[] temp = new char[boardL];
                Arrays.fill(temp, '.');
                temp[col] = 'Q';
                board[row] = new String(temp);
                fillQueens(row + 1, cols, dia1, dia2, board, ret);
                cols[col] = false;
                dia1[d1] = false;
                dia2[d2] = false;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
