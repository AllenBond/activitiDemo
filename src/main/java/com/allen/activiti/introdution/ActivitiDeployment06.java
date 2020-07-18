package com.allen.activiti.introdution;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 通过 act_ru_excution表中需要的businessKey存入业务的ID
 * @author allen
 * @date 2020/7/16 20:09
 */

public class ActivitiDeployment06 {

    /**
     * 挂起所有流程
     * @return
     * @param
     * @author allen
     * @date 2020/7/17 15:23
     */

   public static void SuspendProcessInstance(){
       ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

       RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();

       //查询流程实例
       ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("myProcess_1").singleResult();

       boolean suspended = processDefinition.isSuspended();
       System.out.println(suspended);
       if(suspended){
           //说明暂停，就可以激活操作
           repositoryService.activateProcessDefinitionById(processDefinition.getId(),true,null);
           System.out.println("流程激活");
       }else{
           //没有被暂停就挂起
           repositoryService.suspendProcessDefinitionById(processDefinition.getId(),true,null);
           System.out.println("流程挂起");
       }

   }

   /**
    * 单个实例挂起
    * @return
    * @param
    * @author allen
    * @date 2020/7/17 15:23
    */

    public static void SuspendProcessInstance2(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        //查询流程实例
        ProcessInstance myProcess_1 = runtimeService.createProcessInstanceQuery().processInstanceId("10001").singleResult();

        boolean suspended = myProcess_1.isSuspended();
        System.out.println(suspended);
        if(suspended){
            //说明暂停，就可以激活操作
            runtimeService.activateProcessInstanceById(myProcess_1.getId());
            System.out.println("流程激活");
        }else{
            //没有被暂停就挂起
            runtimeService.suspendProcessInstanceById(myProcess_1.getId());
            System.out.println("流程挂起");
        }

    }

    public static void main(String[] args) {
        SuspendProcessInstance2();
    }

}
