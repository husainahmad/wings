package com.wings.dao;

import com.wings.persistence.AgentsKey;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.wings.persistence.Agents;
import java.util.List;

public class AgentsDAOImpl extends SqlMapDaoTemplate implements AgentsDAO {

   
    public AgentsDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

   
    public void insert(Agents record) {
        insert("agents_insert", record);
    }

   
    public int updateByPrimaryKey(Agents record) {
        int rows = update("agents_updateByPrimaryKey", record);

        return rows;
    }
   
    
    public Agents selectByPrimaryKey(AgentsKey key) {
        Agents record = (Agents) queryForObject("agents_selectByPrimaryKey", key);

        return record;
    }   

    
    public int deleteByPrimaryKey(AgentsKey key) {
        int rows = delete("agents_deleteByPrimaryKey", key);

        return rows;
    }

    public List selectAll(Agents agent) {
        List records = (List) queryForList("agents_selectAll", agent);

        return records;
    }

    public List selectByName(Agents record) {
        List records = (List) queryForList("agents_selectByName", record);

        return records;
    }

}
