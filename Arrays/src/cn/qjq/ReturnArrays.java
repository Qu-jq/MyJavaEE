package cn.qjq;

import java.util.Arrays;

/**
 * ��������
 * @author Administrator
 *2019��11��4��11:29:58
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
		Test t = new Test();//����Ĭ�Ϸ���Ȩ��  ----������Ȩ��
	}
}
