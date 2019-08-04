package com.yuan.mvvmdemo.model.imagemodel;

import java.util.List;

public class ImageBean {
    public static final String BASE_URL = "https://www.bing.com/";
    private String startdate;

    private String fullstartdate;

    private String enddate;

    private String url;

    private String urlbase;

    private String copyright;

    private String copyrightlink;

    private String title;

    private String quiz;

    private boolean wp;

    private String hsh;

    private int drk;

    private int top;

    private int bot;

    private List<String> hs;

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setFullstartdate(String fullstartdate) {
        this.fullstartdate = fullstartdate;
    }

    public String getFullstartdate() {
        return this.fullstartdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getEnddate() {
        return this.enddate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlbase(String urlbase) {
        this.urlbase = urlbase;
    }

    public String getUrlbase() {
        return this.urlbase;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyrightlink(String copyrightlink) {
        this.copyrightlink = copyrightlink;
    }

    public String getCopyrightlink() {
        return this.copyrightlink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getQuiz() {
        return this.quiz;
    }

    public void setWp(boolean wp) {
        this.wp = wp;
    }

    public boolean getWp() {
        return this.wp;
    }

    public void setHsh(String hsh) {
        this.hsh = hsh;
    }

    public String getHsh() {
        return this.hsh;
    }

    public void setDrk(int drk) {
        this.drk = drk;
    }

    public int getDrk() {
        return this.drk;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getTop() {
        return this.top;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    public int getBot() {
        return this.bot;
    }

    public void setHs(List<String> hs) {
        this.hs = hs;
    }

    public List<String> getHs() {
        return this.hs;
    }
}
