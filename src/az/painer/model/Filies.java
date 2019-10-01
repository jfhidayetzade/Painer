package az.painer.model;

public class Filies {
    private int id;
    private String key;
    private String filePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFilePath() {
        return filePath;
    }

    public String setFilePath(String filePath) {
        this.filePath = filePath;
        return filePath;
    }

    @Override
    public String toString() {
        return "Filies{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
