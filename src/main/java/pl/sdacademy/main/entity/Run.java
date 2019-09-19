package pl.sdacademy.main.entity;

import java.util.Date;

public class Run {
    private Integer id;
    private String name;
    private Date startDate; // zawsze wybieramy w encjach date(java.util) a nie date(java.sql)

    public Run(Integer id, String name, Date startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Run() {
    }

    @Override
    public String toString(){
        return "Obiekt: id = "+getId()+" name: "+name+" startDate: "+getStartDate();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
