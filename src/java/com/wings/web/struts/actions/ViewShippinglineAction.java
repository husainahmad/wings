package com.wings.web.struts.actions;

import com.wings.web.struts.forms.ShippinglineForm;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.RequestUtils;

public final class ViewShippinglineAction extends Action {

   public ActionForward execute (
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response
   )
      throws IOException, ServletException {

      // First see if there is a vo as request attribute.
      ShippinglineForm shippinglineForm = (ShippinglineForm)request.getAttribute("shippingline");
      if( shippinglineForm == null ) {
         // The vo wasn't on the request. We came via a direct link.
         // Get pk data from request object and use delegate to lookup
         try {
            shippinglineForm = new ShippinglineForm();
            // Now set the form members with request values 
            RequestUtils.populate(shippinglineForm, request);

            shippinglineForm = com.wings.adapter.StrutsShippinglineDelegate.edit(shippinglineForm);
            request.setAttribute("shippingline", shippinglineForm);
         } catch (Exception e) {
            getServlet().log("Create error", e);
            request.setAttribute("name", "Shippingline");
            return mapping.findForward("ejb-finder-exception");
         }
      }

      // Make a map that can be used to identify this Shippingline in any links
      HashMap urlParams = new HashMap();
  urlParams.put("idShippingLine",shippinglineForm.getIdShippingLine());
      request.setAttribute("__pk", urlParams);

      return mapping.findForward("view");
   }
   
   /**
    * Get the named value as a string from the request parameter, or from the
    * request obj if not found.
    * 
    * @param req The request object.
    * @param name The name of the parameter.
    *
    * @return The value of the parameter as a String.
    */
   private String getParameter(HttpServletRequest req, String name) {
      String value = req.getParameter(name);
      if (value == null) {
         value = req.getAttribute(name).toString();
      }
      return value;
   }
}
