package com.wings.persistence;


public class JobtypeKey {

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column jobtype.idJobType
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    private String idJobType;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column jobtype.idJobType
     *
     * @return the value of jobtype.idJobType
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getIdJobType() {
        return idJobType;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column jobtype.idJobType
     *
     * @param idJobType the value for jobtype.idJobType
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setIdJobType(String idJobType) {
        if (idJobType != null) {
            idJobType = idJobType.trim();
        }
        this.idJobType = idJobType;
    }
}
