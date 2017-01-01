/*
 * SOAServletAutocomplete.java
 *
 * Created on August 24, 2008, 10:15 PM
 */

package com.wings.web.servlets.ajaxtag;

import com.wings.persistence.Consignee;
import com.wings.persistence.MonthlySales;
import com.wings.persistence.Shippingline;
import com.wings.web.struts.forms.ShippinglineForm;
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
public class ShippingLineServletAutocomplete extends BaseAjaxServlet   {
    
    public String getXmlContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            String name = httpServletRequest.getParameter("shippingLineName");
            ShippinglineForm shippinglineForm = new ShippinglineForm();
            shippinglineForm.setName(name +"%");
            
            List list = com.wings.adapter.StrutsConsigneeDelegate.getConsigneeByName(name+"%");

            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "idConsignee",true).toString();
            /*
            //List list = com.wings.adapter.StrutsShippinglineDelegate..StrutsJobsheetDelegate.findStatementOfAccount(name+"%");
            List list = com.wings.adapter.StrutsShippinglineDelegate.findByName(shippinglineForm);
            try {
                Query q = new Query ();            
                q.parse("select * from com.wings.persistence.Shippingline order by name");
                QueryResults qr2 = q.execute (list);            
                List qrList = qr2.getResults();
                list = new ArrayList();
                MonthlySales ms = null;
                for (int j=0;j<qrList.size();j++) {
                    Shippingline c = (Shippingline)qrList.get(j);
                    list.add(c);
                }
            } catch (Exception ee) {                
            } 
            // Create xml schema
            return new AjaxXmlBuilder().addItems(list, "name", "name",true).toString();            
            */
        } catch (Exception e) {
            return null;
        }
        
    } 
}
