package com.yuan.mvvmdemo.model.imagemodel;

import java.util.List;

public class Root {
    private List<ImageBean> images;

    private Tooltips tooltips;

    public void setImages(List<ImageBean> images) {
        this.images = images;
    }

    public List<ImageBean> getImages() {
        return this.images;
    }

    public void setTooltips(Tooltips tooltips) {
        this.tooltips = tooltips;
    }

    public Tooltips getTooltips() {
        return this.tooltips;
    }
}
