package DataManager.Data;

import java.util.LinkedList;

public class TitleData {

    /**
     * 封装内部类
     */
    public static class Subtitle {
        private String title;
        private LinkedList<String> subtitles;

        public Subtitle(String title, LinkedList<String> subtitles) {
            this.title = title;
            this.subtitles = subtitles;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public LinkedList<String> getSubtitles() {
            return subtitles;
        }

        public void setSubtitles(LinkedList<String> subtitles) {
            this.subtitles = subtitles;
        }
    }

    private String title;
    private LinkedList<Subtitle> subtitles;

    public TitleData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(LinkedList<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }
}
