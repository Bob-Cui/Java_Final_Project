package DataManager.Data;

import java.util.Date;

/**
 * listView中title专用的数据类
 */
public class Title {


    private String name;


    private String resource;

    //这一章的内容是否可以看






    //代表展示这个东西的网页

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

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
}
