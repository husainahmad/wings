/*
 * TarifWrapper.java
 *
 * Created on March 18, 2007, 9:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.struts.decorators;


import com.wings.persistence.Users;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author Administrator
 */
public class UserWrapper extends TableDecorator {
                        
    public UserWrapper() {        
    }
     
    
    public String getLinkAll()
    {
        Users user = (Users)getCurrentRowObject();
        
        return "<div align=\"center\"><a class=\"link1\" href=\"Javascript:PopUpAddEdit('1','" + user.getUserId() + "');\">Edit</a> | " +
                "<a class=\"link1\" href=\"deleteUser.do?userId=" + user.getUserId() + "\");\">Delete</a> | " +
                "<a class=\"link1\" href=\"Javascript:PopUpAddEdit('3','" + user.getUserId() + "');\">View</a></div> ";
    }

    
}

