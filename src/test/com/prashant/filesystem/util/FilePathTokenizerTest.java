package com.prashant.filesystem.util;
import com.prashant.filesystem.exception.InValidFilePathException;
import org.junit.Assert;
import org.junit.Test;

public class FilePathTokenizerTest {

    @Test
    public void pathWherePathSeparatorIsPresent() throws Exception {
        //when
        String path = "D:/myfolder/file1.txt";
        FilePathTokenizer pathTokenizer = FilePathTokenizer.getInstance(path);

        //action
        StringBuilder stringBuilder = new StringBuilder();
        while (pathTokenizer.hasMoreTokens())
        {
            stringBuilder.append(pathTokenizer.nextToken());
        }

        //then
        Assert.assertEquals("D:myfolderfile1.txt",stringBuilder.toString());


    }

    @Test
    public void pathWhereOnlyDirectoryNameProvided() throws Exception {
        //when
        String path = "D:/";
        FilePathTokenizer pathTokenizer = FilePathTokenizer.getInstance(path);

        //action
        StringBuilder stringBuilder = new StringBuilder();
        while (pathTokenizer.hasMoreTokens())
        {
            String token = pathTokenizer.nextToken();
            System.out.println(token);
            stringBuilder.append(token);
        }

        //then
        Assert.assertEquals("D:",stringBuilder.toString());
    }

    @Test (expected = InValidFilePathException.class)
    public void pathWhereGarbageFilePathIsPresent() throws InValidFilePathException {
        String path = "D://%&/@/myfolder//file1.txt";
        FilePathTokenizer pathTokenizer = FilePathTokenizer.getInstance(path);
    }
}