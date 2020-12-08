package DataManager.Data.OldData;

import java.util.Date;
import java.util.LinkedList;

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

    /**
     * 每一个章节对应一个题库
     */
    //@Expose(serialize = false, deserialize = false)
    private LinkedList<SelectProblem> selectProblemList;


    /**
     * 是否还需要提醒这个人学习这一章节
     */
    private boolean remindUser;

    private Date lastRead;

    public boolean isLearned() {
        return learned;
    }

    public TitleManager(String name, String resource, boolean learned, LinkedList<SelectProblem> selectProblemList, boolean remindUser, Date lastRead) {
        this.name = name;
        this.resource = resource;
        this.learned = learned;
        this.selectProblemList = selectProblemList;
        this.remindUser = remindUser;
        this.lastRead = lastRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public LinkedList<SelectProblem> getSelectProblemList() {
        return selectProblemList;
    }

    public void setSelectProblemList(LinkedList<SelectProblem> selectProblemList) {
        this.selectProblemList = selectProblemList;
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
}
