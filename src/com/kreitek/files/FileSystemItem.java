package com.kreitek.files;

import java.util.List;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    InterfaceDirectory getParent();
    void setParent(InterfaceDirectory directory);
    String getFullPath();
    int getSize();
}
