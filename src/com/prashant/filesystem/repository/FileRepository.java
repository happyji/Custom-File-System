package com.prashant.filesystem.repository;

import com.prashant.filesystem.EntityReference;
import com.prashant.filesystem.entity.BaseFileEntity;
import com.prashant.filesystem.exception.InValidFilePathException;
import com.prashant.filesystem.exception.InValidEntityNameException;
import com.prashant.filesystem.util.FilePathTokenizer;


public class FileRepository {
    static EntityReference root;


    public FileRepository() {
        root = new BaseFileEntity();
    }

    public static EntityReference getRoot() {
        return root;
    }

    public static EntityReference accessEntity(String path)throws InValidEntityNameException,InValidFilePathException
    {
        EntityReference reference = root;
        FilePathTokenizer filePathTokenizer = FilePathTokenizer.getInstance(path);
        while (filePathTokenizer.hasMoreTokens())
        {
            String token = filePathTokenizer.nextToken();
            reference = reference.getEntityByName(token);
            if(reference== null)
                throw new InValidEntityNameException();
        }
        return reference;
    }
}
