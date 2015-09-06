package com.yunyan.toybricks.entity;


import java.io.Serializable;

/**
 * Created by George on 2015/8/31.
 */
public class ToyBricksZipFile implements Serializable{
    private int id;
    private String extractPath;//解压路径
    private String filePath;//zip文件路径
    private Boolean delete;//解压完成删除标志
	private String password;//压缩密码
    private String fileName;//文件名   
    private int finished;//已经解压了多少字节
    private int length;//文件的大小


    public ToyBricksZipFile(int id, String extractPath, String filePath, Boolean delete, String fileName, int finished, int length, String password) {
        this.id = id;
        this.extractPath = extractPath;
        this.filePath = filePath;
        this.delete = delete;
        this.fileName = fileName;
        this.finished = finished;
        this.length = length;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ToyBricksZipFile{" +
                "id=" + id +
                ", extractPath='" + extractPath + '\'' +
                ", filePath='" + filePath + '\'' +
                ", delete=" + delete +
                ", fileName='" + fileName + '\'' +
                ", finished=" + finished +
                ", length=" + length +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtractPath() {
        return extractPath;
    }

    public void setExtractPath(String extractPath) {
        this.extractPath = extractPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
