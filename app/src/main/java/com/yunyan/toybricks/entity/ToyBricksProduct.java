package com.yunyan.toybricks.entity;

import java.io.Serializable;

/**
 * Created by George on 2015/9/6.
 */
public class ToyBricksProduct implements Serializable{

    private int id;//唯一标识
    private String qr_name;//二维码验证
    private String version_model;//模型版本
    private String url_zip;//资源下载路径
    private String url_icon;//icon图标
    private String content;//描述

    @Override
    public String toString() {
        return "ToyBricksProduct{" +
                "id=" + id +
                ", qr_name='" + qr_name + '\'' +
                ", version_model='" + version_model + '\'' +
                ", url_zip='" + url_zip + '\'' +
                ", url_icon='" + url_icon + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQr_name() {
        return qr_name;
    }

    public void setQr_name(String qr_name) {
        this.qr_name = qr_name;
    }

    public String getVersion_model() {
        return version_model;
    }

    public void setVersion_model(String version_model) {
        this.version_model = version_model;
    }

    public String getUrl_zip() {
        return url_zip;
    }

    public void setUrl_zip(String url_zip) {
        this.url_zip = url_zip;
    }

    public String getUrl_icon() {
        return url_icon;
    }

    public void setUrl_icon(String url_icon) {
        this.url_icon = url_icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
