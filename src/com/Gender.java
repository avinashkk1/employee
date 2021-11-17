package com;

public class Gender {
    private int genderID;
    private String gender;

    public Gender(int genderID, String gender) {
        this.genderID = genderID;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderID=" + genderID +
                ", gender='" + gender + '\'' +
                '}';
    }
}
