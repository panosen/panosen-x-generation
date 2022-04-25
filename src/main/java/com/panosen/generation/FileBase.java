package com.panosen.generation;

/**
 * 生成的文件
 */
public abstract class FileBase {

    private String filePath;

    public abstract ContentType getContentType();

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
