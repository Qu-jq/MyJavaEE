package cn.qjq.xc;
/**
 * �߳�Э��
 * ������������ģʽʵ��---�̷ܳ�
 * ����������
 * @author qjq
 *2019��11��23��16:21:13
 */
public class Cooperation01 {
	public static void main(String[] args) {
		SynContainers sc = new SynContainers();
		new Productor(sc).start();
		new Consumer(sc).start();
	}

}
//������
class Productor extends Thread{
	SynContainers sc;
	
	public Productor(SynContainers sc) {
		this.sc = sc;
	}

	public void run() {
		//ֹͣ����
		
		for(int i=0;i<100;i++) {
			System.out.println("����"+i+"��ͷ");
			sc.push(new Steamedbun(i));
		}

	}
}

//������
class Consumer extends Thread{
	SynContainers sc;
	public Consumer(SynContainers sc) {
		this.sc = sc;
	}
	public void run() {
		//����
		for(int i=0;i<100;i++) {
			System.out.println("����"+"��ͷ"+sc.pop().getId());
		}
	}
}
//������
class SynContainers{
	Steamedbun[] buns = new Steamedbun[10];
	int count = 0;
	
	public synchronized void push(Steamedbun s) {
		//�洢  --����
		if(count == buns.length) {
			try {
				this.wait();//�߳������������ͷ�����������֪ͨ�������������
			} catch (InterruptedException e) {
			}
		}
			
	//�������ڿռ�ʱ����������
		buns[count] = s;
		count++;
		this.notifyAll();//����������������֪ͨ������
	}

	//ȡ��  --����
	public synchronized Steamedbun pop() {
		//����������ʱ���ȴ�
		if(count==0) {
			try {
				this.wait();//�߳�������������֪ͨ���ѣ��������
			} catch (InterruptedException e) {
			}
		}
		//������������ʱ����������
		count--;
		this.notifyAll();//���ڿռ䣬����֪ͨ������
		return buns[count];
		
	}
}
//���  --��Դ
class Steamedbun{
	private int id;

	public Steamedbun(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}

