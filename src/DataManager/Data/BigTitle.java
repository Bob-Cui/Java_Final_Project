package DataManager.Data;

import java.util.HashMap;

public class BigTitle {
    /**
     * 无参构造函数
     */
    public BigTitle() {
        stringNewSubTitleManagerHashMap = new HashMap<>();
    }

    private HashMap<String, SubTitle> stringNewSubTitleManagerHashMap;

    public BigTitle(HashMap<String, SubTitle> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }

    public HashMap<String, SubTitle> getStringNewSubTitleManagerHashMap() {
        return stringNewSubTitleManagerHashMap;
    }

    public void setStringNewSubTitleManagerHashMap(HashMap<String, SubTitle> stringNewSubTitleManagerHashMap) {
        this.stringNewSubTitleManagerHashMap = stringNewSubTitleManagerHashMap;
    }
}
