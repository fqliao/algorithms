package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _20PrintMatrixClockwise {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return null; 
         int start = 0, rows = matrix.length, columns =  matrix[0].length;
         ArrayList<Integer> numbers = new ArrayList<>();
         while(rows  > start * 2 && columns > start * 2){
             printMatrixCicle(matrix, rows, columns, start, numbers);
             ++start;
         }
         return numbers;
     }
     
     private static void printMatrixCicle(int[][] matrix, int rows, int columns, int start, List<Integer> numbers){
         int endX = rows - 1 - start;
         int endY = columns - 1 - start;
         //从左往右遍历
         for(int i = start; i <= endY; i++)
             numbers.add(matrix[start][i]);
         //从上往下遍历
         if(start < endX){
             for(int i = start + 1; i <= endX; i++)
                 numbers.add(matrix[i][endY]);
         }
         //从右往左遍历
         if(start < endX && start < endY){
             for(int i = endY - 1; i >= start; i--)
                 numbers.add(matrix[endX][i]);
         }
         //从下到上遍历
         if(start < endX - 1 && start < endY ){
             for(int i = endX - 1; i >= start + 1; i--)
                 numbers.add(matrix[i][start]);
         }
     }
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.toString(printMatrix(matrix).toArray()));
	}

}
