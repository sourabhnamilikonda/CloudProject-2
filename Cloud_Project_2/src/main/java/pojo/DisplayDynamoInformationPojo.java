/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;


public class DisplayDynamoInformationPojo 
{
    private String email;
    private String date;
    private String time;
    public int count=0;

    /**
     * @return the email
     */
    public String getEmail() {
        
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        count++;
        this.email = email;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        count++;
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        count++;
        this.time = time;
    }
}
