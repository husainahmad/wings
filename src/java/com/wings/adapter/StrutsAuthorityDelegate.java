package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.AuthorityDAO;
import com.wings.ibatis.DaoConfig;
import java.util.List;

public class StrutsAuthorityDelegate {

 
   public static List findAll () throws Exception {
      AuthorityDAO authorityDAO;            
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      authorityDAO = (AuthorityDAO)daoMgr.getDao(AuthorityDAO.class);                            
      return authorityDAO.selectAll();
   }


   

}
