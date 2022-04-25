package com.panosen.generation;

import com.google.common.base.Charsets;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PackTest {

    @Test
    public void test() {

        Pack pack = new Pack();

        pack.add("a", "a1");
        pack.add("a", "a2", Charsets.UTF_8);
        pack.add("b", new byte[3]);
        pack.add("b", new byte[4]);

        Assert.assertEquals(4, pack.getFileBaseList().size());

        Map<String, Integer> fileContentMap = pack.getFileContentMap();
        Assert.assertEquals(2, fileContentMap.size());
        Assert.assertEquals(2, (int) fileContentMap.get("a"));
        Assert.assertEquals(2, (int) fileContentMap.get("b"));

        List<FileBase> fileBaseList = pack.getFileBaseList();
        Assert.assertEquals(4, fileBaseList.size());

        Assert.assertEquals("a1", ((PlainFile) fileBaseList.get(0)).getContent());
        Assert.assertNull(((PlainFile) fileBaseList.get(0)).getCharset());

        Assert.assertEquals("a2", ((PlainFile) fileBaseList.get(1)).getContent());
        Assert.assertEquals(Charsets.UTF_8, ((PlainFile) fileBaseList.get(1)).getCharset());

        Assert.assertEquals(3, ((BytesFile) fileBaseList.get(2)).getBytes().length);

        Assert.assertEquals(4, ((BytesFile) fileBaseList.get(3)).getBytes().length);
    }
}