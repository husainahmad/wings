package com.wings.persistence;


public class PerkiraanKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column perkiraan.idPerkiraan
     *
     * @abatorgenerated Sat Jun 21 20:47:27 ICT 2008
     */
    private String idPerkiraan;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column perkiraan.idPerkiraan
     *
     * @return the value of perkiraan.idPerkiraan
     *
     * @abatorgenerated Sat Jun 21 20:47:27 ICT 2008
     */
    public String getIdPerkiraan() {
        return idPerkiraan;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column perkiraan.idPerkiraan
     *
     * @param idPerkiraan the value for perkiraan.idPerkiraan
     *
     * @abatorgenerated Sat Jun 21 20:47:27 ICT 2008
     */
    public void setIdPerkiraan(String idPerkiraan) {
        if (idPerkiraan != null) {
            idPerkiraan = idPerkiraan.trim();
        }
        this.idPerkiraan = idPerkiraan;
    }
}
