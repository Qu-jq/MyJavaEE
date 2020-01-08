package cn.qjq;
/**
 * 捕获超出数组大小异常
 * @author Administrator
 *2019年11月3日12:23:15
 */
public class ArrayIndexBounds {
	public static void main(String[] args) {
		Character[] c = new Character[10];
		try {
			c[10] = 'x';
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("e =  " + e);
		}
	}
	

}
