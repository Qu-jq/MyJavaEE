package cn.qjq.jdbctest;

import java.io.*;
import java.sql.*;

/**
 *测试BLOB
 * 写入和读取
 * Created by qjq on 2020/1/13 20:22
 */
public class demo10 {

    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //执行SQL
            /*ps = connection.prepareStatement("INSERT INTO jdbcuser(username,headImg) VALUES(?,?)");
            ps.setString(1,"小花");
            //将一张图插入BLOB类型字段
            ps.setBlob(2, new FileInputStream("headImg.jpg"));
            ps.executeUpdate();*/

            //取出CLOB数据 并且输出图片
            ps = connection.prepareStatement("SELECT id,headImg FROM jdbcuser where id = 1004");
            rs = ps.executeQuery();
            while(rs.next()){
                Blob blob = rs.getBlob("headImg");
                is = blob.getBinaryStream();
                os =  new FileOutputStream("copy.jpg");
                int temp=0;
                while((temp = is.read())!=-1){
                    os.write(temp);
                }

            }

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            //先开的后关
            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
