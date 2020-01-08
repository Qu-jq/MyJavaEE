package cn.qjq;

import java.util.Arrays;

/**
 * 多维数组
 * @author Administrator
 *2019年11月5日10:39:46
 */
public class MultidimensionalArray {
	public static double[][] creArr(int m,int n) {
		double Arr[][] = new double[m][n];
		return Arr;
	}
	public static void  printArr(double[][] Arr) {
		
		System.out.println(Arrays.deepToString(Arr));
		System.out.println("行数: " + Arr.length);//表示行数
	}
	public static void main(String[] args) {
		printArr(creArr(3,2));
		
	}

}
