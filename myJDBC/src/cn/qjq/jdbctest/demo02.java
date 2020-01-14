package cn.qjq.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *测试Statement接口的用法，执行SQL语句，测试SQL注入问题
 * Created by qjq on 2020/1/13 20:22
 */
public class demo02 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //通过Statement接口，SQL语句执行
            statement = connection.createStatement();
           /* String username = "小区";
            String sql = "INSERT INTO users(username,age) VALUES('"+username+"',16)";
            statement.execute(sql);//users表中被成功插入一条记录*/

           //测试SQL注入
            String age = "6 or 1=1";//由于对输入没有限制，就会产生输入不规范的情况
            String sql = "DELETE FROM users WHERE age="+age;//where语句恒为真
            statement.execute(sql);//数据表中的数据全部被删除

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
