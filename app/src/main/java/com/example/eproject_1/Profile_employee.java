package com.example.eproject_1;

public class Profile_employee {
    private int id;
    private String number_of_days,leave_type,leave_status;

    public Profile_employee() {

    }

    public Profile_employee(int id, String number_of_days,String leave_type, String leave_status) {
        this.id = id;
        this.number_of_days = number_of_days;
        this.leave_type = leave_type;
        this.leave_status = leave_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber_of_days() {
        return number_of_days;
    }

    public void setNumber_of_days(String number_of_days) {
        this.number_of_days = number_of_days;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getLeave_status() {
        return leave_status;
    }

    public void setLeave_status(String leave_status) {
        this.leave_status = leave_status;
    }
}
