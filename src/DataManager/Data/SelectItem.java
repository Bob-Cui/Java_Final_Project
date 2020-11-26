package DataManager.Data;


/**
 * 用来描述一个选择题
 */
public class SelectItem {

    private String problem;
    private String A, B, C, D;
    private int answer;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }


    public SelectItem(String problem, String a, String b, String c, String d) {
        this.problem = problem;
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }
}
