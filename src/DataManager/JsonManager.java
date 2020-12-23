package DataManager;


import DataManager.Data.*;

import DataManager.XCYFileManager;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class JsonManager {

    /**
     * 总数据的地址
     */
    public static final String XCYCONFIGFILE = "final_test.json";

    /**
     * 初级考试
     */
    public static final String PRITEST = "src/Source/pritest.json";

    /**
     * 中级考试
     */
    public static final String MIDTEST = "src/Source/midtest.json";

    /**
     * 高级考试
     */
    public static final String SENTEST = "src/Source/sentest.json";

    /**
     * 把所有题的答案全部都换成A
     *
     * @throws IOException 文件读写异常
     */
    public static void checkAllAnswerToA() throws IOException {
        Gson gson = new Gson();


        String str = XCYFileManager.readJson("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\data_with_test.json");

        AllData allData = gson.fromJson(str, AllData.class);


        for (Map.Entry<String, SubTitleManager> stringNewSubTitleManagerEntry : allData.getStringNewSubTitleManagerHashMap().entrySet()) {

            for (Map.Entry<Integer, TitleManager> integerNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getIntegerNewTitleManagerTreeMap().entrySet()) {


                for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : integerNewTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().entrySet()) {

                    integerNewSelectProblemEntry.getValue().setAnswer('A');

//                    System.out.println(integerNewSelectProblemEntry.getValue().getAnswer());
                    integerNewSelectProblemEntry.getValue().setYourAnswer('A');

                }
            }
        }
        for (Map.Entry<String, SubTitleManager> stringNewSubTitleManagerEntry : allData.getStringNewSubTitleManagerHashMap().entrySet()) {

            for (Map.Entry<Integer, TitleManager> integerNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getIntegerNewTitleManagerTreeMap().entrySet()) {


                for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : integerNewTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().entrySet()) {


                    System.out.println(integerNewSelectProblemEntry.getValue().getAnswer());


                }
            }
        }
        FileWriter fileWriter = new FileWriter("allAnswerisA111.json");
        fileWriter.write(gson.toJson(allData));

    }


    /**
     * 调用三次将文件进行转换
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
    public static Problems getNewProblems(String address) throws IOException {
        XCYFileManager xcyFileManager = new XCYFileManager();
        Gson gson = new Gson();
        String string = XCYFileManager.readJson(address);
        return gson.fromJson(string, Problems.class);
    }


    /**
     * 用于写测试数据
     *
     * @param newProblems
     * @param title       你要写回的数据属于哪一个文件，初级、中级、高级
     * @throws IOException
     */
    public static void writeTestData(Problems newProblems, String title) throws IOException {
        //FileWriter fileWriter = new FileWriter(XCYCONFIGFILE,true);加上true,这说明要在文件之后写入
        //不加true说明要将原来的文件整体清空，写入新的文件
        FileWriter fileWriter = new FileWriter(XCYCONFIGFILE);
/**
 * 依然是熟悉的Gson转换器
 */
        Gson gson = new Gson();
        /**
         * 转换为json字符串
         */
        String str = gson.toJson(newProblems);
        fileWriter.write(str);
        //要记住关掉这个文件写入器
        fileWriter.close();

    }


    /**
     * 将一个字符串写入文件
     * 这里面还有路径的问题！！！！！！！！
     *
     * @param name    文件的文件名
     * @param content
     * @throws IOException
     */
    public static void toFile(String name, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(name);
        fileWriter.write(content);
        fileWriter.close();
    }

    /**
     * 获得最新的数据
     * 目前用这个函数
     *
     * @return
     */
    public static AllData getNewNewBigTitleManager() throws IOException {

        Gson gson = new Gson();
        String t = XCYFileManager.readJson("data_with_test.json");

        return gson.fromJson(t, AllData.class);
    }

    public static AllData createNewUser() throws IOException {

        AllData allData = getNewNewBigTitleManager();
        Date newDate = new Date();
        for (Map.Entry<String, SubTitleManager> stringNewSubTitleManagerEntry : allData.getStringNewSubTitleManagerHashMap().entrySet()) {
            for (Map.Entry<Integer, TitleManager> integerNewTitleManagerEntry : stringNewSubTitleManagerEntry.getValue().getIntegerNewTitleManagerTreeMap().entrySet()) {
                integerNewTitleManagerEntry.getValue().setDate(newDate);

                for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : integerNewTitleManagerEntry.getValue().getIntegerSelectProblemHashMap().entrySet()) {
                    integerNewSelectProblemEntry.getValue().setYourAnswer(' ');
                }
            }
        }

        for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : allData.getPriNewProblems().getIntegerNewSelectProblemHashMap().entrySet()) {
            integerNewSelectProblemEntry.getValue().setYourAnswer(' ');
        }
        for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : allData.getSenNewProblems().getIntegerNewSelectProblemHashMap().entrySet()) {
            integerNewSelectProblemEntry.getValue().setYourAnswer(' ');
        }
        for (Map.Entry<Integer, SelectProblem> integerNewSelectProblemEntry : allData.getMidNewProblems().getIntegerNewSelectProblemHashMap().entrySet()) {
            integerNewSelectProblemEntry.getValue().setYourAnswer(' ');
        }

        return allData;
    }


    public static void main(String[] args) throws IOException {

        AllData allData = getNewNewBigTitleManager();
        System.out.println(allData.getStringNewSubTitleManagerHashMap().size());

//        String str = XCYFileManager.readJson("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\test.json");
//
//        Gson gson = new Gson();
//        SubTitleManager subTitleManager = gson.fromJson(str, SubTitleManager.class);
//        allData.getStringNewSubTitleManagerHashMap().put("数据结构", subTitleManager);
//
//        System.out.println(subTitleManager.isAbleToLearn());
//
//
//        FileWriter fileWriter = new FileWriter("xcytest.json");
//        fileWriter.write(gson.toJson(subTitleManager));
//        fileWriter.close();


    }
}
