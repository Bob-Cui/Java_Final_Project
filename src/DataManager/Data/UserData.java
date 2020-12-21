package DataManager.Data;

public class UserData {
    private String name;
    private String password;
    private String config;


    private AllData userData;
    /**
     * 这个用户学习时间累计
     */
    private long timeSpan;


    public UserData(String name, String password, String config, long timeSpan) {
        this.name = name;
        this.password = password;
        this.config = config;
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

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public long getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(long timeSpan) {
        this.timeSpan = timeSpan;
    }

    public AllData getUserData() {
        return userData;
    }

    public void setUserData(AllData userData) {
        this.userData = userData;
    }
}
