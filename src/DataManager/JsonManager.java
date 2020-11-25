package DataManager;

import DataManager.Data.BigTitleData;
import DataManager.Data.TitleData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;

public class JsonManager {
    /**
     * @return 从配置文件中读出关于标题的数据并将其转化为一个大类
     * @throws IOException
     */
    public static BigTitleData getBigTitleData() throws IOException {
        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();
        BigTitleData bigTitleData;

        String t = cbFileManager.readJson("source/title_data.json");
        //竟然这种程度的报错也检查的出来真的是神了
        bigTitleData = gson.fromJson(t, BigTitleData.class);

        return bigTitleData;
    }

    public static void main(String[] args) throws IOException {


    }


}
