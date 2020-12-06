package DataManager.PreProcessing;

import DataManager.CBFileManager;

import DataManager.Data.*;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    /**
     * @return 从配置文件中读出关于标题的数据并将其转化为一个大类
     * @throws IOException
     */


    /**
     * 读取listView中需要用到的数据
     *
     * @return
     * @throws IOException
     */
    public static BigTitle getTitleData() throws IOException {
        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();
        BigTitle bigTitle;
        String t = CBFileManager.readJson("source/list_title.json");
        bigTitle = gson.fromJson(t, BigTitle.class);
        return bigTitle;
    }

    /**
     * @return 返回管理
     * @throws IOException
     */
    public static BigTitleManager getBigTitleManager() throws IOException {
        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();

        BigTitleManager bigTitleManager;

        String t = CBFileManager.readJson("src\\new.json");

        bigTitleManager = gson.fromJson(t, BigTitleManager.class);
        return bigTitleManager;
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

            for (TitleManager titleManager : subTitleManager.getTitleList()) {
                NewTitleManager newTitleManager = new NewTitleManager(titleManager.getName(), titleManager.getResource(), false);

                int j=1;
                for (SelectProblem selectProblem:titleManager.getSelectProblemList()) {

                    newTitleManager.getIntegerSelectProblemHashMap().put(j, selectProblem);
                    j++;
                }
                newSubTitleManager.getStringNewTitleManagerHashMap().put(titleManager.getName(), newTitleManager);


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

    public static void main(String[] args) throws IOException {
        preProcessing();
    }


}
