
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class JobsheetForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private java.lang.Integer _idJobSheet = null;
   private java.lang.String _jobNo = null;
   private java.lang.String _invoiceNoUsd = null;
   private java.lang.String _debitNo = null;   
   private java.lang.String _idShipper = null;
   private java.lang.String _idConsignee = null;
   private java.lang.String _idForwarder = null;
   private java.lang.String _idAgent = null;
   private java.lang.Double _qty = null;
   private java.lang.Double _weight = null;
   private java.lang.Double _volume = null;
   private java.lang.String _qtyDesc = null;
   private java.lang.String _weightDesc = null;
   private java.lang.String _volumeDesc = null;
   private java.lang.String _idJobType = null;
   private java.sql.Date _shippeddate = null;
   private java.lang.String _remark = null;
   private java.lang.Double _totalBillingIDR = null;
   private java.lang.Double _totalExpensesIDR = null;
   private java.lang.Double _totalBillingUSD = null;
   private java.lang.Double _totalExpensesUSD = null;
   private java.lang.String _invoiceStatus = null;
   private java.lang.String _debitStatus = null;
   private java.lang.String _idTransporter = null;
   private java.lang.Double _transportCost = null;
   private java.lang.Double _refundIDR = null;
   private java.lang.Double _refundUSD = null;
   private java.lang.String _cnNo;    
   private java.lang.Double _depart;    
   private java.lang.String _cnKurs;   
   private java.lang.String _cmb;
   private java.lang.Double _creditNoteIDR = null;
   private java.lang.Double _creditNoteUSD = null;
   private java.lang.Double _jaminan;
   
   private java.lang.Integer _status;
    
   private java.lang.Double _vatIDR;
   private java.lang.Double _pphIDR;
   
   private java.lang.Double _vatUSD;
   private java.lang.Double _pphUSD;
       
   private java.lang.Double _dppIDR;
   private java.lang.Double _dppUSD;
    
   /**
    * Standard constructor.
    */
   public JobsheetForm() {
   }

   /**
    * Returns the idJobSheet
    *
    * @return the idJobSheet
    */
   public java.lang.Integer getIdJobSheet() {
      return _idJobSheet;
   }

   /**
    * Sets the idJobSheet
    *
    * @param idJobSheet the new idJobSheet value
    */
   public void setIdJobSheet(java.lang.Integer idJobSheet) {
      _idJobSheet = idJobSheet;
   }
   /**
    * Returns the jobNo
    *
    * @return the jobNo
    */
   public java.lang.String getJobNo() {
      return _jobNo;
   }

   /**
    * Sets the jobNo
    *
    * @param jobNo the new jobNo value
    */
   public void setJobNo(java.lang.String jobNo) {
      _jobNo = jobNo;
   }
   /**
    * Returns the invoiceNoUsd
    *
    * @return the invoiceNoUsd
    */
   public java.lang.String getInvoiceNoUsd() {
      return _invoiceNoUsd;
   }

   /**
    * Sets the invoiceNoUsd
    *
    * @param invoiceNoUsd the new invoiceNoUsd value
    */
   public void setInvoiceNoUsd(java.lang.String invoiceNoUsd) {
      _invoiceNoUsd = invoiceNoUsd;
   }
   /**
    * Returns the idShipper
    *
    * @return the idShipper
    */
   public java.lang.String getIdShipper() {
      return _idShipper;
   }

   /**
    * Sets the idShipper
    *
    * @param idShipper the new idShipper value
    */
   public void setIdShipper(java.lang.String idShipper) {
      _idShipper = idShipper;
   }
   /**
    * Returns the idConsignee
    *
    * @return the idConsignee
    */
   public java.lang.String getIdConsignee() {
      return _idConsignee;
   }

   /**
    * Sets the idConsignee
    *
    * @param idConsignee the new idConsignee value
    */
   public void setIdConsignee(java.lang.String idConsignee) {
      _idConsignee = idConsignee;
   }
   /**
    * Returns the idAgent
    *
    * @return the idAgent
    */
   public java.lang.String getIdAgent() {
      return _idAgent;
   }

   /**
    * Sets the idAgent
    *
    * @param idAgent the new idAgent value
    */
   public void setIdAgent(java.lang.String idAgent) {
      _idAgent = idAgent;
   }
   /**
    * Returns the qty
    *
    * @return the qty
    */
   public java.lang.Double getQty() {
      return _qty;
   }

   /**
    * Sets the qty
    *
    * @param qty the new qty value
    */
   public void setQty(java.lang.Double qty) {
      _qty = qty;
   }
   /**
    * Returns the weight
    *
    * @return the weight
    */
   public java.lang.Double getWeight() {
      return _weight;
   }

   /**
    * Sets the weight
    *
    * @param weight the new weight value
    */
   public void setWeight(java.lang.Double weight) {
      _weight = weight;
   }
   /**
    * Returns the volume
    *
    * @return the volume
    */
   public java.lang.Double getVolume() {
      return _volume;
   }

   /**
    * Sets the volume
    *
    * @param volume the new volume value
    */
   public void setVolume(java.lang.Double volume) {
      _volume = volume;
   }
   /**
    * Returns the qtyDesc
    *
    * @return the qtyDesc
    */
   public java.lang.String getQtyDesc() {
      return _qtyDesc;
   }

   /**
    * Sets the qtyDesc
    *
    * @param qtyDesc the new qtyDesc value
    */
   public void setQtyDesc(java.lang.String qtyDesc) {
      _qtyDesc = qtyDesc;
   }
   /**
    * Returns the weightDesc
    *
    * @return the weightDesc
    */
   public java.lang.String getWeightDesc() {
      return _weightDesc;
   }

   /**
    * Sets the weightDesc
    *
    * @param weightDesc the new weightDesc value
    */
   public void setWeightDesc(java.lang.String weightDesc) {
      _weightDesc = weightDesc;
   }
   /**
    * Returns the volumeDesc
    *
    * @return the volumeDesc
    */
   public java.lang.String getVolumeDesc() {
      return _volumeDesc;
   }

   /**
    * Sets the volumeDesc
    *
    * @param volumeDesc the new volumeDesc value
    */
   public void setVolumeDesc(java.lang.String volumeDesc) {
      _volumeDesc = volumeDesc;
   }
   /**
    * Returns the idJobType
    *
    * @return the idJobType
    */
   public java.lang.String getIdJobType() {
      return _idJobType;
   }

  
   public void setIdJobType(java.lang.String idJobType) {
      _idJobType = idJobType;
   }
  
   public String getShippeddateAsString() {
      if( getShippeddate() != null ) {
         return FORMAT.format(getShippeddate());
      }
      else {
         return "";
      }
   }
  
   public void setShippeddateAsString(String shippeddate) {
      try {
         setShippeddate(new java.sql.Date(FORMAT.parse(shippeddate).getTime()));
      } catch (ParseException pe) {
         setShippeddate(new java.sql.Date((new java.util.Date()).getTime()));
      }
   }

   public java.lang.String getRemark() {
      return _remark;
   }

   public void setRemark(java.lang.String remark) {
      _remark = remark;
   }  
  
   public java.lang.String getInvoiceStatus() {
      return _invoiceStatus;
   }

   public void setInvoiceStatus(java.lang.String invoiceStatus) {
      _invoiceStatus = invoiceStatus;
   }
 
   public java.lang.String getDebitStatus() {
      return _debitStatus;
   }

   public void setDebitStatus(java.lang.String debitStatus) {
      _debitStatus = debitStatus;
   }

   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
      ActionErrors errors = new ActionErrors();
      // test for nullity
      if(getIdJobSheet() == null) {
         errors.add("idJobSheet", new ActionError("error.idJobSheet.required"));
      }
      if(getJobNo() == null) {
         errors.add("jobNo", new ActionError("error.jobNo.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.sql.Date getShippeddate() {
        return _shippeddate;
    }

    public void setShippeddate(java.sql.Date shippeddate) {
        this._shippeddate = shippeddate;
    }

    public java.lang.Double getTotalBillingIDR() {
        return _totalBillingIDR;
    }

    public void setTotalBillingIDR(java.lang.Double totalBillingIDR) {
        this._totalBillingIDR = totalBillingIDR;
    }

    public java.lang.Double getTotalExpensesIDR() {
        return _totalExpensesIDR;
    }

    public void setTotalExpensesIDR(java.lang.Double totalExpensesIDR) {
        this._totalExpensesIDR = totalExpensesIDR;
    }

    public java.lang.Double getTotalBillingUSD() {
        return _totalBillingUSD;
    }

    public void setTotalBillingUSD(java.lang.Double totalBillingUSD) {
        this._totalBillingUSD = totalBillingUSD;
    }

    public java.lang.Double getTotalExpensesUSD() {
        return _totalExpensesUSD;
    }

    public void setTotalExpensesUSD(java.lang.Double totalExpensesUSD) {
        this._totalExpensesUSD = totalExpensesUSD;
    }

    public java.lang.String getIdTransporter() {
        return _idTransporter;
    }

    public void setIdTransporter(java.lang.String idTransporter) {
        this._idTransporter = idTransporter;
    }

    public java.lang.Double getTransportCost() {
        return _transportCost;
    }

    public void setTransportCost(java.lang.Double transportCost) {
        this._transportCost = transportCost;
    }
    
    public java.lang.String getCnNo() {
        return _cnNo;
    }

    public void setCnNo(java.lang.String cnNo) {
        this._cnNo = cnNo;
    }

    public java.lang.Double getDepart() {
        return _depart;
    }

    public void setDepart(java.lang.Double depart) {
        this._depart = depart;
    }

    public java.lang.String getCnKurs() {
        return _cnKurs;
    }

    public void setCnKurs(java.lang.String cnKurs) {
        this._cnKurs = cnKurs;
    }

    public java.lang.String getDebitNo() {
        return _debitNo;
    }

    public void setDebitNo(java.lang.String debitNo) {
        this._debitNo = debitNo;
    }

    public java.lang.String getCmb() {
        return _cmb;
    }

    public void setCmb(java.lang.String cmb) {
        this._cmb = cmb;
    }

    public java.lang.Double getRefundIDR() {
        return _refundIDR;
    }

    public void setRefundIDR(java.lang.Double refundIDR) {
        this._refundIDR = refundIDR;
    }

    public java.lang.Double getRefundUSD() {
        return _refundUSD;
    }

    public void setRefundUSD(java.lang.Double refundUSD) {
        this._refundUSD = refundUSD;
    }

    public java.lang.Double getCreditNoteIDR() {
        return _creditNoteIDR;
    }

    public void setCreditNoteIDR(java.lang.Double creditNoteIDR) {
        this._creditNoteIDR = creditNoteIDR;
    }

    public java.lang.Double getCreditNoteUSD() {
        return _creditNoteUSD;
    }

    public void setCreditNoteUSD(java.lang.Double creditNoteUSD) {
        this._creditNoteUSD = creditNoteUSD;
    }

    /**
     * @return the _idForwarder
     */
    public java.lang.String getIdForwarder() {
        return _idForwarder;
    }

    /**
     * @param idForwarder the _idForwarder to set
     */
    public void setIdForwarder(java.lang.String idForwarder) {
        this._idForwarder = idForwarder;
    }

    /**
     * @return the _jaminan
     */
    public java.lang.Double getJaminan() {
        return _jaminan;
    }

    /**
     * @param jaminan the _jaminan to set
     */
    public void setJaminan(java.lang.Double jaminan) {
        this._jaminan = jaminan;
    }      

    /**
     * @return the _status
     */
    public java.lang.Integer getStatus() {
        return _status;
    }

    /**
     * @param status the _status to set
     */
    public void setStatus(java.lang.Integer status) {
        this._status = status;
    }

    /**
     * @return the _vatIDR
     */
    public java.lang.Double getVatIDR() {
        return _vatIDR;
    }

    /**
     * @param vatIDR the _vatIDR to set
     */
    public void setVatIDR(java.lang.Double vatIDR) {
        this._vatIDR = vatIDR;
    }

    /**
     * @return the _pphIDR
     */
    public java.lang.Double getPphIDR() {
        return _pphIDR;
    }

    /**
     * @param pphIDR the _pphIDR to set
     */
    public void setPphIDR(java.lang.Double pphIDR) {
        this._pphIDR = pphIDR;
    }

    /**
     * @return the _vatUSD
     */
    public java.lang.Double getVatUSD() {
        return _vatUSD;
    }

    /**
     * @param vatUSD the _vatUSD to set
     */
    public void setVatUSD(java.lang.Double vatUSD) {
        this._vatUSD = vatUSD;
    }

    /**
     * @return the _pphUSD
     */
    public java.lang.Double getPphUSD() {
        return _pphUSD;
    }

    /**
     * @param pphUSD the _pphUSD to set
     */
    public void setPphUSD(java.lang.Double pphUSD) {
        this._pphUSD = pphUSD;
    }

    /**
     * @return the _dppIDR
     */
    public java.lang.Double getDppIDR() {
        return _dppIDR;
    }

    /**
     * @param dppIDR the _dppIDR to set
     */
    public void setDppIDR(java.lang.Double dppIDR) {
        this._dppIDR = dppIDR;
    }

    /**
     * @return the _dppUSD
     */
    public java.lang.Double getDppUSD() {
        return _dppUSD;
    }

    /**
     * @param dppUSD the _dppUSD to set
     */
    public void setDppUSD(java.lang.Double dppUSD) {
        this._dppUSD = dppUSD;
    }
    
}
