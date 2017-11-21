package org.dominwos.filtering;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.function.Predicate;

import org.apache.commons.io.filefilter.IOFileFilter;

public class FileFilter implements Predicate<File> {
    String predicate;

    public FileFilter(String predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(File file) {
        String name = file.getName();
        if(name.length() == predicate.length()) {
            return name.equals(predicate);
        } else if (predicate.length() > name.length()) {
            return false;
        } else {
            return Arrays.asList(name.split(" ")).containsAll(Arrays.asList(predicate.split(" ")));
        }    }
}
