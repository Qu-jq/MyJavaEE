package cn.qjq.jdbctest;

import java.sql.*;
import java.util.Random;

/**
 *测试时间类型Date  Timestamp
 * 插入1000条随机时间
 * Created by qjq on 2020/1/13 20:22
 */
public class demo07 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //执行SQL
            for(int i=0;i<1000;i++){

                ps = connection.prepareStatement("INSERT INTO jdbcuser(username,pwd,regdata,logindata) VALUES(?,?,?,?)");
                ps.setObject(1,"小区"+i);
                ps.setObject(2,"123");
                int rand = 100000000+new Random().nextInt(1000000000);
                java.sql.Date date = new  java.sql.Date(System.currentTimeMillis()-rand);
                ps.setDate(3,date);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis()-rand);//如果需要输入指定时间，可以使用Calendar,DateFormat
                ps.setTimestamp(4,timestamp);
                ps.execute();
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //先开的后关
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
