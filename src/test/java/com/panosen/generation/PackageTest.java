package com.panosen.generation;

import com.google.common.base.Charsets;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PackageTest {

    @Test
    public void test() {

        Package p = new Package();

        p.add("a", "a1");
        p.add("a", "a2", Charsets.UTF_8);
        p.add("b", new byte[3]);
        p.add("b", new byte[4]);

        Assert.assertEquals(4, p.getFileBaseList().size());

        Map<String, Integer> fileContentMap = p.getFileContentMap();
        Assert.assertEquals(2, fileContentMap.size());
        Assert.assertEquals(2, (int) fileContentMap.get("a"));
        Assert.assertEquals(2, (int) fileContentMap.get("b"));

        List<FileBase> fileBaseList = p.getFileBaseList();
        Assert.assertEquals(4, fileBaseList.size());

        Assert.assertEquals("a1", ((PlainFile) fileBaseList.get(0)).getContent());
        Assert.assertNull(((PlainFile) fileBaseList.get(0)).getCharset());

        Assert.assertEquals("a2", ((PlainFile) fileBaseList.get(1)).getContent());
        Assert.assertEquals(Charsets.UTF_8, ((PlainFile) fileBaseList.get(1)).getCharset());

        Assert.assertEquals(3, ((BytesFile) fileBaseList.get(2)).getBytes().length);

        Assert.assertEquals(4, ((BytesFile) fileBaseList.get(3)).getBytes().length);
    }
}