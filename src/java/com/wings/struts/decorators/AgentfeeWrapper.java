/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Agentfee;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class AgentfeeWrapper extends TableDecorator {
                        
    public AgentfeeWrapper() {        
    }
    
    public String getPajak() {
        Agentfee agentfee = (Agentfee)getCurrentRowObject();
        if (agentfee.getIsTax().equalsIgnoreCase("1")) {
            return "Tax";
        } else {
            return "Non Tax";
        }
    }
    
    public String getLinkAll()
    {
        Agentfee agentfee = (Agentfee)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + agentfee.getIdAgentFee() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + agentfee.getIdAgentFee() + "');\">Delete</a></div>";
    }

    
}

