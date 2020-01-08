package cn.qjq;

import java.util.Arrays;

/**
 * 返回数组
 * @author Administrator
 *2019年11月4日11:29:58
 */
public class ReturnArrays {
	
	static BerlliumSphere[] flavorSet(int n) {
		BerlliumSphere[] results = new BerlliumSphere[n];
		for(int i = 0;i<n;i++) {
			results[i] = new BerlliumSphere();
		}
		return results;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(flavorSet(5)));
		Test t = new Test();//测试默认访问权限  ----包访问权限
	}
}
