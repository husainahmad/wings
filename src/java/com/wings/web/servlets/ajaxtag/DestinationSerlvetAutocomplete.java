/*
 * DestinationSerlvetAutocomplete.java
 *
 * Created on July 6, 2008, 3:11 PM
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
public class DestinationSerlvetAutocomplete extends BaseAjaxServlet  {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("destinationName");
        
            List list = com.wings.adapter.StrutsDestinationDelegate.findByName(name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "idDestination",true).toString();
        } catch (Exception e) {
            return null;
        }
        
    }        
}
