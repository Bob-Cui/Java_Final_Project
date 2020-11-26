package DataManager;

import java.sql.*;

public class MysqlManager {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/webnews?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    static final String USER = "root";
    static final String PASSWORD = "010095cb";

    /**
     * 终于连接数据库成功
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库");
        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        statement = connection.createStatement();


        String sql = "select * from news_data";


        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {


            String a = resultSet.getString("content");
            String b = resultSet.getString("link");

            System.out.println(a + "   " + b);

        }

    }
}
