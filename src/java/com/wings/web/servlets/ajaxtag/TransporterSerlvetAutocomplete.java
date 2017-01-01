/*
 * TransporterSerlvetAutocomplete.java
 *
 * Created on July 6, 2008, 3:08 PM
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
public class TransporterSerlvetAutocomplete extends BaseAjaxServlet  {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("transportName");
        
            List list = com.wings.adapter.StrutsTransporterDelegate.findByName(name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "idTransporter",true).toString();
        } catch (Exception e) {
            return null;
        }
        
    }        
}
