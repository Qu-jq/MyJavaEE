package cn.qjq;

import java.io.*;
import java.net.URL;

/**
 * ת�����������ı���
InputStreamReader    �ֽڼ�-->�ַ���     ����
outputStreamWriter   �ַ���-->�ֽڼ�     ����

-------------��üӻ���������  -->Ч�ʸ�

1�����ַ�������ʽ�����ֽ��������ı���
2��ָ���ַ���
 * @author qjq
 *2019��11��12��15:12:53
 */
public class ConvertStream {
	public static void main(String[] args) {
		//����������   ���ذٶȵ�Դ����
		
		try (BufferedReader is = 
				new BufferedReader(
						new InputStreamReader(
								new URL("http://www.baidu.com").openStream(),"GBK"));
				BufferedWriter os = 
						new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream("baidu.html"),"GBK"));){
			
			/*int temp;
			while((temp=is.read())!=-1) {//һ���ֽ�һ���ֽڵĶ�
				System.out.print((char)temp);//���ֲ�������
			}*/
			String data="";
			while((data = is.readLine())!=null) {
				System.out.println(data);
				os.write(data);
				os.newLine();
			}
			os.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	/*
	 * 1�����ַ�������ʽ�����ֽ��������ı���
	 */
	public static void test01(){
		try(BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(System.out));) {
			String data  = "";
			/*while((data=isr.readLine())!=null) {
				osw.write(data);
				osw.newLine();
			}*/
			//ѭ����ȡ�������루exit�˳���
			while(!data.equals("exit")) {
				data = isr.readLine();
				osw.write(data);
				osw.newLine();
				osw.flush();//�ڴ˴�ǿ��ˢ�£���Ȼ����ʾ����Ϊ������С����û�дﵽ������Ĭ�ϵĴ�С
			}
			//osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ��������Դ��
	 * ����һ���ֽ�һ���ֽڵĶ�ȡ�����ֳ�������
	 */
	public static void test02() {
		try (InputStream is = new URL("http://www.baidu.com").openStream();){
			
			int temp;
			while((temp=is.read())!=-1) {//һ���ֽ�һ���ֽڵĶ�
				System.out.print((char)temp);//���ֲ�������
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * InputStreamReader���ֽ�ת��Ϊ�ַ�
	 */
	public static void test03() {
		try (InputStreamReader is = 
				new InputStreamReader(new URL("http://www.baidu.com").openStream(),"GBK");){
			
			int temp;
			while((temp=is.read())!=-1) {//ÿ������InputStreamReader��read��������֮һ���ܻᵼ�´ӵײ��ֽ���������ȡһ�������ֽڡ� Ϊ��ʹ�ֽ���Ч��ת��Ϊ�ַ������Դӵײ�����ȡ�����㵱ǰ��ȡ��������ĸ����ֽڡ� 
				System.out.print((char)temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


