package com.allen.activiti.introdution;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * TODO
 * @author allen
 * @date 2020/7/16 20:09
 */

public class ActivitiDeployment04 {

    public static void historyQuery(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        HistoryService historyService = processEngine.getHistoryService();

        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        historicActivityInstanceQuery.processInstanceId("10001");

        List<HistoricActivityInstance> list = historicActivityInstanceQuery.list();

        for (HistoricActivityInstance activityInstance: list){
            System.out.println(activityInstance.getActivityId());
            System.out.println(activityInstance.getActivityName());
            System.out.println(activityInstance.getProcessDefinitionId());
            System.out.println(activityInstance.getProcessInstanceId());
            System.out.println("============================");
        }
    }

    public static void main(String[] args) {
        historyQuery();
    }

}
