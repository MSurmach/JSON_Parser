package org.example.model;

public class AppModel {

    private int id;
    private String dateAndTime;
    private String formattedJSONString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getFormattedJSONString() {
        return formattedJSONString;
    }

    public void setFormattedJSONString(String formattedJSONString) {
        this.formattedJSONString = formattedJSONString;
    }
}
