package org.dominwos.rest;

import org.dominwos.searching.FileSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class Rest {
    @Autowired
    private FileSearcher fileSearcher;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Collection<String> search(@RequestBody String searchPhrase) {
        return fileSearcher.searchFile(searchPhrase);
    }
}
