package cn.qjq.jdbctest;

import java.sql.*;

/**
 *批量插入数据
 * Created by qjq on 2020/1/13 20:22
 */
public class demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            connection.setAutoCommit(false);//事务设置为手动提交
            //执行sql
            long start = System.currentTimeMillis();
            statement = connection.createStatement();
            for(int i=0;i<2000;i++){
                String sql = "INSERT INTO users(username,age,data) VALUES('qu"+i+"',18,now())";
                statement.addBatch(sql);
            }
            statement.executeBatch();
            connection.commit();//提交事务
            long end = System.currentTimeMillis();
            System.out.println("插入2万条记录耗时（毫秒）:"+(end-start));
    
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //先开的后关
            try {
                if(statement!=null){
                    statement.close();
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
