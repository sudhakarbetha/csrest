package com.opentext.csrest.controllers;

import com.opentext.csrest.models.ContentServer;
import com.opentext.csrest.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentService contentService;

    @RequestMapping("/getservers")
    public List<ContentServer> getServers(){
        return contentService.getContentServers();
    }

    @RequestMapping("/server/{name}")
    public ContentServer getServer(
            @PathVariable(value = "name", required = true) String name){
        return contentService.getContentServer(name);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public ContentServer addServer(
            @RequestBody ContentServer contentServer
    )
    {
        return contentService.addContentServer(contentServer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ContentServer updateServer(
            @RequestBody ContentServer contentServer
    ){
        return contentService.updateContentServer(contentServer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{name}")
    public void deleteServer(
            @PathVariable(value = "name", required = true) String name
    ){
        contentService.deleteContentServer(name);
    }



}
