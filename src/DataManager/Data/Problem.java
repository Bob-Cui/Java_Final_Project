package DataManager.Data;

/**
 * 代表java题库中的一道题
 * 我目前只使用一道选择题
 */
public class Problem {


    private String content;
    public Problem(){}


    public Problem(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
