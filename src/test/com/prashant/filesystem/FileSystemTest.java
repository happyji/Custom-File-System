package com.prashant.filesystem;
import com.prashant.filesystem.entity.Directory;
import com.prashant.filesystem.entity.Drive;
import com.prashant.filesystem.entity.file.File;
import com.prashant.filesystem.exception.InValidEntityNameException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class FileSystemTest 
{

    @Test
    public void createDrive() throws Exception {
        //when
        FileSystem fileSystem = new FileSystem();

        //action
        Drive drive =  (Drive) fileSystem.createDrive("D:");

        //then
        Assert.assertEquals(drive.getClass(),Drive.class);

    }

    @Test
    public void createDirectory() throws Exception {
        //when
        FileSystem fileSystem =new FileSystem();
        Drive drive =  (Drive) fileSystem.createDrive("D:");

        //action
         Directory dir = (Directory) fileSystem.createDirectory("D:/","myfolder");

        //then
        Assert.assertEquals(dir.getName(),"myfolder");
    }

    @Test
    public void createFile() throws Exception {
        //when
        FileSystem fileSystem = new FileSystem();
        Drive drive =  (Drive) fileSystem.createDrive("D:");
        Directory dir = (Directory) fileSystem.createDirectory("D:/","myfolder");

        //action
        File file = (File) fileSystem.createFile("D:/myfolder/","file1");

        //then
        Assert.assertEquals(file.getName(),"file1");
    }

    @Test
    public void getEntitiesByPathname() throws Exception {
        //when
        FileSystem fileSystem = new FileSystem();
        Drive drive =  (Drive) fileSystem.createDrive("D:");
        Directory dir = (Directory) fileSystem.createDirectory("D:/","myfolder");

        //action
        List<EntityReference> refList =fileSystem.getEntitiesByPathName("D:/");

        //test
        Assert.assertEquals(refList.get(0).getName(),"myfolder");

    }

    @Test (expected = InValidEntityNameException.class)
    public void removeEntity() throws Exception {
        //when
        FileSystem fileSystem = new FileSystem();
        Drive drive =  (Drive) fileSystem.createDrive("D:");
        fileSystem.createDirectory("D:/","myfolder1");
        fileSystem.createDirectory("D:/","myfolder2");
        fileSystem.createDirectory("D:/","myfolder3");

        fileSystem.removeEntity("D:/","myfolder1");

        fileSystem.getEntitiesByPathName("D:/myfolder1");


    }
}