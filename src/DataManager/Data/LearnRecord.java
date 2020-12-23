package DataManager.Data;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

/**
 * 统计一下这个人所有打开软件的记录
 */
public class LearnRecord {

    public static class TimeItem {
        private Date beginDate, endDate;

        public TimeItem(Date beginDate, Date endDate) {
            this.beginDate = beginDate;
            this.endDate = endDate;
        }

        public int getTimeSpan() {
            return (int) (endDate.getTime() - beginDate.getTime()) / (1000 * 60);
        }

        public Date getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }
    }

    private TreeMap<Integer, TimeItem> integerTimeItemTreeMap;

    public LearnRecord(TreeMap<Integer, TimeItem> integerTimeItemTreeMap) {
        this.integerTimeItemTreeMap = integerTimeItemTreeMap;
    }

    public TreeMap<Integer, TimeItem> getIntegerTimeItemTreeMap() {
        return integerTimeItemTreeMap;
    }

    public void setIntegerTimeItemTreeMap(TreeMap<Integer, TimeItem> integerTimeItemTreeMap) {
        this.integerTimeItemTreeMap = integerTimeItemTreeMap;
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        TreeMap<Integer, TimeItem> timeItemTreeMap = new TreeMap<>();

        Date now = new Date();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {

            int j = random.nextInt(24);
            Date dateBegin = new Date(now.getTime() + j * 1000000);

            Date dateEnd = new Date(dateBegin.getTime() + j * 4000000);

            timeItemTreeMap.put(i, new TimeItem(dateBegin, dateEnd));

        }
        LearnRecord learnRecord = new LearnRecord(timeItemTreeMap);
        String str = gson.toJson(learnRecord);

        FileWriter fileWriter = new FileWriter("learnRecord.json");
        fileWriter.write(str);
        fileWriter.close();



    }
}
