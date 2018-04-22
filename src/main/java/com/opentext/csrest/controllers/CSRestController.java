package com.opentext.csrest.controllers;

import com.opentext.csrest.models.ContentServer;
import com.opentext.csrest.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/csrest")
public class CSRestController {


    @Autowired
    ContentService contentService;

    @RequestMapping(method = RequestMethod.POST, value = "/dfc/{name}")
    public void queryContentServer(
            @PathVariable(value = "name", required = true) String name,
            @RequestHeader(value = "query", required = true) String query
    )
    {
        ContentServer contentServer = contentService.getContentServer(name);

    }

}
