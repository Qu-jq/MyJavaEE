package cn.qjq;
/**
 * ���񳬳������С�쳣
 * @author Administrator
 *2019��11��3��12:23:15
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
