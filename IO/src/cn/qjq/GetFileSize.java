package cn.qjq;

import java.io.File;

/**
 * 获取文件大小---字节
 * @author Administrator
 *2019年11月6日20:47:57
 */
public class GetFileSize {
	
	private  long size;//字节大小
	private long dirSize;//目录个数   从当前的目录开始计数的，所以会比实际大一
	private long fileSize;//文件个数
	
	private  File src;
	//构造器
	GetFileSize(File src){
		this.src = src;
		count(this.src);
	}
	
	private void count(File src) {
		if(null == src || !src.exists()) {
			return;
		}else if(src.isDirectory()) {
			for(File f:src.listFiles()) {
				count(f);
			}
			dirSize++;
		}else {
			size+=src.length();
			fileSize++;
		}	
	}
	
	public long getSize() {
		return size;
	}
	
	public long getDirSize() {
		return dirSize;
	}

	public long getFileSize() {
		return fileSize;
	}
    /*************测试代码*************************/
	public static void main(String[] args) {
		File src = new File("E:/JAVA/javaspace/IO");
		GetFileSize g = new GetFileSize(src);
		System.out.println("size: "+g.getSize()+" dirSize: "+g.dirSize+" fileSize: "+g.fileSize);
		src = new File("E:/JAVA/javaspace/IO/src");
		g = new GetFileSize(src);
		System.out.println("size: "+g.getSize()+" dirSize: "+g.dirSize+" fileSize: "+g.fileSize);
	}

}
