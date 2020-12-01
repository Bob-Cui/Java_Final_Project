package DataManager.Data;

public class SelectProblem extends Problem{
    private String A;
    private String B;
    private String C;
    private String D;

    private char ans;

    public SelectProblem(String a, String b, String c, String d, char ans) {
        super();
        A = a;
        B = b;
        C = c;
        D = d;
        this.ans = ans;
    }
}
