package com.example.eproject_1;

public class Employee_users {
    private int emp_id;
    private String emp_name,emp_email,emp_contactno,emp_joining_date,emp_manager_name;

    public Employee_users() {
    }

    public Employee_users(int emp_id, String emp_name, String emp_email, String emp_contactno, String emp_joining_date, String emp_manager_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_email = emp_email;
        this.emp_contactno = emp_contactno;
        this.emp_joining_date = emp_joining_date;
        this.emp_manager_name = emp_manager_name;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_contactno() {
        return emp_contactno;
    }

    public void setEmp_contactno(String emp_contactno) {
        this.emp_contactno = emp_contactno;
    }

    public String getEmp_joining_date() {
        return emp_joining_date;
    }

    public void setEmp_joining_date(String emp_joining_date) {
        this.emp_joining_date = emp_joining_date;
    }

    public String getEmp_manager_name() {
        return emp_manager_name;
    }

    public void setEmp_manager_name(String emp_manager_name) {
        this.emp_manager_name = emp_manager_name;
    }
}






