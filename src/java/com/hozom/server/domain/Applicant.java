package com.hozom.server.domain;

import java.util.Date;

/**
 * @author tony
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Applicant {
    private String email;
    private String fullName;
    private String mobilephone;
    private Date updateTime;
    private String ipAddress;

    /**
     * 
     */
    public Applicant() {
    }

    /**
     * @param email
     * @param fullName
     * @param mobilephone
     * @param updateTime
     * @param ipAddress
     */
    public Applicant(String email, String fullName, String mobilephone,
            Date updateTime, String ipAddress) {
        this.email = email;
        this.fullName = fullName;
        this.mobilephone = mobilephone;
        this.updateTime = updateTime;
        this.ipAddress = ipAddress;
    }

    /**
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fullName.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     *            the fullName to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the mobilephone.
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * @param mobilephone
     *            the mobilephone to set.
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * @return the updateTime.
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     *            the updateTime to set.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the ipAddress.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress
     *            the ipAddress to set.
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
