import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a1 = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right
            for (int j = colStart; j <= colEnd; j++) {
                a1.add(matrix[rowStart][j]);
            }
            rowStart++;

            // Traverse down
            for (int i = rowStart, j = colEnd; i <= rowEnd; i++) {
                a1.add(matrix[i][j]);
            }
            colEnd--;

            // Traverse left
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    a1.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            // Traverse up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    a1.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }

        return a1;
    }


}
