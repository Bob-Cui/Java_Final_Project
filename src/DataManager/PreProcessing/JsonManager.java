package DataManager.PreProcessing;

import DataManager.CBFileManager;

import DataManager.Data.BigTitleManager;
import DataManager.Data.SubTitleManager;
import DataManager.Data.TitleManager;
import DataManager.Data.TitleType;
import com.google.gson.Gson;

import javax.swing.*;
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
     *
     * @return 返回管理
     * @throws IOException
     */
    public static BigTitleManager getBigTitleManager() throws IOException {
        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();

        BigTitleManager bigTitleManager;

        String t = CBFileManager.readJson("config.json");

        bigTitleManager = gson.fromJson(t, BigTitleManager.class);
        return bigTitleManager;
    }

    /**
     * 这个函数是用于处理我目前遇到的旧数据处理类向新数据处理类的转换问题的
     * @throws IOException
     */
    public void preProcessing() throws IOException {
        BigTitle bigTitle = getTitleData();
        BigTitleManager bigTitleManager = new BigTitleManager();


        SubTitleManager subTitleManagerpri = new SubTitleManager(TitleType.PRIMARY);
        SubTitleManager subTitleManagermid = new SubTitleManager(TitleType.INTERMEDIATE);
        SubTitleManager subTitleManagersen = new SubTitleManager(TitleType.ADVANCED);


        for (Title title : bigTitle.getPriTitleList()) {
            subTitleManagerpri.getLinkedListTitle().add(new TitleManager(title.getName()));
        }
        for (Title title : bigTitle.getMidTitleList()) {
            subTitleManagermid.getLinkedListTitle().add(new TitleManager(title.getName()));
        }
        for (Title title : bigTitle.getSenTitleList()) {
            subTitleManagersen.getLinkedListTitle().add(new TitleManager(title.getName()));
        }

        bigTitleManager.setPriSubTitleManager(subTitleManagerpri);
        bigTitleManager.setMidSubTitleManager(subTitleManagermid);
        bigTitleManager.setSenSubTitleManager(subTitleManagersen);


        Gson gson = new Gson();

        FileWriter fileWriter = new FileWriter("config.json");
        fileWriter.write(gson.toJson(bigTitleManager));
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {





    }


}
