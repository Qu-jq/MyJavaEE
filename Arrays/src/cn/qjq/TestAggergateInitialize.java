package cn.qjq;
/**
 * 动态聚集初始化  聚集初始化 
 * @author Administrator
 *2019年11月4日10:58:07
 */
public class TestAggergateInitialize {
	static void hide(BerylliumSphere[] b) {
		System.out.println("Hiding : "+b.length+" sphere(s)");
	}
	public static void main(String[] args) {
		hide(new  BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere()});//使用动态聚集初始化
		BerylliumSphere[] a = new BerylliumSphere[] {new BerylliumSphere(),new BerylliumSphere()};
		hide(a);
		//聚集初始化
		BerylliumSphere[] b = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
		hide(b);
		//hide({new BerylliumSphere(),new BerylliumSphere()});//编译错误
		
	}

}
class BerylliumSphere{
	
}
