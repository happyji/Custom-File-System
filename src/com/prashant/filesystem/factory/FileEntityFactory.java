package com.prashant.filesystem.factory;
import com.prashant.filesystem.EntityReference;

public class FileEntityFactory {

    public EntityReference createEntity(EntityType entityType, String name)
    {
         for (EntityType type : EntityType.values()) {
              if (type.equals(entityType))
                  return type.getFileEntity(name);
         }
         return null;
    }

}
