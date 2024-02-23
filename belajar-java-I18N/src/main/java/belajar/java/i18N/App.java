package belajar.java.i18N;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean res = searchMatrix(matrix, 3);
        System.out.println(res);

        int[] matric = {1,2,3,4,5,6,7,8,9};
        boolean resut =  searchMatrix1(matric, 3);
        System.out.println(resut);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int index = 0;

        while (start<=end) {
            int mid = (start + end) / 2;
            if(matrix[mid][index] == target) {
                return  true;
            } else if (matrix[mid][index] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            index++;
        }
        return  false;
    }

    public static boolean searchMatrix1(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start<=end) {
            int mid = (start + end) / 2;
            if(matrix[mid] == target) {
                return  true;
            } else if (matrix[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return  false;
    }


}
