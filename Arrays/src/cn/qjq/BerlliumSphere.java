package cn.qjq;
/**
 * 仅仅创建一个类
 * @author Administrator
 *2019年11月4日11:32:09
 */
public class BerlliumSphere {//其他包也可以访问
	private static long counter;
	private final long id = counter++;
	public String toString() {
		return "Sphere" + id;
	}

}
class Test{
	
}