
package com.wings.web.struts.forms;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class MonthYearForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
   private Date date;
   private java.lang.Integer _year = null;
   private java.lang.Integer _month = null;
   private java.lang.String _idJobType = null;
   private java.lang.String _noBatch = null;
   private java.lang.String _idAccount = null;
   private java.lang.String _idConsignee = null;
   private String strYearMonthDate;

   private java.lang.String _jobNo = null;
   private java.lang.String _invoiceNoUsd = null;
   private java.lang.String _debitNo = null;
   private java.lang.String _idShipper = null;

   private java.lang.String _idAgent = null;
   private java.lang.Double _qty = null;

   private java.lang.String _shippingLine = null;
   private java.lang.String _shippingLineName = null;
   private java.lang.String _feederVessel = null;
   private java.lang.String _mvessel = null;
   private java.lang.String _termMbl = null;
   private java.lang.String _termHbl = null;
   
   private java.lang.String _mawb = null;
   private java.lang.String _hawb = null;
   private java.lang.String _flight = null;

   private java.lang.String _origin = null;
   private java.util.Date _etdorigin = null;
   private java.util.Date _etaorigin = null;
   private java.lang.String _pod = null;
   private java.lang.String _trucking = null;
   private java.lang.String _commodity = null;
   private java.lang.String _dnNo;
   private java.lang.String _txtSearch;

   private String query;

   public MonthYearForm() {
   }

    public java.lang.Integer getYear() {
        return _year;
    }

    public void setYear(java.lang.Integer year) {
        this._year = year;
    }

    public java.lang.Integer getMonth() {
        return _month;
    }

    public void setMonth(java.lang.Integer month) {
        this._month = month;
    }    

    public java.lang.String getIdJobType() {
        return _idJobType;
    }

    public void setIdJobType(java.lang.String idJobType) {
        this._idJobType = idJobType;
    }

    public java.lang.String getNoBatch() {
        return _noBatch;
    }

    public void setNoBatch(java.lang.String noBatch) {
        this._noBatch = noBatch;
    }

    public java.lang.String getIdAccount() {
        return _idAccount;
    }

    public void setIdAccount(java.lang.String idAccount) {
        this._idAccount = idAccount;
    }

    public java.lang.String getIdConsignee() {
        return _idConsignee;
    }

    public void setIdConsignee(java.lang.String idConsignee) {
        this._idConsignee = idConsignee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStrYearMonthDate() {
        return strYearMonthDate;
    }

    public void setStrYearMonthDate(String strYearMonthDate) {
        this.strYearMonthDate = strYearMonthDate;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return the _jobNo
     */
    public java.lang.String getJobNo() {
        return _jobNo;
    }

    /**
     * @param jobNo the _jobNo to set
     */
    public void setJobNo(java.lang.String jobNo) {
        this._jobNo = jobNo;
    }

    /**
     * @return the _invoiceNoUsd
     */
    public java.lang.String getInvoiceNoUsd() {
        return _invoiceNoUsd;
    }

    /**
     * @param invoiceNoUsd the _invoiceNoUsd to set
     */
    public void setInvoiceNoUsd(java.lang.String invoiceNoUsd) {
        this._invoiceNoUsd = invoiceNoUsd;
    }

    /**
     * @return the _debitNo
     */
    public java.lang.String getDebitNo() {
        return _debitNo;
    }

    /**
     * @param debitNo the _debitNo to set
     */
    public void setDebitNo(java.lang.String debitNo) {
        this._debitNo = debitNo;
    }

    /**
     * @return the _idShipper
     */
    public java.lang.String getIdShipper() {
        return _idShipper;
    }

    /**
     * @param idShipper the _idShipper to set
     */
    public void setIdShipper(java.lang.String idShipper) {
        this._idShipper = idShipper;
    }

    /**
     * @return the _idAgent
     */
    public java.lang.String getIdAgent() {
        return _idAgent;
    }

    /**
     * @param idAgent the _idAgent to set
     */
    public void setIdAgent(java.lang.String idAgent) {
        this._idAgent = idAgent;
    }

    /**
     * @return the _qty
     */
    public java.lang.Double getQty() {
        return _qty;
    }

    /**
     * @param qty the _qty to set
     */
    public void setQty(java.lang.Double qty) {
        this._qty = qty;
    }

    /**
     * @return the _shippingLine
     */
    public java.lang.String getShippingLine() {
        return _shippingLine;
    }

    /**
     * @param shippingLine the _shippingLine to set
     */
    public void setShippingLine(java.lang.String shippingLine) {
        this._shippingLine = shippingLine;
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
     * @return the _feederVessel
     */
    public java.lang.String getFeederVessel() {
        return _feederVessel;
    }

    /**
     * @param feederVessel the _feederVessel to set
     */
    public void setFeederVessel(java.lang.String feederVessel) {
        this._feederVessel = feederVessel;
    }

    /**
     * @return the _mvessel
     */
    public java.lang.String getMvessel() {
        return _mvessel;
    }

    /**
     * @param mvessel the _mvessel to set
     */
    public void setMvessel(java.lang.String mvessel) {
        this._mvessel = mvessel;
    }

    /**
     * @return the _termMbl
     */
    public java.lang.String getTermMbl() {
        return _termMbl;
    }

    /**
     * @param termMbl the _termMbl to set
     */
    public void setTermMbl(java.lang.String termMbl) {
        this._termMbl = termMbl;
    }

    /**
     * @return the _termHbl
     */
    public java.lang.String getTermHbl() {
        return _termHbl;
    }

    /**
     * @param termHbl the _termHbl to set
     */
    public void setTermHbl(java.lang.String termHbl) {
        this._termHbl = termHbl;
    }

    /**
     * @return the _origin
     */
    public java.lang.String getOrigin() {
        return _origin;
    }

    /**
     * @param origin the _origin to set
     */
    public void setOrigin(java.lang.String origin) {
        this._origin = origin;
    }

    /**
     * @return the _etdorigin
     */
    public java.util.Date getEtdorigin() {
        return _etdorigin;
    }

    /**
     * @param etdorigin the _etdorigin to set
     */
    public void setEtdorigin(java.util.Date etdorigin) {
        this._etdorigin = etdorigin;
    }

    /**
     * @return the _etaorigin
     */
    public java.util.Date getEtaorigin() {
        return _etaorigin;
    }

    /**
     * @param etaorigin the _etaorigin to set
     */
    public void setEtaorigin(java.util.Date etaorigin) {
        this._etaorigin = etaorigin;
    }

    /**
     * @return the _pod
     */
    public java.lang.String getPod() {
        return _pod;
    }

    /**
     * @param pod the _pod to set
     */
    public void setPod(java.lang.String pod) {
        this._pod = pod;
    }

    /**
     * @return the _trucking
     */
    public java.lang.String getTrucking() {
        return _trucking;
    }

    /**
     * @param trucking the _trucking to set
     */
    public void setTrucking(java.lang.String trucking) {
        this._trucking = trucking;
    }

    /**
     * @return the _commodity
     */
    public java.lang.String getCommodity() {
        return _commodity;
    }

    /**
     * @param commodity the _commodity to set
     */
    public void setCommodity(java.lang.String commodity) {
        this._commodity = commodity;
    }

    /**
     * @return the _dnNo
     */
    public java.lang.String getDnNo() {
        return _dnNo;
    }

    /**
     * @param dnNo the _dnNo to set
     */
    public void setDnNo(java.lang.String dnNo) {
        this._dnNo = dnNo;
    }

    /**
     * @return the _txtSearch
     */
    public java.lang.String getTxtSearch() {
        return _txtSearch;
    }

    /**
     * @param txtSearch the _txtSearch to set
     */
    public void setTxtSearch(java.lang.String txtSearch) {
        this._txtSearch = txtSearch;
    }

    /**
     * @return the _mawb
     */
    public java.lang.String getMawb() {
        return _mawb;
    }

    /**
     * @return the _hawb
     */
    public java.lang.String getHawb() {
        return _hawb;
    }

    /**
     * @return the _flight
     */
    public java.lang.String getFlight() {
        return _flight;
    }

    /**
     * @param mawb the _mawb to set
     */
    public void setMawb(java.lang.String mawb) {
        this._mawb = mawb;
    }

    /**
     * @param hawb the _hawb to set
     */
    public void setHawb(java.lang.String hawb) {
        this._hawb = hawb;
    }

    /**
     * @param flight the _flight to set
     */
    public void setFlight(java.lang.String flight) {
        this._flight = flight;
    }
}
