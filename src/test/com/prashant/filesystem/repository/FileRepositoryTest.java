package com.prashant.filesystem.repository;
import com.prashant.filesystem.EntityReference;
import com.prashant.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class FileRepositoryTest {

    @Test
    public void accessEntityOfDriveType() throws Exception {
        // when
        FileSystem fileSystem = new FileSystem();
        fileSystem.createDrive("D:");
        fileSystem.createDirectory("D:/","folder1");
        fileSystem.createDirectory("D:/folder1/","src1");
        fileSystem.createDirectory("D:/folder1/","scr2");
        fileSystem.createDirectory("D:/","folder2");

        FileRepository rep = fileSystem.getRepository();
        EntityReference entity = rep.accessEntity("D:");

    }

    @Test
    public void accessEntityOfDirectoryType() throws Exception {
         // when
        FileSystem fileSystem = new FileSystem();
        fileSystem.createDrive("D:");
        fileSystem.createDirectory("D:/","folder1");
        fileSystem.createDirectory("D:/folder1/","src1");
        fileSystem.createDirectory("D:/folder1/","scr2");
        fileSystem.createDirectory("D:/","folder2");

        //action
        FileRepository rep = fileSystem.getRepository();
        EntityReference entity = rep.accessEntity("D:/folder1");

        //then
        Assert.assertEquals("folder1",entity.getName());

    }






}