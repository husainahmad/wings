/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Agents;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class AgentsWrapper extends TableDecorator {
                        
    public AgentsWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Agents agents = (Agents)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + agents.getIdAgent() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('2','" + agents.getIdAgent() + "');\">Delete</a></div> ";
    }

    
}

