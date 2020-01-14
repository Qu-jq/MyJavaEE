package cn.qjq.jdbctest;

import java.sql.*;

/**
 *增加关闭资源，学习ResultSet结果集的用法
 * Created by qjq on 2020/1/13 20:22
 */
public class demo04 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            System.out.println(connection);
            //使用PreparedStatement接口执行sql
            String sql = "SELECT id,username,age FROM users WHERE id>?";//?为占位符
            ps = connection.prepareStatement(sql);
            ps.setInt(1,7);//将id大于7的记录读取出来
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //先开的后关 ResultSet->Statement->Connection
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
