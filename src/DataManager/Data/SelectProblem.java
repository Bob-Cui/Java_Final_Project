package DataManager.Data;

public class SelectProblem extends Problem{
    private String A;
    private String B;
    private String C;
    private String D;

    //正确答案
    private char ans;


    //你的选择
    private char youChoice;
    public SelectProblem(String a, String b, String c, String d, char ans) {
        super();
        A = a;
        B = b;
        C = c;
        D = d;
        this.ans = ans;
        this.youChoice = ' ';
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

    public char getAns() {
        return ans;
    }

    public void setAns(char ans) {
        this.ans = ans;
    }

    public char getYouChoice() {
        return youChoice;
    }

    public void setYouChoice(char youChoice) {
        this.youChoice = youChoice;
    }
}
