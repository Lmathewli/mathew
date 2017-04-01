package com.mathew.preference.model;

import java.io.File;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("preference")
public class Preference {

    @Id
    private String id;
    private File logo;
    private File backgroundImage;
    private String welcomeMessage;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public File getLogo() {
        return logo;
    }
    public void setLogo(File logo) {
        this.logo = logo;
    }
    public File getBackgroundImage() {
        return backgroundImage;
    }
    public void setBackgroundImage(File backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    public String getWelcomeMessage() {
        return welcomeMessage;
    }
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

}
