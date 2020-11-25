package DataManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CBFileManager {

    public String readJson(String address) throws IOException {

        FileReader fileReader = new FileReader(address);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String strLine = null;
        int lineCount = 1;
        StringBuffer stringBuffer = new StringBuffer();


        while ((strLine= bufferedReader.readLine())!=null) {
            stringBuffer.append(strLine);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        CBFileManager cbFileManager = new CBFileManager();

        System.out.println("张辉");
        System.out.println(cbFileManager.readJson("C:\\Users\\DELL\\Desktop\\qndy杨志强\\test1.json"));


    }


}
