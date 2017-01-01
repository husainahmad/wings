/*
 * PopulateTax.java
 *
 * Created on July 29, 2008, 9:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import com.wings.persistence.JobsheetKey;
import com.wings.web.struts.forms.JobsheetForm;
import com.wings.web.struts.forms.TaxForm;

/**
 *
 * @author Ahmad Husain
 */
public class PopulateTax {
    
    /** Creates a new instance of PopulateTax */
    public PopulateTax() {
    }
    
    public static void generateTax(JobsheetKey jobsheetKey, JobsheetForm jobsheetForm) {
        try {
            TaxForm taxForm = new TaxForm();
            taxForm.setIdJobSheet(jobsheetKey.getIdJobSheet().toString());
            try {
                taxForm.setFakturDate(new java.sql.Date(jobsheetForm.getShippeddate().getTime()));
             } catch (Exception ex) {
                taxForm.setFakturDate(new java.sql.Date((new java.util.Date()).getTime()));
             }
            taxForm = com.wings.adapter.StrutsTaxDelegate.create(taxForm);         
        } catch (Exception e) {
            
        }        
    }
}
