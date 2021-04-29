package com.example.appproject;

public class Service {

    private int id;
    private String person;
    private String burrialDate;
    private String burrialTime;
    private String relation;
    private String cotton;
    private String shroud;
    private String religionist;
    private String flower;
    private String labour;

    public Service() {

    }

    public Service(String person, String burrialDate, String burrialTime, String relation, String cotton, String shroud, String religionist, String flower, String labour) {
        this.person = person;
        this.burrialDate = burrialDate;
        this.burrialTime = burrialTime;
        this.relation = relation;
        this.cotton = cotton;
        this.shroud = shroud;
        this.religionist = religionist;
        this.flower = flower;
        this.labour = labour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getBurrialDate() {
        return burrialDate;
    }

    public void setBurrialDate(String burrialDate) {
        this.burrialDate = burrialDate;
    }

    public String getBurrialTime() {
        return burrialTime;
    }

    public void setBurrialTime(String burrialTime) {
        this.burrialTime = burrialTime;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCotton() {
        return cotton;
    }

    public void setCotton(String cotton) {
        this.cotton = cotton;
    }

    public String getShroud() {
        return shroud;
    }

    public void setShroud(String shroud) {
        this.shroud = shroud;
    }

    public String getReligionist() {
        return religionist;
    }

    public void setReligionist(String religionist) {
        this.religionist = religionist;
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public String getLabour() {
        return labour;
    }

    public void setLabour(String labour) {
        this.labour = labour;
    }
}

