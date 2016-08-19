package com.prashant.filesystem;

import com.prashant.filesystem.exception.InValidEntityNameException;
import com.prashant.filesystem.exception.InValidFilePathException;
import com.prashant.filesystem.factory.EntityType;
import com.prashant.filesystem.factory.FileEntityFactory;
import com.prashant.filesystem.repository.FileRepository;

import java.util.List;

public class FileSystem
{
    FileRepository repository;
    FileEntityFactory factory;

    public FileSystem() {
        factory = new FileEntityFactory();
        repository = new FileRepository();
    }

    public FileRepository getRepository() {
        return repository;
    }

    public EntityReference createDrive(String name)throws InValidFilePathException,InValidEntityNameException {
        EntityReference parent = repository.getRoot();
        return createEntity(parent, name,EntityType.DRIVE);
    }

    public EntityReference createDirectory(String path, String name)throws InValidFilePathException,InValidEntityNameException {
        EntityReference parent = getEntityByPath(path);
        EntityReference reference = createEntity(parent, name,EntityType.DIRECTORY);
        return reference;
    }

    public EntityReference createFile(String path, String name)throws InValidFilePathException,InValidEntityNameException {
        EntityReference parent = getEntityByPath(path);
        EntityReference reference = createEntity(parent,name,EntityType.FILE);
        return reference;
    }

    public List<EntityReference> getEntitiesByPathName(String path) throws InValidFilePathException,InValidEntityNameException
    {
        return  getEntityByPath(path).getChildEntities();
    }

    public void removeEntity(String path,String entityName) throws InValidFilePathException,InValidEntityNameException
    {
        EntityReference reference =  getEntityByPath(path);
        reference.remove(entityName);
    }


    private EntityReference createEntity(EntityReference parent,String name,EntityType type) throws InValidEntityNameException, InValidFilePathException {
       EntityReference reference= factory.createEntity(type,name);
        parent.addEntity(reference);
        return reference;
    }


    private EntityReference getEntityByPath(String path) throws InValidEntityNameException, InValidFilePathException {
        return FileRepository.accessEntity(path);
    }




}
