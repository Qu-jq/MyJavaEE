package cn.qjq.ex;

import java.util.Arrays;

import cn.qjq.BerlliumSphere;

/**
 * ���ն���Ķ�ά����
 * @author Administrator
 *2019��11��5��11:01:06
 */
public class EX6 {
	public static BerlliumSphere[][] creArry(int xlen,int ylen){
		BerlliumSphere[][] Arr = new BerlliumSphere[xlen][ylen];
		for(int i = 0; i<xlen;i++)
			for(int j = 0; j<ylen;j++)
				Arr[i][j] = new BerlliumSphere();
		return Arr;
	}
	public static void main(String[] args) {
		BerlliumSphere[][] Arr = creArry(4, 5);
		System.out.println(Arrays.deepToString(Arr));
		
	}
}
