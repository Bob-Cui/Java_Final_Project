package main.java.CBGui;

import DataManager.Data.UserData;
import javafx.application.Application;
import javafx.stage.Stage;
import main.java.CBGui.SpecificStage.AfterLoginStage;
import main.java.CBGui.SpecificStage.LoginStage;
import main.java.CBGui.SpecificStage.XCYMain;

public class XCYApplication extends Application {

    /**
     * 这个成了所有数据的来源
     */
    public static UserData thisUser;

    static {
        thisUser = null;


    }

    /**
     * 调用一个静态方法 设置所有数据的来源
     *
     * @param userData 需要设置的数据
     */
    public static void setUserData(UserData userData) {
        thisUser = userData;
    }

    /**
     * 运行时调用start
     *
     * @param primaryStage
     * @throws Exception 异常
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new XCYMain();
        primaryStage.show();
        LoginStage loginStage = new LoginStage();
        loginStage.showAndWait();
        /**
         * 这里用比较简单的方法，比较好理解
         */


        if (thisUser != null) {

/**
 * 这一步很重要
 */
            XCYMain.setAllData(thisUser.getUserData());


            AfterLoginStage afterLoginStage = new AfterLoginStage();
            afterLoginStage.showAndWait();


            /**
             * 判断要不要学数据结构
             */


        }


    }
}
