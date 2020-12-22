package DataManager.Data;

import java.util.TreeMap;

/**
 * 用于测试题
 */
public class Problems {


    private TreeMap<Integer, SelectProblem> integerNewSelectProblemHashMap;

    public Problems() {
        integerNewSelectProblemHashMap = new TreeMap<>();
    }

    public TreeMap<Integer, SelectProblem> getIntegerNewSelectProblemHashMap() {
        return integerNewSelectProblemHashMap;
    }

    public void setIntegerNewSelectProblemHashMap(TreeMap<Integer, SelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }
}
