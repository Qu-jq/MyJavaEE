package cn.qjq;

import java.util.Arrays;

/**
 * ��ά����
 * @author Administrator
 *2019��11��5��10:39:46
 */
public class MultidimensionalArray {
	public static double[][] creArr(int m,int n) {
		double Arr[][] = new double[m][n];
		return Arr;
	}
	public static void  printArr(double[][] Arr) {
		
		System.out.println(Arrays.deepToString(Arr));
		System.out.println("����: " + Arr.length);//��ʾ����
	}
	public static void main(String[] args) {
		printArr(creArr(3,2));
		
	}

}
