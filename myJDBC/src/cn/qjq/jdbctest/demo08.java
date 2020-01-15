package cn.qjq.jdbctest;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *测试时间类型Date  Timestamp  取出指定时间段的数据
 * Created by qjq on 2020/1/13 20:22
 */
public class demo08 {
    public static long str2Date(String strDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return dateFormat.parse(strDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }
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
            //执行SQL
            ps = connection.prepareStatement("SELECT id,username,regdata From jdbcuser WHERE regdata >? AND regdata<?");
            java.sql.Date start = new java.sql.Date(str2Date("2020-01-10 12:00:00"));
            java.sql.Date end = new java.sql.Date(str2Date("2020-01-14 12:00:00"));
            ps.setObject(1,start);
            ps.setObject(2,end);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getDate(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //先开的后关
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
