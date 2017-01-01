/*
 * AccountNameServletAutocomplete.java
 *
 * Created on July 10, 2008, 12:20 AM
 */

package com.wings.web.servlets.ajaxtag;

import java.util.List;
import javax.servlet.http.*;
import org.ajaxtags.servlets.BaseAjaxServlet;
import org.ajaxtags.xml.AjaxXmlBuilder;

/**
 *
 * @author Ahmad Husain
 * @version
 */
public class AccountNameServletAutocomplete extends BaseAjaxServlet  {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("accountDesc");
        
            List list = com.wings.adapter.StrutsAccountDelegate.findAccountName("%"+name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "accountName", "idAccount",true).toString();
        } catch (Exception e) {
            return null;
        }
        
    }        
}
