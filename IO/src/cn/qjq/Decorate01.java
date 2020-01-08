package cn.qjq;
/**
 * 放大器放大声音    ----装饰
 * @author qjq
 *2019年11月11日08:58:11
 */
public class Decorate01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		//装饰
		Amplifier am = new Amplifier(p);
		am.say();
	}

}
interface Say{
	void say();
}
class Person implements Say{
	private int voice =10;
	@Override
	public void say() {
		System.out.println("人的声音为： "+this.getVoice());
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
}

class Amplifier implements Say{
	private Person p;
	Amplifier(Person p){//进行装饰
		this.p = p;
	}
	@Override
	public void say() {
		System.out.println("放大后的声音为： "+this.p.getVoice()*10);
		System.out.println("声音太大啦！！！！");
	}
	
}



