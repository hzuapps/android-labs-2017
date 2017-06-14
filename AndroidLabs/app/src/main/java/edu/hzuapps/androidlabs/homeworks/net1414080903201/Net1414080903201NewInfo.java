package edu.hzuapps.androidlabs.homeworks.net1414080903201;

public class Net1414080903201NewsInfo {
    private String iconPath;
    private String title;
    private String description;
    private int type;
    private long comment;

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public long getComment() {
        return comment;
    }
}

