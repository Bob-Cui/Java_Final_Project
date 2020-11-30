package DataManager;

import DataManager.Data.BigTitle;
import DataManager.Data.BigTitleData;
import DataManager.Data.Title;
import DataManager.Data.TitleData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;

public class JsonManager {
    /**
     * @return 从配置文件中读出关于标题的数据并将其转化为一个大类
     * @throws IOException
     */


    /**
     * 读取listView中需要用到的数据
     * @return
     * @throws IOException
     */
    public static BigTitle getTitleData() throws IOException {
        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();
        BigTitle bigTitle;
        String t = CBFileManager.readJson("source/list_title.json");
//        System.out.println(t);
        bigTitle = gson.fromJson(t, BigTitle.class);
        return bigTitle;
    }

    public static void main(String[] args) throws IOException {


        BigTitle bigTitle = getTitleData();




       for(Title title:bigTitle.getSenTitleList())
       {
           System.out.println(title.getName());
       }


    }


}
