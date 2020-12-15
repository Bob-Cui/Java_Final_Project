package DataManager.DataProcess;

import DataManager.XCYFileManager;

import DataManager.Data.*;
import DataManager.Data.OldData.*;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {


    public static final String XCYCONFIGFILE = "final_test.json";

    /**
     * @return 返回管理
     * @throws IOException
     */
    public static BigTitleManager getBigTitleManager() throws IOException {
        XCYFileManager cbFileManager = new XCYFileManager();
        Gson gson = new Gson();

        BigTitleManager bigTitleManager;

        String t = XCYFileManager.readJson("src\\new.json");

        bigTitleManager = gson.fromJson(t, BigTitleManager.class);
        return bigTitleManager;
    }

    /**
     * 返回一个用于操纵所有数据的NewBigTitleManager类
     *
     * @return
     * @throws IOException
     */
    public static NewBigTitleManager getNewBigTitleManager() throws IOException {
        XCYFileManager cbFileManager = new XCYFileManager();
        Gson gson = new Gson();
        BigTitleManager bigTitleManager;
        String t = XCYFileManager.readJson("final.json");
        return gson.fromJson(t, NewBigTitleManager.class);
    }

    /**
     * 这个函数是用于处理我目前遇到的旧数据处理类向新数据处理类的转换问题的
     *
     * @throws IOException
     */
    public static void preProcessing() throws IOException {
//        BigTitle bigTitle = getTitleData();
        BigTitleManager bigTitleManager = getBigTitleManager();

        NewBigTitleManager newBigTitleManager = new NewBigTitleManager();


        NewSubTitleManager newSubTitleManagerPri = new NewSubTitleManager(true);

        int i = 0;
        for (SubTitleManager subTitleManager : bigTitleManager.getSubTitleManagerLinkedLists()) {
            NewSubTitleManager newSubTitleManager = new NewSubTitleManager(false);
            int k = 1;
            for (TitleManager titleManager : subTitleManager.getTitleList()) {
                NewTitleManager newTitleManager = new NewTitleManager(titleManager.getName(), titleManager.getResource(), false);
                int j = 1;
                for (SelectProblem selectProblem : titleManager.getSelectProblemList()) {
                    NewSelectProblem newSelectProblem = new NewSelectProblem(j, selectProblem.getContent(), selectProblem.getA(), selectProblem.getB(), selectProblem.getC(), selectProblem.getD(), selectProblem.getAns());
                    newTitleManager.getIntegerSelectProblemHashMap().put(j, newSelectProblem);
                    j++;
                }
                newSubTitleManager.getIntegerNewTitleManagerTreeMap().put(k, newTitleManager);
                k++;
                newSubTitleManager.getStringNewTitleManagerTreeMap().put(titleManager.getName(), newTitleManager);
            }
            String t = "";
            if (i == 0) {
                t = "Java初级教程";
            } else if (i == 1) {
                t = "Java中级教程";
            } else if (i == 2) {
                t = "Java高级教程";
            }
            System.out.println(t);
            newBigTitleManager.getStringNewSubTitleManagerHashMap().put(t, newSubTitleManager);
            i++;
        }
        Gson gson = new Gson();
        String c = gson.toJson(newBigTitleManager);
        FileWriter fileWriter = new FileWriter("final.json");
        fileWriter.write(c);
        fileWriter.close();


    }


    /**
     * 把所有题的答案全部都换成A
     *
     * @throws IOException
     */
    public static void preDealAnswer() throws IOException {
        BigTitleManager bigTitleManager = getBigTitleManager();

        NewBigTitleManager newBigTitleManager = new NewBigTitleManager();


        // NewSubTitleManager newSubTitleManagerPri = new NewSubTitleManager(true);

        int i = 0;
        for (SubTitleManager subTitleManager : bigTitleManager.getSubTitleManagerLinkedLists()) {

            NewSubTitleManager newSubTitleManager = new NewSubTitleManager(false);

            for (TitleManager titleManager : subTitleManager.getTitleList()) {
                NewTitleManager newTitleManager = new NewTitleManager(titleManager.getName(), titleManager.getResource(), false);

                int j = 1;
                for (SelectProblem selectProblem : titleManager.getSelectProblemList()) {
                    NewSelectProblem newSelectProblem = new NewSelectProblem(j, selectProblem.getContent(), selectProblem.getA(), selectProblem.getB(), selectProblem.getC(), selectProblem.getD(), selectProblem.getAns());

                    /**
                     * 替换所有题的答案全部都是A
                     */
                    newSelectProblem.setAnswer('A');
                    newTitleManager.getIntegerSelectProblemHashMap().put(j, newSelectProblem);
                    j++;
                }
                newSubTitleManager.getStringNewTitleManagerTreeMap().put(titleManager.getName(), newTitleManager);
            }
            String t = "";
            if (i == 0) {
                t = "Java初级教程";
            } else if (i == 1) {
                t = "Java中级教程";
            } else if (i == 2) {
                t = "Java高级教程";
            }
            System.out.println(t);
            newBigTitleManager.getStringNewSubTitleManagerHashMap().put(t, newSubTitleManager);

            i++;

        }

        Gson gson = new Gson();
        String c = gson.toJson(newBigTitleManager);
        FileWriter fileWriter = new FileWriter("final_test.json");
        fileWriter.write(c);
        fileWriter.close();
    }

    /**
     * 将原来的包含题目数据的json读取之后转换为新的文件
     *
     * @return 返回一个包含所有问题的问题类
     * @throws IOException
     */
    public static void getProblemsToNewProblems(String address, String to) throws IOException {
        XCYFileManager cbFileManager = new XCYFileManager();
        Gson gson = new Gson();


        Problems problems;
        String string = XCYFileManager.readJson(address);

        problems = gson.fromJson(string, Problems.class);

        NewProblems newProblems = new NewProblems();

        for (int i = 0; i < problems.getSelectProblemLinkedList().size(); i++) {
            SelectProblem selectProblem = problems.getSelectProblemLinkedList().get(i);
            NewSelectProblem newSelectProblem = new NewSelectProblem(i + 1, selectProblem.getContent(), selectProblem.getA(), selectProblem.getB(), selectProblem.getC(), selectProblem.getD(), selectProblem.getAns());

            newProblems.getIntegerNewSelectProblemHashMap().put(i + 1, newSelectProblem);
        }
        FileWriter fileWriter = new FileWriter(to);
        fileWriter.write(gson.toJson(newProblems));
        fileWriter.close();
    }

    /**
     * 调用三次将文件进行转换
     *
     * @throws IOException
     */
    public static void dealTestQuestions() throws IOException {
        getProblemsToNewProblems("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\src\\Source\\初级测试题.json", "pritest.json");
        getProblemsToNewProblems("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\src\\Source\\中级测试题.json", "midtest.json");
        getProblemsToNewProblems("C:\\Users\\DELL\\Desktop\\JavaFinalProject\\src\\Source\\高级测试题.json", "sentest.json");
    }


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


    /**
     * @param data 用于写回NewBigTitleManager数据
     * @throws IOException
     */
    public static void writeConfigure(NewBigTitleManager data) throws IOException {
        //FileWriter fileWriter = new FileWriter(XCYCONFIGFILE,true);加上true,这说明要在文件之后写入
        //不加true说明要将原来的文件整体清空，写入新的文件
        FileWriter fileWriter = new FileWriter(XCYCONFIGFILE);
/**
 * 依然是熟悉的Gson转换器
 */
        Gson gson = new Gson();

        String str = gson.toJson(data);

        fileWriter.write(str);


        //要记住关掉这个文件写入器
        fileWriter.close();

    }

    /**
     * 用于写测试数据
     * @param newProblems
     * @param title 你要写回的数据属于哪一个文件，初级、中级、高级
     * @throws IOException
     */
    public static void writeTestData(NewProblems newProblems,String title) throws IOException {
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

    public static void main(String[] args) throws IOException {


        preProcessing();
        preDealAnswer();
    }
}
