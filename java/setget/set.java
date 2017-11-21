package com.setget;

/**
 *
 * @author Avleen Singh Khanuja
 */
public class set 
{
    
    private String file_nm;
    private String fileDescription;
    private String fileUploadTime;
    private String first_nm;
    private String last_nm;
    private String updateTime;
  
    public String getFileName() {
        return file_nm;
    }

    public void setFileName(String file_nm) {
        this.file_nm = file_nm;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFileUploadTime() {
        return fileUploadTime;
    }

    public void setFileUploadTime(String fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    public String getFirstName() {
        return first_nm;
    }

    public void setFirstName(String first_nm) {
        this.first_nm = first_nm;
    }

    public String getLastName() {
        return last_nm;
    }

    public void setLastName(String last_nm) {
        this.last_nm = last_nm;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }    
}
