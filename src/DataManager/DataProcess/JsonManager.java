package DataManager.DataProcess;

import DataManager.Data.SelectProblem;
import DataManager.XCYFileManager;

import DataManager.Data.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

public class JsonManager {


    /**
     * 读取listView中需要用到的数据
     *
     * @return
     * @throws IOException
     */
    public static BigTitle getTitleData() throws IOException {
        XCYFileManager cbFileManager = new XCYFileManager();
        Gson gson = new Gson();
        BigTitle bigTitle;
        String t = XCYFileManager.readJson("source/list_title.json");
        bigTitle = gson.fromJson(t, BigTitle.class);
        return bigTitle;
    }

    /**
     * @return 返回管理
     * @throws IOException
     */


    /**
     * 这个函数是用于处理我目前遇到的旧数据处理类向新数据处理类的转换问题的
     *
     * @throws IOException
     */


    /**
     * 读取一个测试题json文件并返回响应的类
     *
     * @param address
     * @return
     * @throws IOException
     */
    public static NewProblems getNewProblems(String address) throws IOException {
        XCYFileManager xcyFileManager = new XCYFileManager();
        Gson gson = new Gson();
        String string = XCYFileManager.readJson(address);
        return gson.fromJson(string, NewProblems.class);
    }

    public static BigTitle getBigTitle() throws IOException {

        Gson gson = new Gson();
        String str = XCYFileManager.readJson("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\final.json");
        return gson.fromJson(str, BigTitle.class);
    }

    public static LearnRecord getLearnRecord() throws IOException {

        Gson gson = new Gson();
        String str = XCYFileManager.readJson("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\learnRecord.json");
        return gson.fromJson(str, LearnRecord.class);
    }

    public static void main(String[] args) throws IOException {

        LearnRecord learnRecord = JsonManager.getLearnRecord();


        for(Map.Entry<Integer, LearnRecord.TimeItem>integerTimeItemEntry:learnRecord.getIntegerTimeItemTreeMap().entrySet())
        {
            System.out.println(integerTimeItemEntry.getValue().getTimeSpan());
        }


        System.out.println(learnRecord.getIntegerTimeItemTreeMap());

    }


}
