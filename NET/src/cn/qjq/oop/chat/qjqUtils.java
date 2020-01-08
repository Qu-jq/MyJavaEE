package cn.qjq.oop.chat;

import java.io.Closeable;
import java.io.IOException;

/*
 * สอทลืสิด
 */
public class qjqUtils {
	public static void close(Closeable... targets) {
		for(Closeable target:targets) {
			try {
				target.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
