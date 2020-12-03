package DataManager.Data;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * 每一个章节对应的资源
 */
public class TitleManager {


    private String name;

    /**
     * 每一个标题对应着一个html文件，
     * 这个变量对应着html文件的路径
     */
    private String resource;

    /**
     * 这个人是否学习过这一个章节
     */
    private boolean learned;

//    @Expose(serialize = false, deserialize = false)

    /**
     * 是否还需要提醒这个人学习这一章节
     */
    private boolean remindUser;

    private Date lastRead;

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public boolean isRemindUser() {
        return remindUser;
    }

    public void setRemindUser(boolean remindUser) {
        this.remindUser = remindUser;
    }

    public Date getLastRead() {
        return lastRead;
    }

    public void setLastRead(Date lastRead) {
        this.lastRead = lastRead;
    }

    /**
     * @param name 构造时输入这个章节的名字
     */
    public TitleManager(String name) {
        this.name = name;
        this.resource = "";
        this.learned = false;
        this.remindUser = false;
        lastRead = new Date();
    }


    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public TitleManager(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
