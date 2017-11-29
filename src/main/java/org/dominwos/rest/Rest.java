package org.dominwos.rest;

import org.dominwos.searching.FileSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import javax.websocket.server.PathParam;

@RestController
public class Rest {
    @Autowired
    private FileSearcher fileSearcher;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Collection<String> search(@PathParam("searchPhrase") String searchPhrase) {
        return fileSearcher.searchFile(searchPhrase);
    }
}
