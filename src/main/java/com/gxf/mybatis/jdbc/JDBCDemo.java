package com.gxf.mybatis.jdbc;

import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * @Author:
 * @Description:
 * @Date: Created in : 2018/10/9 下午9:10
 **/
public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        //加载驱动
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test",
                "root","luckygxf");
        //获取数据库连接
        Statement stmt = conn.createStatement();
        //使用Connection来创建一个Statment对象

        String sql = "SELECT id as id1, name name1, age as age2, home_address as address FROM person WHERE id = 1";
        boolean hasResultSet = stmt.execute(sql);
        //执行SQL,返回boolean值表示是否包含ResultSet
        if (hasResultSet) { //如果执行后有ResultSet结果集
            ResultSet rs = stmt.getResultSet();
            //获取结果集

            ResultSetMetaData metaData = rs.getMetaData();
            //ResultSetMetaData是用于分析结果集的元数据接口
            int  columnCount = metaData.getColumnCount();

            while (rs.next()){//输出ResultSet对象
                for (int i = 0 ; i < columnCount ; i++ ) {
                    System.out.println(rs.getString(i + 1) + "\t");
                }
            }


            for(int i = 1; i <= columnCount; i++){
                System.out.println("metaData.getColumnLabel(i): " + metaData.getColumnLabel(i));
                System.out.println("metaData.getColumnName(i): " + metaData.getColumnName(i));
                System.out.println("metaData.getColumnType(i): " + metaData.getColumnType(i));
                System.out.println("JdbcType.forCode(metaData.getColumnType(i)): " + JdbcType.forCode(metaData.getColumnType(i)));
                System.out.println("metaData.getColumnClassName(i): " + metaData.getColumnClassName(i));
            }


        } else  {
            System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
        }

    }
}
