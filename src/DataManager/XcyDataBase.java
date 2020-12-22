package DataManager;

import DataManager.Data.AllData;
import DataManager.Data.UserData;
import DataManager.DataProcess.JsonManager;
import com.google.gson.Gson;
import com.mysql.cj.x.protobuf.MysqlxSession;

import java.io.IOException;
import java.sql.*;

public class XcyDataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/xcyfinal?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASSWORD = "010095cb";


    /**
     * 注册一个新用户需要使用到的函数
     * 我并不打算实现用户名查重的功能了！！！！！！
     *
     * @param userData 怎么会报这么多奇怪的异常
     */
    public static void register(UserData userData) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement statement;
        Class.forName(JDBC_DRIVER);

        String sql = "insert into xcyfinal.user_data(username, password, config, timespan)VALUES(?,?,?,?)";

        statement = connection.prepareStatement(sql);
        statement.setString(1, userData.getName());
        statement.setString(2, userData.getPassword());

        Gson gson = new Gson();

        statement.setString(3, gson.toJson(userData.getUserData()));
        statement.setLong(4, userData.getTimeSpan());


        statement.executeUpdate();//更新并执行这一条语句

        System.out.println("成功插入用户的信息");
    }


    /**
     * 用于登录时检查数据库中是否存在这个用户，有的话就返回相关的数据
     *
     * @param name     用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回查找的用户的相关数据
     * @throws ClassNotFoundException
     */
    public static UserData searchUser(String name, String password) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = String.format("select * from user_data where username='%s'", name);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String searchPassWord = resultSet.getString("password");
            if (searchPassWord.equals(password)) {
                /**
                 * 说明用户名与密码是吻合的
                 */
                UserData userData = new UserData(name, password, resultSet.getLong("timespan"));
                Gson gson = new Gson();
                AllData allData = gson.fromJson(resultSet.getString("config"), AllData.class);
                userData.setUserData(allData);
                return userData;
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Gson gson = new Gson();


    }

    /**
     * 修改用户的配置文件
     * @param userData
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void alterConfigFile(UserData userData) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        String sql = "update user_data set timespan=?,config=? where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, userData.getTimeSpan());
        Gson gson = new Gson();
        preparedStatement.setString(2, gson.toJson(userData.getUserData()));
        preparedStatement.setString(3, userData.getName());
        preparedStatement.executeUpdate();
    }

    /**
     * 终于连接数据库成功
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        Class.forName(JDBC_DRIVER);
//        System.out.println("连接数据库");
//        connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//
//
//        String sql = "insert into xcyfinal.user(name, password, configFile, timeSpan)\n" +
//                "VALUES(?,?,?,?)";
//        statement = connection.prepareStatement(sql);
//        statement.setLong(4, 1);
//        statement.setString(1, "张辉");
//        statement.setString(2, "123456");
//        Gson gson = new Gson();
//        try {
//            statement.setString(3, gson.toJson(JsonManager.getNewNewBigTitleManager()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int a = statement.executeUpdate();
//        System.out.println("");
//    }
}
