package DataManager.Data;

import com.google.gson.Gson;

import java.io.IOException;
import java.sql.*;

public class MySqlManager {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/cbdatabase?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASSWORD = "010095cb";


    /**
     * 注册一个新用户需要使用到的函数
     * 我并不打算实现用户名查重的功能了！！！！！！
     *
     * @param userData 怎么会报这么多奇怪的异常
     */
    public static void register(UserInformation userData) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement statement;
        Class.forName(JDBC_DRIVER);
        String sql = "insert into userinfor(username, password, learnrecord, configfile)values (?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, userData.getName());
        statement.setString(2, userData.getPassword());
        Gson gson = new Gson();
        statement.setString(4, gson.toJson(userData.getUserBigTitle()));
        statement.setString(3, gson.toJson(userData.getDateRecord()));
        statement.executeUpdate();//更新并执行这一条语句
    }


    /**
     * 用于登录时检查数据库中是否存在这个用户，有的话就返回相关的数据
     *
     * @param name     用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回查找的用户的相关数据
     * @throws ClassNotFoundException
     */
    public static UserInformation searchUser(String name, String password) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = String.format("select * from  userinfor where username='%s'", name);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String searchPassWord = resultSet.getString("password");
            if (searchPassWord.equals(password)) {
                /**
                 * 说明用户名与密码是吻合的
                 */
                Gson gson = new Gson();
                String learnRecordStr = resultSet.getString("learnrecord");
                String bigTitleStr = resultSet.getString("bigtitle");
                UserInformation userData = new UserInformation(name, password, gson.fromJson(bigTitleStr, BigTitle.class), gson.fromJson(learnRecordStr, LearnRecord.class));
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
     *
     * @param userData
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void alterConfigFile(UserInformation userData) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        String sql = "update userinfor set learnrecord=?,bigtitle=? where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Gson gson = new Gson();
        preparedStatement.setString(1, gson.toJson(userData.getUserBigTitle()));
        preparedStatement.setString(2, gson.toJson(userData.getUserBigTitle()));
        preparedStatement.setString(3, userData.getName());
        preparedStatement.executeUpdate();
    }
}

