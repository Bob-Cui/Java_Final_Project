package DataManager.Data;

import java.util.HashMap;

/**
 * 用于测试集
 */
public class NewProblems {


    private HashMap<Integer, SelectProblem> integerNewSelectProblemHashMap;

    public NewProblems() {
        integerNewSelectProblemHashMap = new HashMap<>();
    }






    public NewProblems(HashMap<Integer, SelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }

    public HashMap<Integer, SelectProblem> getIntegerNewSelectProblemHashMap() {
        return integerNewSelectProblemHashMap;
    }

    public void setIntegerNewSelectProblemHashMap(HashMap<Integer, SelectProblem> integerNewSelectProblemHashMap) {
        this.integerNewSelectProblemHashMap = integerNewSelectProblemHashMap;
    }
}
