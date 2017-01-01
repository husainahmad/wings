/*
 * BatchServletAutocomplete.java
 *
 * Created on July 10, 2008, 12:02 AM
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
public class BatchServletAutocomplete extends BaseAjaxServlet  {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("noBatch");
        
            List list = com.wings.adapter.StrutsBatchDelegate.findByName(name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "noBatch", "description",true).toString();
        } catch (Exception e) {
            return null;
        }
        
    }        
}
