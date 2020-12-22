package DataManager.Data;

public class SelectProblem {
    private int id;
    private String problem;
    private String A, B, C, D;
    private char answer;
    private char yourAnswer;




    public SelectProblem(int id, String problem, String a, String b, String c, String d, char answer) {
        this.id = id;
        this.problem = problem;
        A = a;
        B = b;
        C = c;
        D = d;
        this.answer = answer;
        yourAnswer = 'A';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public char getYourAnswer() {
        return yourAnswer;
    }

    public void setYourAnswer(char yourAnswer) {
        this.yourAnswer = yourAnswer;
    }
}
