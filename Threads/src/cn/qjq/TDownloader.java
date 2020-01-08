package cn.qjq;

public class TDownloader extends Thread{
	private String url;//Զ��·��
	private String name;//�洢����
	public TDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
	}

	public static void main(String[] args) {
		TDownloader td1 = new TDownloader("https://c-ssl.duitang.com/uploads/item/201205/22/20120522233128_fJz3U.thumb.700_0.jpeg","fengjing.jpg");
		TDownloader td2 = new TDownloader("https://c-ssl.duitang.com/uploads/item/201911/06/20191106223115_chxiu.thumb.700_0.jpeg","moon.jpg");
		TDownloader td3 = new TDownloader("https://c-ssl.duitang.com/uploads/item/201911/06/20191106223118_lhyuh.thumb.700_0.jpeg","classic.jpg");
		td1.start();
		td2.start();
		td3.start();//˭�����ز�ȷ��
	}
}
