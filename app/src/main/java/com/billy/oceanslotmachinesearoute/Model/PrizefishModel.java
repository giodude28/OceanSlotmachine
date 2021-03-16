package com.billy.oceanslotmachinesearoute.Model;

public class PrizefishModel {

    String pfname;
    Integer pfimage;
    String pfprize;

    public PrizefishModel(String pfname, Integer pfimage, String pfprize) {
        this.pfname = pfname;
        this.pfimage = pfimage;
        this.pfprize = pfprize;
    }

    public String getPfname() {
        return pfname;
    }

    public Integer getPfimage() {
        return pfimage;
    }

    public String getPfprize() {
        return pfprize;
    }
}
