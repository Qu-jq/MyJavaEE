package cn.qjq;
/**
 * ģ�⿧��   ----װ��
 * 1�������������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
 * 2�������������Ҫװ�εĶ���
 * 3������װ���ࣺ�����˶Գ�������������Լ�װ���Ź�ͬ����
 * 4������װ���ࣺ��װ�εĶ���
 * @author qjq
 *2019��11��11��08:58:11
 */
public class Decorate2 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink milk = new Milk(coffee);//װ��
		System.out.println(milk.info()+"--->"+milk.cost());
		Drink sugar = new Sugar(coffee);//װ��
		System.out.println(sugar.info()+"--->"+sugar.cost());
		Drink sugar2 = new Sugar(milk);//װ��
		System.out.println(sugar2.info()+"--->"+sugar2.cost());
	}
}
//�������
interface Drink{
	double cost();//����
	String info();
}
//�������
class Coffee implements Drink{
	private String name = "ԭζ����";
	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
}
//����װ����
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
//����װ����
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
		return super.info()+"������ţ��";
	}
}
//����װ����
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
		return super.info()+"����������";
	}
}


