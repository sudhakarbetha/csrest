package com.opentext.csrest.services;

import com.opentext.csrest.models.ContentServer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    private static List<ContentServer> contentServers = new ArrayList<ContentServer>();


    public List<ContentServer> getContentServers(){
        return contentServers;
    }

    public ContentServer getContentServer(String name){
        for (ContentServer contentServer: contentServers)
            if(contentServer.getName().equals(name)) return contentServer;
        return new ContentServer();
    }


    public ContentServer addContentServer(ContentServer contentServer)
    {
        contentServers.add(contentServer);
        return contentServer;
    }

    public void deleteContentServer(String name)
    {
        contentServers.removeIf(contentServer -> contentServer.getName().equals(name));
    }

    public ContentServer updateContentServer(ContentServer contentServer){
        contentServers = contentServers.stream()
                        .filter(contentServer1 -> !contentServer1.getName().equals(contentServer.getName()))
                        .collect(Collectors.toList());
        contentServers.add(contentServer);
        return contentServer;
    }

}
