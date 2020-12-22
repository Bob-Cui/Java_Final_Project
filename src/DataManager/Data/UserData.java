package DataManager.Data;

public class UserData {
    private String name;
    private String password;


    private AllData userData;
    /**
     * 这个用户学习时间累计
     */
    private long timeSpan;

    public UserData(String name, String password, long timeSpan) {
        this.name = name;
        this.password = password;
        this.timeSpan = timeSpan;
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

    public AllData getUserData() {
        return userData;
    }

    public void setUserData(AllData userData) {
        this.userData = userData;
    }

    public long getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(long timeSpan) {
        this.timeSpan = timeSpan;
    }
}
