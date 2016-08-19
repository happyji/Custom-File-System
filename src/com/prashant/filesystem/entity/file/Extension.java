package com.prashant.filesystem.entity.file;

/**
 * Created by PPandey on 8/18/2016.
 */
public enum Extension {

}
/*


public enum Extension {

    TEXT(new String[]{".txt", ".text"}) {
        @Override
        public File getFile(String fileName,String path) throws InvalidFileNameException {
            return new TextFile(fileName, path);
        }
    },
    IMAGE(new String[]{".png",".jpeg",".jpg"}) {
        @Override
        public File getFile(String fileName,String path) throws InvalidFileNameException {
            return new ImageFile(fileName, path);
        }
    },
    DOC(new String[]{".doc",".docx"}) {
        @Override
        public File getFile(String fileName,String path) throws InvalidFileNameException {
            return new DocFile(fileName, path);
        }
    };

    public abstract File getFile(String fileName, String path) throws InvalidFileNameException;

    private String[] extensionList;
    ExtensionType(String[] exntesionList) {
        extensionList = exntesionList;
    }

    public boolean getExtensionType(String fileName){
        for (String s : extensionList) {
            if(fileName.endsWith(s))
                return true;
        }
        return false;
    }

}*/
