package cn.qjq.xc;
/**
 * �߳�Э��
 * ������������ģʽʵ�� ��ʽ��--�źŵƷ�
 * ������־λ
 * @author qjq
 *2019��11��23��18:48:32
 */
public class Cooperation02 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Actor(tv).start();
		new Watcher(tv).start();
	}

}
//��Ա
class Actor extends Thread{
	Tv tv;
	

	public Actor(Tv tv) {
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				tv.act("����һ���������·��");
			}else {
				tv.act("���������࣡");
			}
		}

	}
	
}
//����
class Watcher extends Thread{
	Tv tv;
	public Watcher(Tv tv) {
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<10;i++) {
			tv.listen();
		}
	}
}
//ͬһ��Դ
class Tv{
	String voice;//����
	//�źŵ�   T��ʾ��Ա���ݣ����ڵȴ�    F��ʾ���ڹۿ�����Ա�ȴ�
	boolean flag = true;
	public synchronized void act(String voice){
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		//����ʱ��
		this.voice=voice;
		System.out.println("��Ա����"+voice);
		this.notifyAll();//֪ͨ������
		this.flag =!flag;//�л���־
	}
	
	public synchronized void listen(){
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("����������"+voice);
		this.notifyAll();//֪ͨ��Ա��
		this.flag =!flag;//�л���־
	}
	
}

