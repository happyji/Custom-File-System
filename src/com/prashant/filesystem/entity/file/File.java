package com.prashant.filesystem.entity.file;
import com.prashant.filesystem.DataBearable;
import com.prashant.filesystem.EntityReference;
import com.prashant.filesystem.entity.detail.FileEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class File extends FileEntity implements DataBearable {


    public File(String name) {
        super(name);
    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getExtension() {
        return null;
    }
}
