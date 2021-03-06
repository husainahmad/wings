
package com.wings.adapter;

import com.ibatis.dao.client.DaoManager;
import com.wings.dao.AgentsDAO;
import com.wings.ibatis.DaoConfig;
import com.wings.persistence.Agents;
import com.wings.persistence.AgentsKey;
import com.wings.web.struts.forms.AgentForm;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;

/**
 * This is a delegate class to handle interaction with the backend persistence layer of cmp20. 
 * It has a set of methods to handle persistence for Agent data (i.e. 
 * com.wings.web.struts.AgentForm objects).
 * 
 * @author <strong>Generated by Middlegen.</strong>
 */
public class StrutsAgentDelegate {


   /**
    * Create a new com.wings.web.struts.AgentForm object and persist (i.e. insert) it.
    *
    * @param   agentForm   The object containing the data for the new com.wings.web.struts.AgentForm object
    * @exception   Exception   If the new com.wings.web.struts.AgentForm object cannot be created or persisted.
    */
   public static AgentForm create (AgentForm agentForm) throws Exception {
      Agents agent = new Agents();  
      BeanUtils.copyProperties(agent, agentForm);
      agent.setIdAgent(agent.getIdAgent().replaceAll("&",""));
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);      
      agentsDAO.insert(agent);
      return agentForm;
   }

   /**
    * Update (i.e. persist) an existing com.wings.web.struts.AgentForm object.
    *
    * @param   agentForm   The com.wings.web.struts.AgentForm object containing the data to be updated
    * @exception   Exception   If the com.wings.web.struts.AgentForm object cannot be updated/persisted.
    */
   public static AgentForm update (AgentForm agentForm) throws Exception {
      Agents agent = new Agents();  
      BeanUtils.copyProperties(agent, agentForm);
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);    
      agentsDAO.updateByPrimaryKey(agent);
      return agentForm;
   }

   /**
    * Retrieve an existing com.wings.web.struts.AgentForm object for editing.
    *
    * @param   agentForm   The com.wings.web.struts.AgentForm object containing the data used to retrieve the object (i.e. the primary key info).
    * @exception   Exception   If the com.wings.web.struts.AgentForm object cannot be retrieved.
    */
   public static AgentForm edit (AgentForm agentForm) throws Exception {
      AgentsKey agentKey = new AgentsKey();  
      agentKey.setIdAgent(agentForm.getIdAgent());      
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);    
      Agents agent = agentsDAO.selectByPrimaryKey(agentKey);
      
      try {
          BeanUtils.copyProperties(agentForm, agent);
      } catch (Exception e) {
          
      }   
      return agentForm;
   }

   /**
    * Remove (delete) an existing com.wings.web.struts.AgentForm object.
    *
    * @param   agentForm   The com.wings.web.struts.AgentForm object containing the data to be deleted.
    * @exception   Exception   If the com.wings.web.struts.AgentForm object cannot be removed.
    */  
   public static void remove (AgentForm agentForm) throws Exception {
      AgentsKey agentKey = new AgentsKey();  
      agentKey.setIdAgent(agentForm.getIdAgent());      
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);    
      agentsDAO.deleteByPrimaryKey(agentKey);
   }

   /**
    * Retrieve all existing com.wings.web.struts.AgentForm objects.
    *
    * @exception   Exception   If the com.wings.web.struts.AgentForm objects cannot be retrieved.
    */
   public static List findAll (AgentForm agentForm) throws Exception {
      List retVals = new ArrayList();
      Agents agent = new Agents();      
      BeanUtils.copyProperties(agent, agentForm);
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);    
      retVals = agentsDAO.selectAll(agent);
      return retVals;
   }

   public static List findByName (String name) throws Exception {
      List retVals = new ArrayList();
      Agents agent = new Agents();
      agent.setName(name);
      AgentsDAO agentsDAO;
      DaoManager daoMgr = DaoConfig.getDaoManager();   
      agentsDAO = (AgentsDAO)daoMgr.getDao(AgentsDAO.class);    
      retVals = agentsDAO.selectByName(agent);
      return retVals;
   }
   
   public static List select (AgentForm agentForm) throws Exception {
      List retVals = new ArrayList();
      
      return retVals;
   }

}
