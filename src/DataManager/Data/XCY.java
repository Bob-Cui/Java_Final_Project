package DataManager.Data;

import com.google.gson.Gson;

import java.util.HashMap;

public class XCY {

    public static class Learn {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Learn(String name) {
            this.name = name;
        }
}

    private HashMap<String, Learn> newName;
    private String sb;
    public XCY(HashMap<String, Learn> c) {
        this.newName = c;
        sb = "dfasdasfasdf";
    }

    public static void main(String[] args) {
//        XCY x=new XCY("sfasa");
        Gson gson = new Gson();
        HashMap<String, Learn> stringXCYHashMap = new HashMap<>();

        stringXCYHashMap.put("第一个", new Learn("ghfghfd"));
        XCY xcy = new XCY(stringXCYHashMap);

        System.out.println(gson.toJson(xcy));

    }


}
