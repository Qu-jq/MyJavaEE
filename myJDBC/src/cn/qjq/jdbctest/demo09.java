package cn.qjq.jdbctest;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *测试CLOB 文本大对象的使用
 * 将文本、字符串插入数据库的CLOB字段
 * 取出CLOB数据
 * Created by qjq on 2020/1/15 15:55
 */
public class demo09 {

    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        Reader r = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //执行SQL
            ps = connection.prepareStatement("INSERT INTO jdbcuser(username,myInfo) VALUES(?,?)");
            ps.setString(1,"小mi");
            //第一种方式 将文本插入数据库的CLOB字段
            /*try {
                ps.setClob(2,new FileReader(new File("a.txt")));//将文本内容直接输入到数据库
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ps.executeUpdate();*/
            //第二种方式 将字符串插入数据库的CLOB字段
           /* ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("hello the young boy!".getBytes()))));
            ps.executeUpdate();*/

            //取出CLOB数据
            ps = connection.prepareStatement("SELECT id,myInfo FROM jdbcuser where id = 1003");
            rs = ps.executeQuery();
            while(rs.next()){
                Clob clob = rs.getClob("myInfo");
                r = clob.getCharacterStream();
                int temp=0;
                while((temp = r.read())!=-1){
                    System.out.print((char)temp);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //先开的后关
            try {
                if(r != null){
                    r.close();
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
