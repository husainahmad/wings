/*
 * AgentfeeServletAutocomplete.java
 *
 * Created on July 6, 2008, 7:16 PM
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
public class AgentfeeServletAutocomplete extends BaseAjaxServlet  {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("consigneeName");
        
            List list = com.wings.adapter.StrutsConsigneeDelegate.getConsigneeByName("%"+name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "idConsignee",true).toString();
        } catch (Exception e) {
            return null;
        }
        
    }
}
