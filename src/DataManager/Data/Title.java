package DataManager.Data;

import java.util.Date;
import java.util.HashMap;

public class Title {


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
    private Date date;

    /**
     * 每一个章节对应一个题库
     */
    private HashMap<Integer, SelectProblem> integerSelectProblemHashMap;





    public Title(String name, String resource, boolean learned) {
        this.name = name;
        this.resource = resource;
        this.learned = learned;

        date = new Date();

        integerSelectProblemHashMap = new HashMap<>();



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

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<Integer, SelectProblem> getIntegerSelectProblemHashMap() {
        return integerSelectProblemHashMap;
    }

    public void setIntegerSelectProblemHashMap(HashMap<Integer, SelectProblem> integerSelectProblemHashMap) {
        this.integerSelectProblemHashMap = integerSelectProblemHashMap;
    }
}
