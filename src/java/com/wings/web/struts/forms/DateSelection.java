/*
 * DateSelection.java
 *
 * Created on 13 Juni 2007, 0:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.web.struts.forms;

import java.util.Date;

/**
 *
 * @author Administrator
 */

public class DateSelection {
    private Date from;
    private Date to;    
    private String jobType;    
    private String idConsignee;
    private String idShipper;
    private String idAgent;
    public DateSelection() {
    }    

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getIdConsignee() {
        return idConsignee;
    }

    public void setIdConsignee(String idConsignee) {
        this.idConsignee = idConsignee;
    }

    public String getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(String idShipper) {
        this.idShipper = idShipper;
    }

    public String getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(String idAgent) {
        this.idAgent = idAgent;
    }
    
}
