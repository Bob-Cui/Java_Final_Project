package DataManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XCYFileManager {

    public static String readJson(String address) throws IOException {

        FileReader fileReader = new FileReader(address);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String strLine = null;
        int lineCount = 1;
        StringBuffer stringBuffer = new StringBuffer();


        while ((strLine = bufferedReader.readLine()) != null) {
            stringBuffer.append(strLine);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        XCYFileManager cbFileManager = new XCYFileManager();

        System.out.println("张辉");
        System.out.println(readJson("C:\\Users\\DELL\\Desktop\\qndy杨志强\\test1.json"));

        String c = "fsdf";
//        System.out.println();c.substring(3, 4);
    }


}
