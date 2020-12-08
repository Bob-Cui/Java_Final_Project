package DataManager.Data;

import java.util.HashMap;

/**
 * 用于测试集
 */
public class NewProblems {


    private HashMap<Integer, NewSelectProblem> integerNewSelectProblemHashMap;

    public NewProblems() {
        integerNewSelectProblemHashMap = new HashMap<>();
    }

    public NewProblems(HashMap<Integer, NewSelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }

    public HashMap<Integer, NewSelectProblem> getIntegerNewSelectProblemHashMap() {
        return integerNewSelectProblemHashMap;
    }

    public void setIntegerNewSelectProblemHashMap(HashMap<Integer, NewSelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }
}
