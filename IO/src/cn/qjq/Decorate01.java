package cn.qjq;
/**
 * �Ŵ����Ŵ�����    ----װ��
 * @author qjq
 *2019��11��11��08:58:11
 */
public class Decorate01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		//װ��
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
		System.out.println("�˵�����Ϊ�� "+this.getVoice());
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
	Amplifier(Person p){//����װ��
		this.p = p;
	}
	@Override
	public void say() {
		System.out.println("�Ŵ�������Ϊ�� "+this.p.getVoice()*10);
		System.out.println("����̫������������");
	}
	
}



