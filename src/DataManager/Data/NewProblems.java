package DataManager.Data;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 用于测试集
 */
public class NewProblems {


    private TreeMap<Integer, NewSelectProblem> integerNewSelectProblemHashMap;

    public NewProblems() {
        integerNewSelectProblemHashMap = new TreeMap<>();
    }

    public TreeMap<Integer, NewSelectProblem> getIntegerNewSelectProblemHashMap() {
        return integerNewSelectProblemHashMap;
    }

    public void setIntegerNewSelectProblemHashMap(TreeMap<Integer, NewSelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }
}
