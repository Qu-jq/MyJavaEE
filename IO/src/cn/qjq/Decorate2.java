package cn.qjq;
/**
 * 模拟咖啡   ----装饰
 * 1、抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类：包含了对抽象组件的引用以及装饰着共同方法
 * 4、具体装饰类：被装饰的对象
 * @author qjq
 *2019年11月11日08:58:11
 */
public class Decorate2 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink milk = new Milk(coffee);//装饰
		System.out.println(milk.info()+"--->"+milk.cost());
		Drink sugar = new Sugar(coffee);//装饰
		System.out.println(sugar.info()+"--->"+sugar.cost());
		Drink sugar2 = new Sugar(milk);//装饰
		System.out.println(sugar2.info()+"--->"+sugar2.cost());
	}
}
//抽象组件
interface Drink{
	double cost();//费用
	String info();
}
//具体组件
class Coffee implements Drink{
	private String name = "原味咖啡";
	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
}
//抽象装饰类
abstract class Decorate implements Drink{
	private Drink drink;
	Decorate(Drink drink){
		this.drink = drink;
	}
	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
}
//具体装饰类
class Milk extends Decorate{

	Milk(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"加入了牛奶";
	}
}
//具体装饰类
class Sugar extends Decorate{

	Sugar(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"加入了蔗糖";
	}
}


