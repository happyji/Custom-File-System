package com.prashant.filesystem.util;
import com.prashant.filesystem.exception.InValidFilePathException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePathTokenizer extends StringTokenizer {
    static String delimit = "/";

    private FilePathTokenizer(String str, String delim) {
        super(str,delim);
    }

    public static FilePathTokenizer getInstance(String path) throws InValidFilePathException {
        if(isUnValidPath(path))
            throw new InValidFilePathException();

        return new FilePathTokenizer(path,delimit);
    }

    private static boolean isUnValidPath(String path) {
        return false;
    }


}
