package Test;

import com.google.gson.Gson;

public class Test {


    private static class User {

        private String name;
        private int fuck;
        private boolean flag;

        public User(String name, int fuck, boolean flag) {
            this.name = name;
            this.fuck = fuck;
            this.flag = flag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFuck() {
            return fuck;
        }

        public void setFuck(int fuck) {
            this.fuck = fuck;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}

