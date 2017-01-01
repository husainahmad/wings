/*
 * JobsheetsoDetailForm.java
 *
 * Created on May 16, 2008, 11:55 PM
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
public class JobsheetsoDetailForm extends JobsheetForm {
   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private java.lang.Integer _idJobSheetSo = null;
   
   private java.lang.String _shippingLine = null;
   private java.lang.String _shippingLineName = null;
   private java.lang.String _feederVessel = null;
   private java.lang.String _mvessel = null;
   private java.lang.String _termMbl = null;
   private java.lang.String _termHbl = null;
   private java.lang.String _origin = null;
   private java.lang.String _destination = null;
   private java.util.Date _etdorigin = null;
   private java.util.Date _etadestination = null;
   private java.lang.String _mbl = null;
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
   public JobsheetsoDetailForm() {
   }    
  
   public java.lang.Integer getIdJobSheetSo() {
      return _idJobSheetSo;
   }
  
   public void setIdJobSheetSo(java.lang.Integer idJobSheetSo) {
      _idJobSheetSo = idJobSheetSo;
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
   
   public java.lang.String getDestination() {
      return _destination;
   }
  
   public void setDestination(java.lang.String destination) {
      _destination = destination;
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
  
   public java.util.Date getEtadestination() {
      return _etadestination;
   }
   
   public String getEtadestinationAsString() {
      if( _etadestination != null ) {
         return FORMAT.format(_etadestination);
      }
      else {
         return "";
      }
   }
   
   public void setEtadestination(java.util.Date etadestination) {
      _etadestination = etadestination;
   }
  
   public void setEtadestinationAsString(String etadestination) {
      try {
         _etadestination = new java.util.Date(FORMAT.parse(etadestination).getTime());
      } catch (ParseException pe) {
         //_etadestination = new java.util.Date((new java.util.Date()).getTime());
         _etadestination = null;
      }
   }
  
   public java.lang.String getMbl() {
      return _mbl;
   }
   
   public void setMbl(java.lang.String mbl) {
      _mbl = mbl;
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
  
    private java.util.Date _sinDate = null;        
    
    public String getSinDateAsString() {
      if( getSinDate() != null ) {
         return FORMAT.format(getSinDate());
      }
      else {
         return "";
      }
   }
    
    public void setSinDateAsString(String sinDate) {
      try {
         setSinDate(new java.util.Date(FORMAT.parse(sinDate).getTime()));
      } catch (ParseException pe) {
         //setSinDate(new java.util.Date((new java.util.Date()).getTime()));
         setSinDate(null);
      }
   }
    
    public java.util.Date getSinDate() {
        return _sinDate;
    }

    public void setSinDate(java.util.Date sinDate) {
        this._sinDate = sinDate;
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
