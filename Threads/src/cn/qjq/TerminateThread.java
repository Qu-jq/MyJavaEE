package cn.qjq;

/**
 * ��ֹ�߳�
 * 1.�߳�����ִ����� -->���� 
 * 2.�ⲿ���� ---> �����ʶ
 * @author qjq 
 * 2019��11��20��14:56:10
 */
public class TerminateThread implements Runnable {
	private boolean flag = true;
	private String name;

	public TerminateThread(String name) {
		this.name = name;
	}

	public void run() {
		int i = 0;
		//������ʶ��true����  falseֹͣ
		while (flag) {
			System.out.println(name + "-->" + i++);
		}
	}

	// �����ṩ�����ı��ʶ
	public void terminate() {
		this.flag = false;
	}

	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread("xiaoming");
		new Thread(tt).start();
		for(int i =0;i<100;i++) {
			if(i==88)
				tt.terminate();
			System.out.println("main"+i);
		}

	}

}
