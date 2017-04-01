package com.mathew.model;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

import com.mathew.utils.Annotation.Password;

@Entity("user")
@Indexes(
    @Index("emailAddress")
)
public class User {

    @Id
    private String id;
    private Integer age;
    private String phone;
    private String emailAddress;
    private String password;
    private String reminderQueryQuestion;
    private String reminderQueryAnswer;
    private String screenName;
    private String qqId;
    private String weChatId;
    private String preferenceId;
    private Short language;
    private Date loginDate;
    private Date lastLoginDate;
    private String lastLoginIP;
    private Integer failedLoginAttempts;
    private String lockout;
    private Date lockoutDate;
    private Short agreedToTermsOfUse;
    private Short emailAddressVerified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@Password String password) {
        this.password = password;
    }

    public String getReminderQueryQuestion() {
        return reminderQueryQuestion;
    }

    public void setReminderQueryQuestion(String reminderQueryQuestion) {
        this.reminderQueryQuestion = reminderQueryQuestion;
    }

    public String getReminderQueryAnswer() {
        return reminderQueryAnswer;
    }

    public void setReminderQueryAnswer(String reminderQueryAnswer) {
        this.reminderQueryAnswer = reminderQueryAnswer;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    public Short getLanguage() {
        return language;
    }

    public void setLanguage(Short language) {
        this.language = language;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getLockout() {
        return lockout;
    }

    public void setLockout(String lockout) {
        this.lockout = lockout;
    }

    public Date getLockoutDate() {
        return lockoutDate;
    }

    public void setLockoutDate(Date lockoutDate) {
        this.lockoutDate = lockoutDate;
    }

    public Short getAgreedToTermsOfUse() {
        return agreedToTermsOfUse;
    }

    public void setAgreedToTermsOfUse(Short agreedToTermsOfUse) {
        this.agreedToTermsOfUse = agreedToTermsOfUse;
    }

    public Short getEmailAddressVerified() {
        return emailAddressVerified;
    }

    public void setEmailAddressVerified(Short emailAddressVerified) {
        this.emailAddressVerified = emailAddressVerified;
    }
}
