
package com.wings.web.struts.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form for transactionacc.
 *
 * @author <a href="http://boss.bekk.no/boss/middlegen/"/>Middlegen</a>
 *
 * @struts.form name="transactionaccForm"
 */
public class TransactionaccDetailForm extends ActionForm {

   private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

   private java.lang.Integer _idTransactionAccDetail = null;
   private java.lang.Integer _idTransactionAcc = null;
   private java.lang.String _noBatch = null;
   private java.lang.String _noUrut = null;
   private java.lang.String _batchDesc = null;
   private java.sql.Date _transactionDate = null;
   private java.lang.String _noVoucher = null;
   private java.lang.String _voucherDesc = null;
   private java.lang.String _idAccount = null;
   private java.lang.String _description = null;
   private java.lang.String _kurs = null;
   private java.lang.Double _debit = null;
   private java.lang.Double _kredit = null;
   private java.lang.String _jobNo = null;
   private java.sql.Date _tglTutupBuku = null;
   private java.lang.Integer _inUrut = null;
   private java.lang.Double _kursValue = null;
   private java.lang.String _groupid = null;
   /**
    * Standard constructor.
    */
   public TransactionaccDetailForm() {
   }

   /**
    * Returns the idTransactionAcc
    *
    * @return the idTransactionAcc
    */
   public java.lang.Integer getIdTransactionAcc() {
      return _idTransactionAcc;
   }

   /**
    * Sets the idTransactionAcc
    *
    * @param idTransactionAcc the new idTransactionAcc value
    */
   public void setIdTransactionAcc(java.lang.Integer idTransactionAcc) {
      _idTransactionAcc = idTransactionAcc;
   }
   /**
    * Returns the noBatch
    *
    * @return the noBatch
    */
   public java.lang.String getNoBatch() {
      return _noBatch;
   }

   /**
    * Sets the noBatch
    *
    * @param noBatch the new noBatch value
    */
   public void setNoBatch(java.lang.String noBatch) {
      _noBatch = noBatch;
   }
   /**
    * Returns the noUrut
    *
    * @return the noUrut
    */
   public java.lang.String getNoUrut() {
      return _noUrut;
   }

   /**
    * Sets the noUrut
    *
    * @param noUrut the new noUrut value
    */
   public void setNoUrut(java.lang.String noUrut) {
      _noUrut = noUrut;
   }
   /**
    * Returns the batchDesc
    *
    * @return the batchDesc
    */
   public java.lang.String getBatchDesc() {
      return _batchDesc;
   }

   /**
    * Sets the batchDesc
    *
    * @param batchDesc the new batchDesc value
    */
   public void setBatchDesc(java.lang.String batchDesc) {
      _batchDesc = batchDesc;
   }
   /**
    * Returns the transactionDate
    *
    * @return the transactionDate
    */
   public java.sql.Date getTransactionDate() {
      return _transactionDate;
   }

   /**
    * Returns the transactionDate as a String
    *
    * @return the transactionDate as a String
    */
   public String getTransactionDateAsString() {
      if( _transactionDate != null ) {
         return FORMAT.format(_transactionDate);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the transactionDate
    *
    * @param transactionDate the new transactionDate value
    */
   public void setTransactionDate(java.sql.Date transactionDate) {
      _transactionDate = transactionDate;
   }

   /**
    * Sets the transactionDate as a String.
    *
    * @param transactionDate the new transactionDate value as a String
    */
   public void setTransactionDateAsString(String transactionDate) {
      try {
         _transactionDate = new java.sql.Date(FORMAT.parse(transactionDate).getTime());
      } catch (ParseException pe) {
         _transactionDate = new java.sql.Date((new java.util.Date()).getTime());
      }
   }

   
   public java.lang.String getVoucherDesc() {
      return _voucherDesc;
   }

   /**
    * Sets the voucherDesc
    *
    * @param voucherDesc the new voucherDesc value
    */
   public void setVoucherDesc(java.lang.String voucherDesc) {
      _voucherDesc = voucherDesc;
   }
   /**
    * Returns the idAccount
    *
    * @return the idAccount
    */
   public java.lang.String getIdAccount() {
      return _idAccount;
   }

   /**
    * Sets the idAccount
    *
    * @param idAccount the new idAccount value
    */
   public void setIdAccount(java.lang.String idAccount) {
      _idAccount = idAccount;
   }
   /**
    * Returns the description
    *
    * @return the description
    */
   public java.lang.String getDescription() {
      return _description;
   }

   /**
    * Sets the description
    *
    * @param description the new description value
    */
   public void setDescription(java.lang.String description) {
      _description = description;
   }
   /**
    * Returns the kurs
    *
    * @return the kurs
    */
   public java.lang.String getKurs() {
      return _kurs;
   }

   /**
    * Sets the kurs
    *
    * @param kurs the new kurs value
    */
   public void setKurs(java.lang.String kurs) {
      _kurs = kurs;
   }
   /**
    * Returns the debit
    *
    * @return the debit
    */
   public java.lang.Double getDebit() {
      return _debit;
   }

   /**
    * Sets the debit
    *
    * @param debit the new debit value
    */
   public void setDebit(java.lang.Double debit) {
      _debit = debit;
   }
   /**
    * Returns the kredit
    *
    * @return the kredit
    */
   public java.lang.Double getKredit() {
      return _kredit;
   }

   /**
    * Sets the kredit
    *
    * @param kredit the new kredit value
    */
   public void setKredit(java.lang.Double kredit) {
      _kredit = kredit;
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
    * Returns the tglTutupBuku
    *
    * @return the tglTutupBuku
    */
   public java.sql.Date getTglTutupBuku() {
      return _tglTutupBuku;
   }

   /**
    * Returns the tglTutupBuku as a String
    *
    * @return the tglTutupBuku as a String
    */
   public String getTglTutupBukuAsString() {
      if( _tglTutupBuku != null ) {
         return FORMAT.format(_tglTutupBuku);
      }
      else {
         return "";
      }
   }

   /**
    * Sets the tglTutupBuku
    *
    * @param tglTutupBuku the new tglTutupBuku value
    */
   public void setTglTutupBuku(java.sql.Date tglTutupBuku) {
      _tglTutupBuku = tglTutupBuku;
   }

   /**
    * Sets the tglTutupBuku as a String.
    *
    * @param tglTutupBuku the new tglTutupBuku value as a String
    */
   public void setTglTutupBukuAsString(String tglTutupBuku) {
      try {
         _tglTutupBuku = new java.sql.Date(FORMAT.parse(tglTutupBuku).getTime());
      } catch (ParseException pe) {
         _tglTutupBuku = new java.sql.Date((new java.util.Date()).getTime());
      }
   }



   /**
    * Validate the properties that have been set from this HTTP request,
    * and return an <code>ActionErrors</code> object that encapsulates any
    * validation errors that have been found.  If no errors are found, return
    * <code>null</code> or an <code>ActionErrors</code> object with no
    * recorded error messages.
    *
    * @param mapping The mapping used to select this instance
    * @param request The servlet request we are processing
    */
   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
      ActionErrors errors = new ActionErrors();
      // test for nullity
      if(getIdTransactionAcc() == null) {
         errors.add("idTransactionAcc", new ActionError("error.idTransactionAcc.required"));
      }
      // TODO test format/data
      return errors;
   }

    public java.lang.Integer getInUrut() {
        return _inUrut;
    }

    public void setInUrut(java.lang.Integer inUrut) {
        this._inUrut = inUrut;
    }

    public java.lang.Double getKursValue() {
        return _kursValue;
    }

    public void setKursValue(java.lang.Double kursValue) {
        this._kursValue = kursValue;
    }

    public java.lang.String getNoVoucher() {
        return _noVoucher;
    }

    public void setNoVoucher(java.lang.String noVoucher) {
        this._noVoucher = noVoucher;
    }

    /**
     * @return the _groupid
     */
    public java.lang.String getGroupid() {
        return _groupid;
    }

    /**
     * @param groupid the _groupid to set
     */
    public void setGroupid(java.lang.String groupid) {
        this._groupid = groupid;
    }

    /**
     * @return the _idTransactionAccDetail
     */
    public java.lang.Integer getIdTransactionAccDetail() {
        return _idTransactionAccDetail;
    }

    /**
     * @param idTransactionAccDetail the _idTransactionAccDetail to set
     */
    public void setIdTransactionAccDetail(java.lang.Integer idTransactionAccDetail) {
        this._idTransactionAccDetail = idTransactionAccDetail;
    }

}
