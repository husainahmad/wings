package com.wings.persistence;


public class ShipperKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column shipper.idShipper
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    private String idShipper;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column shipper.idShipper
     *
     * @return the value of shipper.idShipper
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getIdShipper() {
        return idShipper;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column shipper.idShipper
     *
     * @param idShipper the value for shipper.idShipper
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setIdShipper(String idShipper) {
        if (idShipper != null) {
            idShipper = idShipper.trim();
        }
        this.idShipper = idShipper;
    }
}
