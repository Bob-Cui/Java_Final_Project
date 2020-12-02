package Test;

import com.google.gson.Gson;
import org.w3c.dom.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
    private Map<String, User> stringUserMap;

    public Test() {

        stringUserMap = new HashMap<>();


        stringUserMap.put("张das辉", new User(21, "张辉的巴巴"));
        stringUserMap.put("张asdas辉", new User(21, "张辉的巴巴ewarew"));
        stringUserMap.put("张as辉", new User(21, "张辉的巴dfs巴"));



    }

    public static void main(String[] args) throws IOException {

        Test test = new Test();
        Gson gson = new Gson();

//        gson.toJson()

        FileWriter fileWriter = new FileWriter("fuck.json");
        fileWriter.write(gson.toJson(test));
        fileWriter.close();

    }

    private static class User {

        private int num;
        private String name;

        public User(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

