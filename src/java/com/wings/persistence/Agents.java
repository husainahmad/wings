package com.wings.persistence;


public class Agents extends AgentsKey {

    
    private String name;

    
    private String description;
    private String description2;
    
    private String contactPerson;

   
    private String telp;

    
    private String fax;

   
    private String email;
    private String email2;
    private String email3;
    private String email4;
    private String email5;
    
    private String address1;

    
    private String address2;

   
    private String postalCode;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column agents.city
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    private String city;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column agents.region
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    private String region;

    private String npwp;
    private String _idAccountIDR = null;
    private String _idAccountUSD = null;
    private String person2;
    private String person3;
    private String person4;
    private String person5;
    
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.name
     *
     * @param name the value for agents.name
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setName(String name) {
        if (name != null) {
            name = name.trim();
        }
        this.name = name;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.description
     *
     * @return the value of agents.description
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.description
     *
     * @param description the value for agents.description
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setDescription(String description) {
        if (description != null) {
            description = description.trim();
        }
        this.description = description;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.contactPerson
     *
     * @return the value of agents.contactPerson
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.contactPerson
     *
     * @param contactPerson the value for agents.contactPerson
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setContactPerson(String contactPerson) {
        if (contactPerson != null) {
            contactPerson = contactPerson.trim();
        }
        this.contactPerson = contactPerson;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.telp
     *
     * @return the value of agents.telp
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getTelp() {
        return telp;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.telp
     *
     * @param telp the value for agents.telp
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setTelp(String telp) {
        if (telp != null) {
            telp = telp.trim();
        }
        this.telp = telp;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.fax
     *
     * @return the value of agents.fax
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.fax
     *
     * @param fax the value for agents.fax
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setFax(String fax) {
        if (fax != null) {
            fax = fax.trim();
        }
        this.fax = fax;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.email
     *
     * @return the value of agents.email
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.email
     *
     * @param email the value for agents.email
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setEmail(String email) {
        if (email != null) {
            email = email.trim();
        }
        this.email = email;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.address1
     *
     * @return the value of agents.address1
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.address1
     *
     * @param address1 the value for agents.address1
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setAddress1(String address1) {
        if (address1 != null) {
            address1 = address1.trim();
        }
        this.address1 = address1;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.address2
     *
     * @return the value of agents.address2
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.address2
     *
     * @param address2 the value for agents.address2
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setAddress2(String address2) {
        if (address2 != null) {
            address2 = address2.trim();
        }
        this.address2 = address2;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.postalCode
     *
     * @return the value of agents.postalCode
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.postalCode
     *
     * @param postalCode the value for agents.postalCode
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setPostalCode(String postalCode) {
        if (postalCode != null) {
            postalCode = postalCode.trim();
        }
        this.postalCode = postalCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.city
     *
     * @return the value of agents.city
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.city
     *
     * @param city the value for agents.city
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setCity(String city) {
        if (city != null) {
            city = city.trim();
        }
        this.city = city;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column agents.region
     *
     * @return the value of agents.region
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column agents.region
     *
     * @param region the value for agents.region
     *
     * @abatorgenerated Thu May 08 01:00:24 PDT 2008
     */
    public void setRegion(String region) {
        if (region != null) {
            region = region.trim();
        }
        this.region = region;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getEmail4() {
        return email4;
    }

    public void setEmail4(String email4) {
        this.email4 = email4;
    }

    public String getEmail5() {
        return email5;
    }

    public void setEmail5(String email5) {
        this.email5 = email5;
    }
   
    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        this.person2 = person2;
    }

    public String getPerson3() {
        return person3;
    }

    public void setPerson3(String person3) {
        this.person3 = person3;
    }

    public String getPerson4() {
        return person4;
    }

    public void setPerson4(String person4) {
        this.person4 = person4;
    }

    public String getPerson5() {
        return person5;
    }

    public void setPerson5(String person5) {
        this.person5 = person5;
    }

    public String getIdAccountIDR() {
        return _idAccountIDR;
    }

    public void setIdAccountIDR(String idAccountIDR) {
        this._idAccountIDR = idAccountIDR;
    }

    public String getIdAccountUSD() {
        return _idAccountUSD;
    }

    public void setIdAccountUSD(String idAccountUSD) {
        this._idAccountUSD = idAccountUSD;
    }

    /**
     * @return the description2
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * @param description2 the description2 to set
     */
    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
