package com.edgedo.sys.entity.article;

import java.util.Date;

public class Video {

    private Integer id;

    private String videoUrl;

    private Date updateTime;

    private Date createTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public Video setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Video setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Video setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Video setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Video setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
