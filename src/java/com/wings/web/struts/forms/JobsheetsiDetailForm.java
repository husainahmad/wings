/*
 * JobsheetsiDetailForm.java
 *
 * Created on May 16, 2008, 3:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ahmad husain
 */
public class JobsheetsiDetailForm extends JobsheetForm {
    
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idJobSheetSi = null;
   
   private java.lang.String _shippingLine = null;
   private java.lang.String _shippingLineName = null;
   private java.lang.String _feederVessel = null;
   private java.lang.String _mvessel = null;
   private java.lang.String _termMbl = null;
   private java.lang.String _termHbl = null;
   private java.lang.String _origin = null;
   private java.util.Date _etdorigin = null;
   private java.util.Date _etaorigin = null;
   private java.util.Date _customeDate = null;
   private java.lang.String _pod = null;
   private java.lang.String _trucking = null;
   private java.lang.String _commodity = null;
   private java.lang.String _consigneeName = null;
   private java.lang.String _shipperName = null;
   private java.lang.String _agentName = null;
   private java.lang.String _forwarderName = null;
   private java.lang.String _originName = null;
   private java.lang.String _destinationName = null;
   private java.lang.String _transportName = null;
   private java.lang.String _billTo = null;
   private java.lang.String _billToDebit = null;   
   private java.lang.String _dnNo = null;
   private java.lang.Double _jaminan = null;
   public JobsheetsiDetailForm() {
   }
   
   public java.lang.Integer getIdJobSheetSi() {
      return _idJobSheetSi;
   }

 
   public void setIdJobSheetSi(java.lang.Integer idJobSheetSi) {
      _idJobSheetSi = idJobSheetSi;
   }
  
   public java.lang.String getShippingLine() {
      return _shippingLine;
   }


   public void setShippingLine(java.lang.String shippingLine) {
      _shippingLine = shippingLine;
   }
 
   public java.lang.String getFeederVessel() {
      return _feederVessel;
   }

  
   public void setFeederVessel(java.lang.String feederVessel) {
      _feederVessel = feederVessel;
   }

   public java.lang.String getMvessel() {
      return _mvessel;
   }

   public void setMvessel(java.lang.String mvessel) {
      _mvessel = mvessel;
   }

   public java.lang.String getTermMbl() {
      return _termMbl;
   }

  
   public void setTermMbl(java.lang.String termMbl) {
      _termMbl = termMbl;
   }
   
   public java.lang.String getTermHbl() {
      return _termHbl;
   }


   public void setTermHbl(java.lang.String termHbl) {
      _termHbl = termHbl;
   }
 
   public java.lang.String getOrigin() {
      return _origin;
   }


   public void setOrigin(java.lang.String origin) {
      _origin = origin;
   }

   public java.util.Date getEtdorigin() {
      return _etdorigin;
   }


   public String getEtdoriginAsString() {
      if( _etdorigin != null ) {
         return FORMAT.format(_etdorigin);
      }
      else {
         return "";
      }
   }


   public void setEtdorigin(java.util.Date etdorigin) {
      _etdorigin = etdorigin;
   }

 
   public void setEtdoriginAsString(String etdorigin) {
      try {
         _etdorigin = new java.util.Date(FORMAT.parse(etdorigin).getTime());
      } catch (ParseException pe) {
         //_etdorigin = new java.util.Date((new java.util.Date()).getTime());
          _etdorigin = null;
      }
   }


   public java.util.Date getEtaorigin() {
      return _etaorigin;
   }

   public String getEtaoriginAsString() {
      if( _etaorigin != null ) {
         return FORMAT.format(_etaorigin);
      }
      else {
         return "";
      }
   }


   public void setEtaorigin(java.util.Date etaorigin) {
      _etaorigin = etaorigin;
   }

   public void setEtaoriginAsString(String etaorigin) {
      try {
         _etaorigin = new java.util.Date(FORMAT.parse(etaorigin).getTime());
      } catch (ParseException pe) {
         //_etaorigin = new java.util.Date((new java.util.Date()).getTime());
         _etaorigin = null;
      }
   }

   public java.lang.String getPod() {
      return _pod;
   }

   public void setPod(java.lang.String pod) {
      _pod = pod;
   }

   public java.lang.String getTrucking() {
      return _trucking;
   }

   public void setTrucking(java.lang.String trucking) {
      _trucking = trucking;
   }

    public java.lang.String getCommodity() {
        return _commodity;
    }

    public void setCommodity(java.lang.String commodity) {
        this._commodity = commodity;
    }
    
    public String getCustomDateAsString() {
      if( _customeDate != null ) {
         return FORMAT.format(_customeDate);
      }
      else {
         return "";
      }
    }
    
    public void setCustomDateAsString(String customDate) {
      try {
         setCustomeDate(new java.util.Date(FORMAT.parse(customDate).getTime()));
      } catch (ParseException pe) {
         //setCustomeDate(new java.util.Date((new java.util.Date()).getTime()));
          setCustomeDate(null);
      }
   }

    public java.util.Date getCustomeDate() {
        return _customeDate;
    }

    public void setCustomeDate(java.util.Date customeDate) {
        this._customeDate = customeDate;
    }

    public java.lang.String getConsigneeName() {
        return _consigneeName;
    }

    public void setConsigneeName(java.lang.String consigneeName) {
        this._consigneeName = consigneeName;
    }

    public java.lang.String getShipperName() {
        return _shipperName;
    }

    public void setShipperName(java.lang.String shipperName) {
        this._shipperName = shipperName;
    }

    public java.lang.String getAgentName() {
        return _agentName;
    }

    public void setAgentName(java.lang.String agentName) {
        this._agentName = agentName;
    }

    public java.lang.String getOriginName() {
        return _originName;
    }

    public void setOriginName(java.lang.String originName) {
        this._originName = originName;
    }

    public java.lang.String getDestinationName() {
        return _destinationName;
    }

    public void setDestinationName(java.lang.String destinationName) {
        this._destinationName = destinationName;
    }

    public java.lang.String getTransportName() {
        return _transportName;
    }

    public void setTransportName(java.lang.String transportName) {
        this._transportName = transportName;
    }

    public java.lang.String getBillTo() {
        return _billTo;
    }

    public void setBillTo(java.lang.String billTo) {
        this._billTo = billTo;
    }
   
    public java.lang.String getDnNo() {
        return _dnNo;
    }

    public void setDnNo(java.lang.String dnNo) {
        this._dnNo = dnNo;
    }

    public java.lang.String getBillToDebit() {
        return _billToDebit;
    }

    public void setBillToDebit(java.lang.String billToDebit) {
        this._billToDebit = billToDebit;
    }

    /**
     * @return the _shippingLineName
     */
    public java.lang.String getShippingLineName() {
        return _shippingLineName;
    }

    /**
     * @param shippingLineName the _shippingLineName to set
     */
    public void setShippingLineName(java.lang.String shippingLineName) {
        this._shippingLineName = shippingLineName;
    }

    /**
     * @return the _forwarderName
     */
    public java.lang.String getForwarderName() {
        return _forwarderName;
    }

    /**
     * @param forwarderName the _forwarderName to set
     */
    public void setForwarderName(java.lang.String forwarderName) {
        this._forwarderName = forwarderName;
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

   

}
