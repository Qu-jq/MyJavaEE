package cn.qjq;
/**
 * ʹ��Runnable����
 * @author qjq
 *2019��11��18��11:13:50
 */
public class TDownloader2 implements Runnable{
	private String url;//Զ��·��
	private String name;//�洢����
	public TDownloader2(String url, String name) {
		this.url = url;
		this.name = name;
	}
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
	}

	public static void main(String[] args) {
		TDownloader2 td1 = new TDownloader2("https://c-ssl.duitang.com/uploads/item/201205/22/20120522233128_fJz3U.thumb.700_0.jpeg","fengjing.jpg");
		TDownloader2 td2 = new TDownloader2("https://c-ssl.duitang.com/uploads/item/201911/06/20191106223115_chxiu.thumb.700_0.jpeg","moon.jpg");
		TDownloader2 td3 = new TDownloader2("https://c-ssl.duitang.com/uploads/item/201911/06/20191106223118_lhyuh.thumb.700_0.jpeg","classic.jpg");
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		Thread t3 = new Thread(td3);
		t1.start();
		t2.start();
		t3.start();//˭�����ز�ȷ��
	}
}
