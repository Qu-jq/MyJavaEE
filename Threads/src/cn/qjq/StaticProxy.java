package cn.qjq;
/**
 * 静态代理
 * 公共接口
 * 1.真实角色
 * 2.代理角色
 * @author qjq
 *2019年11月19日14:43:23
 */
public class StaticProxy {
	public static void main(String[] args) {
		new MarryCompany(new You()).happyMary();
	}

}
//公共接口
interface Marry{
	void happyMary();
}

//真实角色
class You implements Marry{
	@Override
	public void happyMary() {
		System.out.println("You are very happy...");
	}
}
//代理
class MarryCompany implements Marry{
	private Marry target;
	MarryCompany(Marry target){
		this.target = target;
	}
	@Override
	public void happyMary() {
		prepare();
		this.target.happyMary();
		after();
	}
	private void prepare() {
		System.out.println("准备。。。");
	}
	private void after() {
		System.out.println("收拾。。。");
	}
}


