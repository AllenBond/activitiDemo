package com.allen.activiti.introdution;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * 通过 act_ru_excution表中需要的businessKey存入业务的ID
 * @author allen
 * @date 2020/7/16 20:09
 */

public class ActivitiDeployment05 {

   public static void businessKeyAdd(){
       ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

       RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

       //启动流程实例，同事还要指定业务表示businessKey 它本身就是请假单的ID
       //第一个参数指定流程定义key 第二个参数指定业务表示businessKey
       ProcessInstance myProcess_1 = runtimeService.startProcessInstanceByKey("myProcess_1", "1001");

       System.out.println(myProcess_1.getBusinessKey());
   }

    public static void main(String[] args) {
        businessKeyAdd();
    }

}
