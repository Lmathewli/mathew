package com.mathew.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@CompoundIndexes({
        @CompoundIndex(name = "emailAddress", def = "{'name': 1, 'birthday': -1}")
})
public class User {

    @Id
    @Indexed(unique = true)
    private String _id;

    private Integer age;
    private String phone;
    @Indexed
    private String emailAddress;
    @Indexed
    private String password;
    private String reminderQueryQuestion;
    private String reminderQueryAnswer;
    private String screenName;
    private String qqId;
    private String weChatId;
    private Short language;
    private Date loginDate;
    private Date lastLoginDate;
    private String lastLoginIP;
    private Integer failedLoginAttempts;
    private String lockout;
    private Date lockoutDate;
    private Short agreedToTermsOfUse;
    private Short emailAddressVerified;

    public String getUserId() {
        return _id;
    }

    public void setUserId(String userId) {
        this._id = userId;
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

    public void setPassword(String password) {
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

    @Override
    public String toString() {
        return "{User {userId:" + _id + ", phone:" + phone
                + ", emailAddress:" + emailAddress + ", password:" + password
                + ", reminderQueryQuestion:" + reminderQueryQuestion
                + ", reminderQueryAnswer:" + reminderQueryAnswer
                + ", screenName:" + screenName + ", qqId:" + qqId
                + ", weChatId:" + weChatId + ", language:" + language
                + ", loginDate:" + loginDate + ", lastLoginDate:"
                + lastLoginDate + ", lastLoginIP:" + lastLoginIP
                + ", failedLoginAttempts:" + failedLoginAttempts + ", lockout:"
                + lockout + ", lockoutDate:" + lockoutDate
                + ", agreedToTermsOfUse:" + agreedToTermsOfUse
                + ", emailAddressVerified:" + emailAddressVerified + "}}";
    }
}
