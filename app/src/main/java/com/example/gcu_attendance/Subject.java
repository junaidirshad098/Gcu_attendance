package com.example.gcu_attendance;

public class Subject {

    String sub_name,section_name,teacher_name,sub_desc;

    public Subject(String sub_name, String section_name, String teacher_name, String sub_desc) {
        this.sub_name = sub_name;
        this.section_name = section_name;
        this.teacher_name = teacher_name;
        this.sub_desc = sub_desc;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getSub_desc() {
        return sub_desc;
    }

    public void setSub_desc(String sub_desc) {
        this.sub_desc = sub_desc;
    }
}
