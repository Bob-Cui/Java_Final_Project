package DataManager;

import DataManager.Data.TitleData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;

public class JsonManager {
    public static class Data {
        private LinkedList<TitleData> datas;

        public Data() {
        }

        public LinkedList<TitleData> getDatas() {
            return datas;
        }

        public void setDatas(LinkedList<TitleData> datas) {
            this.datas = datas;
        }
    }


    public static void main(String[] args) throws IOException {

        CBFileManager cbFileManager = new CBFileManager();
        Gson gson = new Gson();
      //  Data data = new Data();
        TitleData titleData = new TitleData();

        String t = cbFileManager.readJson("C:\\Users\\DELL\\Desktop\\qndy杨志强\\test2.json");

     //   System.out.println(t);
       titleData= gson.fromJson(t, TitleData.class);


      for(TitleData.Subtitle c:titleData.getSubtitles())
      {
//          for
          System.out.println(c.getTitle());
      }
    }

    public static class Title {

    }


}
