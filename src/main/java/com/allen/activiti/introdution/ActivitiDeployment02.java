package com.allen.activiti.introdution;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author allen
 * @title: ActivitiDeployment02
 * @projectName activitiDemo
 * @description: TODO
 * @date 2020/7/1619:44
 */
public class ActivitiDeployment02 {

    /**
     * 查询流程定义信息
     * @return
     * @param
     * @author allen
     * @date 2020/7/16 19:45
     */

    public static void queryProcessDefinition(){
        //1.获得ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.得到ProcessDefinitionQuery
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //4.设置条件，并查询出当前的所有流程定义.查询条件：流程定义的Key:myProcess_1
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("myProcess_1")
                .orderByProcessDefinitionVersion().desc().list();


        //5.输出流程定义信息
        for (ProcessDefinition processDefinition:list){
            System.out.println("流程定义ID:"+processDefinition.getId());
            System.out.println("流程定义名称："+processDefinition.getName());
            System.out.println("流程定义Key:"+processDefinition.getKey());
            System.out.println("流程定义版本:"+processDefinition.getVersion());
            System.out.println("流程定义部署的ID:"+processDefinition.getDeploymentId());
        }

    }


    public static void deleteProcessDefinition(){
        //1.获得ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.执行删除流程:
        //当我们正在执行的这一套流程没有完全审批结束，此时如果要删除定义信息就会失败。
        //如果需要强制删除，则使用deleteDeployment("id",true);进行强制删除
        repositoryService.deleteDeployment("7501");


    }

    public static void main(String[] args) {
//        queryProcessDefinition();
        deleteProcessDefinition();
    }

}
