package com.example.gcu_attendance;

public class Student {
    String std_name,std_roll_number;
    boolean mark;

    public Student(String std_name, String std_roll_number, boolean mark) {
        this.std_name = std_name;
        this.std_roll_number = std_roll_number;
        this.mark = mark;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_roll_number() {
        return std_roll_number;
    }

    public void setStd_roll_number(String std_roll_number) {
        this.std_roll_number = std_roll_number;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
}
