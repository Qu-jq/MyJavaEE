package cn.qjq.jdbctest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 *测试JDBCUtil
 * 注意此时的db.properties要放在src文件目录下
 * Created by qjq on 2020/1/15 16:22
 */
public class demo11 {

    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
           connection = JDBCUtil.getMysqlConn();
           ps = connection.prepareStatement("INSERT INTO users(username,age) VALUES('xiaoqu',18)");
           ps.execute();

        } catch (Exception e) {
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
