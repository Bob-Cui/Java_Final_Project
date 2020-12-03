package DataManager.PreProcessing;

public class Title {

    private String name;

    /**
     * 每一个标题对应着一个html文件，
     * 这个变量对应着html文件的路径
     */
    private String resource;

    public Title(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
