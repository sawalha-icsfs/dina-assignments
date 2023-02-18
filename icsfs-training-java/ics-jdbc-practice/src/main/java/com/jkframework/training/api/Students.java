package com.jkframework.training.api;

public class Students {
    private Integer id;
    private String name;
    private Integer average;
    private String email;

    public Students() {
    }

    public Students(int studentID, String studentName, int studentAverage, String studentEmail) {
        super();
        this.id = studentID;
        this.name = studentName;
        this.average = studentAverage;
        this.email = studentEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Students [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", average=");
        builder.append(average);
        builder.append(", email=");
        builder.append(email);
        builder.append("]");
        return builder.toString();
    }

}
