package cn.qjq;

/**
 * 终止线程
 * 1.线程正常执行完毕 -->次数 
 * 2.外部干涉 ---> 加入标识
 * @author qjq 
 * 2019年11月20日14:56:10
 */
public class TerminateThread implements Runnable {
	private boolean flag = true;
	private String name;

	public TerminateThread(String name) {
		this.name = name;
	}

	public void run() {
		int i = 0;
		//关联标识，true运行  false停止
		while (flag) {
			System.out.println(name + "-->" + i++);
		}
	}

	// 对外提供方法改变标识
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
