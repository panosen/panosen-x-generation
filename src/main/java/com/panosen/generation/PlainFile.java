package com.panosen.generation;

import java.nio.charset.Charset;

public class PlainFile extends FileBase {

    /**
     * 文件内容
     */
    private String content;

    /**
     * 编码
     */
    private Charset charset;

    @Override
    public ContentType getContentType() {
        return ContentType.String;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }
}
