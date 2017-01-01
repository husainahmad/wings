/*
 * SOAServletAutocomplete.java
 *
 * Created on August 24, 2008, 10:15 PM
 */

package com.wings.web.servlets.ajaxtag;

import com.wings.persistence.Consignee;
import com.wings.persistence.MonthlySales;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import org.ajaxtags.servlets.BaseAjaxServlet;
import org.ajaxtags.xml.AjaxXmlBuilder;
import org.josql.Query;
import org.josql.QueryResults;

/**
 *
 * @author Ahmad Husain
 * @version
 */
public class SOAServletAutocomplete extends BaseAjaxServlet   {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("idConsignee");
        
            List list = com.wings.adapter.StrutsJobsheetDelegate.findStatementOfAccount(name+"%");
            
            try {
                Query q = new Query ();            
                q.parse("select * from com.wings.persistence.Consignee order by name");
                QueryResults qr2 = q.execute (list);            
                List qrList = qr2.getResults();
                list = new ArrayList();
                MonthlySales ms = null;
                for (int j=0;j<qrList.size();j++) {
                    Consignee c = (Consignee)qrList.get(j);
                    list.add(c);
                }
            } catch (Exception ee) {                
            } 
            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "name",true).toString();            
            
        } catch (Exception e) {
            return null;
        }
        
    } 
}
