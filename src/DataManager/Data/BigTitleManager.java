package DataManager.Data;

import java.util.LinkedList;

/**
 * 用于存储所有关于题目的数据
 */
public class BigTitleManager {


    private SubTitleManager priSubTitleManager;
    private SubTitleManager midSubTitleManager;
    private SubTitleManager senSubTitleManager;

    /**
     * 无参数构造函数
     */
    public BigTitleManager() {
        priSubTitleManager = new SubTitleManager();
        midSubTitleManager = new SubTitleManager();
        senSubTitleManager = new SubTitleManager();
    }

    public BigTitleManager(SubTitleManager priSubTitleManager, SubTitleManager midSubTitleManager, SubTitleManager senSubTitleManager) {
        this.priSubTitleManager = priSubTitleManager;
        this.midSubTitleManager = midSubTitleManager;
        this.senSubTitleManager = senSubTitleManager;
    }

    public SubTitleManager getPriSubTitleManager() {
        return priSubTitleManager;
    }

    public void setPriSubTitleManager(SubTitleManager priSubTitleManager) {
        this.priSubTitleManager = priSubTitleManager;
    }

    public SubTitleManager getMidSubTitleManager() {
        return midSubTitleManager;
    }

    public void setMidSubTitleManager(SubTitleManager midSubTitleManager) {
        this.midSubTitleManager = midSubTitleManager;
    }

    public SubTitleManager getSenSubTitleManager() {
        return senSubTitleManager;
    }

    public void setSenSubTitleManager(SubTitleManager senSubTitleManager) {
        this.senSubTitleManager = senSubTitleManager;
    }
}


