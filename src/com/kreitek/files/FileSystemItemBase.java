package com.kreitek.files;

import java.util.List;

public abstract class FileSystemItemBase implements FileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected InterfaceDirectory parent;

    protected FileSystemItemBase(InterfaceDirectory parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
       this.name = name;
    }

    @Override
    public InterfaceDirectory getParent() {
        return parent;
    }

    @Override
    public void setParent(InterfaceDirectory directory) {
        if (directory != null && !(directory instanceof Directory)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        if (this.parent != directory) {
            if (this.parent != null) this.parent.removeFile(this);
            this.parent = directory;
            if (directory != null) directory.addFile(this);
        }
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }

    @Override
    public abstract int getSize();
}
