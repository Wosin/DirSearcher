package org.dominwos.searching;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.dominwos.filtering.FileFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileSearcher {
    private String filepath;
    private File directory;

    public FileSearcher(@Value("file.path") String filepath) {
        this.filepath = filepath;
        this.directory = new File(filepath);
    }

    public Collection<String> searchFile(String predicate) {
       Collection<File> files = FileUtils.listFiles(directory, null, true);

       List<String> fileNames = files
               .stream()
               .filter(new FileFilter(predicate))
               .map(file -> file.getPath())
               .collect(Collectors.toList());

       return fileNames;
    }
}
