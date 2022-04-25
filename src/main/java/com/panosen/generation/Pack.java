package com.panosen.generation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * 生成结果
 */
public class Pack {

    /**
     * Ban Duplicate
     */
    private Map<String, Integer> fileContentMap = Maps.newHashMap();

    /**
     * 文件
     */
    private List<FileBase> fileBaseList = Lists.newArrayList();

    /**
     * 写入字符串
     *
     * @param path    路径
     * @param content 内容
     */
    public void add(String path, String content) {
        this.add(path, content, null);
    }

    /**
     * 写入字符串
     *
     * @param path     路径
     * @param content  内容
     * @param encoding 编码
     */
    public void add(String path, String content, Charset encoding) {
        PlainFile plainFile = new PlainFile();
        plainFile.setFilePath(path);
        plainFile.setContent(content);
        plainFile.setCharset(encoding);
        this.add(plainFile);
    }

    /**
     * 写入字节
     *
     * @param path  路径
     * @param bytes 字节数组
     */
    public void add(String path, byte[] bytes) {
        BytesFile bytesFile = new BytesFile();
        bytesFile.setFilePath(path);
        bytesFile.setBytes(bytes);
        this.add(bytesFile);
    }

    /**
     * 防止重复写入文件
     *
     * @param file 文件
     */
    private void add(FileBase file) {
        String path = file.getFilePath();

        int fileCount = fileContentMap.getOrDefault(path, 0);
        if (fileCount == 0) {
            this.fileBaseList.add(file);
            this.fileContentMap.put(path, 1);
            return;
        }

        file.setFilePath(path + "." + fileCount);
        this.fileBaseList.add(file);
        this.fileContentMap.put(path, fileCount + 1);
    }

    public Map<String, Integer> getFileContentMap() {
        return fileContentMap;
    }

    public List<FileBase> getFileBaseList() {
        return fileBaseList;
    }
}
