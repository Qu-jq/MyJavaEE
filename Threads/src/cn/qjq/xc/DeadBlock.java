package cn.qjq.xc;
/**
 * ����
 * �����
 * ��Ҫ��ͬһ��������У�ͬʱ���ж�����������
 * @author qjq
 *2019��11��23��15:07:53
 */
public class DeadBlock {
	public static void main(String[] args) {
		MakeUp m = new MakeUp(0,"С��");
		MakeUp m1 = new MakeUp(1,"С����");
		m.start();
		m1.start();
	}

}
//�ں�
class LipStick{

}
//����
class Mirror{
	
}

class MakeUp extends Thread{
	private int choice;//��ױ˳��ѡ��
	private String name;
	static LipStick lipstick = new LipStick();
	static Mirror mirror = new Mirror();
	public MakeUp(int choice, String name) {
		this.choice = choice;
		this.name = name;
	}
	@Override
	public void run() {
		 makeUp();
	}
	public void makeUp() {
		if(choice == 0) {
			synchronized (lipstick) {
				System.out.println(name+"�õ��˿ں�");
				//����1��
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(name+"�õ��˾���");
				}
			}
			/*synchronized (mirror) {
				System.out.println(name+"�õ��˾���");
			}������ɽ������*/
		}else {
			synchronized (mirror) {
				System.out.println(name+"�õ��˾���");
				//����1��
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(name+"�õ��˿ں�");
				}
				
			}
			/*synchronized (lipstick) {
				System.out.println(name+"�õ��˿ں�");
			}������ɽ������*/
		}
		
	}
}
