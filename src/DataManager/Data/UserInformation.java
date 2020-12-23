package DataManager.Data;

import java.util.Map;

public class UserInformation {

    private String name;
    private String password;



    private BigTitle userBigTitle;
    /**
     * 这个用户学习时间累计
     */

    private LearnRecord dateRecord;
    public int sumAllTime() {
        int sum = 0;
        for (Map.Entry<Integer, LearnRecord.TimeItem> integerTimeItemEntry : dateRecord.getIntegerTimeItemTreeMap().entrySet()) {
            sum += integerTimeItemEntry.getValue().getTimeSpan();
        }
        return sum;
    }


    public UserInformation(String name, String password, BigTitle userData, LearnRecord dateRecord) {
        this.name = name;
        this.password = password;
        this.userBigTitle = userData;
        this.dateRecord = dateRecord;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigTitle getUserBigTitle() {
        return userBigTitle;
    }

    public void setUserBigTitle(BigTitle userBigTitle) {
        this.userBigTitle = userBigTitle;
    }

    public LearnRecord getDateRecord() {
        return dateRecord;
    }
    public void setDateRecord(LearnRecord dateRecord) {
        this.dateRecord = dateRecord;
    }
}
