package com.wings.dao;

import com.wings.web.struts.forms.TransporterForm;
import java.util.List;

import com.wings.persistence.TransporterKey;
import com.wings.persistence.Transporter;

public interface TransporterDAO {

    
    void insert(Transporter record);

    
    int updateByPrimaryKey(Transporter record);

     
    Transporter selectByPrimaryKey(TransporterKey key);

    
    int deleteByPrimaryKey(TransporterKey key);
    
    List selectByAll(Transporter transporter);
    
    List selectByName(Transporter record);
    
}
