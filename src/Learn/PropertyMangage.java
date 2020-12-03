package Learn;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PropertyMangage {

//    private static Properties properties;
//
//    static {
//        properties = new Properties();
//        try {
//            properties.load(PropertyMangage.class.getClassLoader().getResourceAsStream("Config"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//

    private static class Item {

        private Date date;
        private String string;

        public Item(Date date, String string) {
            this.date = date;
            this.string = string;
        }
    }

    public static String get(String input) {


//        return (String) properties.get(input);
        return null;
    }

    public static void main(String[] args) {

        Item item = new Item(new Date(), "dsaffd");
        Gson gson = new Gson();
        Date date = new Date();
        Date date1 = new Date();
        //System.out.println(date1-date);

        System.out.println(gson.toJson(item));

        System.out.println(new Date());
    }

}
