package com.mathew.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

public class MongoClientFactoryBean extends AbstractFactoryBean<Mongo> {

    // 表示服务器列表(主从复制或者分片)的字符串数组
    private String[] serverStrings;
    // mongoDB配置对象 使用默认配置
    private MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder()
            .build();

    @Override
    public Class<?> getObjectType() {
        return Mongo.class;
    }

    public String[] getServerStrings() {
        return serverStrings;
    }

    public void setServerStrings(String[] serverStrings) {
        this.serverStrings = serverStrings;
    }

    @Override
    protected MongoClient createInstance() throws Exception {
        MongoClient mongoClient = null;
        if (null != mongoClientOptions) {
            mongoClient = new MongoClient(getServerList(), mongoClientOptions);
        } else {
            mongoClient = new MongoClient(getServerList());
        }
        return mongoClient;
    }

    /**
     * 根据服务器字符串列表，解析出服务器对象列表
     * 
     * @Title: getServerList
     * 
     * @return
     * @throws Exception
     */
    private List<ServerAddress> getServerList() throws Exception {
        List<ServerAddress> serverList = new ArrayList<ServerAddress>();
        try {
            for (String serverString : serverStrings) {
                String[] temp = serverString.split(":");
                String host = temp[0];
                if (temp.length > 2) {
                    throw new IllegalArgumentException(
                            "Invalid server address string: " + serverString);
                }
                if (temp.length == 2) {
                    serverList.add(new ServerAddress(host, Integer
                            .parseInt(temp[1])));
                } else {
                    serverList.add(new ServerAddress(host));
                }
            }
            return serverList;
        } catch (Exception e) {
            throw new Exception(
                    "Error while converting serverString to ServerAddressList",
                    e);
        }
    }

}