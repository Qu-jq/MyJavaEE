package cn.qjq.xc;
/**
 * 死锁
 * 解决：
 * 不要在同一个代码块中，同时持有多个对象的锁。
 * @author qjq
 *2019年11月23日15:07:53
 */
public class DeadBlock {
	public static void main(String[] args) {
		MakeUp m = new MakeUp(0,"小慧");
		MakeUp m1 = new MakeUp(1,"小佩奇");
		m.start();
		m1.start();
	}

}
//口红
class LipStick{

}
//镜子
class Mirror{
	
}

class MakeUp extends Thread{
	private int choice;//化妆顺序选择
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
				System.out.println(name+"拿到了口红");
				//经过1秒
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(name+"拿到了镜子");
				}
			}
			/*synchronized (mirror) {
				System.out.println(name+"拿到了镜子");
			}分两块可解决死锁*/
		}else {
			synchronized (mirror) {
				System.out.println(name+"拿到了镜子");
				//经过1秒
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(name+"拿到了口红");
				}
				
			}
			/*synchronized (lipstick) {
				System.out.println(name+"拿到了口红");
			}分两块可解决死锁*/
		}
		
	}
}
