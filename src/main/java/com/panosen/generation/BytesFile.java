package com.panosen.generation;

public class BytesFile extends FileBase {

    /**
     * 字节数组
     */
    private byte[] bytes;

    @Override
    public ContentType getContentType() {
        return ContentType.Bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
