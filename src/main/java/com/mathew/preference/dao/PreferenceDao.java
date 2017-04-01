package com.mathew.preference.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.mathew.preference.model.Preference;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class PreferenceDao extends BasicDAO<Preference, Serializable> {

    protected GridFS gridStore;

    protected PreferenceDao(Datastore ds) {
        super(ds);
        gridStore = new GridFS(ds.getDB());
    }

     public Object saveFile(String fileName, String mimeType, InputStream fileStream) {
         GridFSInputFile localFile = gridStore.createFile(fileStream,   
                 fileName);   
         localFile.setContentType(mimeType);   
         localFile.save();

         return localFile.getId();   
     }

     public void getFile(String fileName) {
         GridFSDBFile file = gridStore.findOne(fileName);

         try {
            file.writeTo(new File("D:/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
