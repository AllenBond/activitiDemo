package com.allen.activiti.introdution;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author allen
 * @title: ActivitiDeployment
 * @projectName activitiDemo
 * @description: TODO
 * @date 2020/7/1615:44
 */
public class ActivitiDeployment {

    public static void activitidep(){
        //创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday2.bpmn")
                .name("请假流程")
                .deploy();
        //输出
        System.out.println(deployment.getName());
        System.out.println(deployment.getTenantId());
        System.out.println(deployment.getId());
//        影响表
//        act_ge_bytearray
//        act_re_deployment
//        act_re_procdef
    }

    /**
     * TODO
     * @return
     * @param
     * @author allen
     * @date 2020/7/16 15:58
     * @deprecated 流程实例的启动
     */

    public static void startProcessInstance(){
        //创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");
        //输出示例的信息
        System.out.println("流程部署ID:"+processInstance.getDeploymentId());
        System.out.println("流程定义ID:"+processInstance.getProcessDefinitionId());
        System.out.println("流程示例ID:"+processInstance.getId());
        System.out.println("活动ID:"+processInstance.getActivityId());
        //act_hi_actinst    已完成的活动信息
        //act_hi_identitylink   参与者信息
        //act_hi_procinst   流程实例
        //act_hi_taskinst   任务实例
        //act_ru_execution  执行表
        //act_ru_identitylink  参与者信息
        //act_ru_task 任务
    }

    public static void findPeronalTaskList(){
        //得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //根据流程定义的Key,负责人assignee来实现当前用户的任务列表查询
        List<Task> list = taskService.createTaskQuery().processDefinitionKey("myProcess_1").taskAssignee("zhangsan").list();
        //任务列表显示
        for (Task task :list){
            System.out.println(task.getProcessDefinitionId());
            System.out.println(task.getId());
            System.out.println(task.getAssignee());
            System.out.println(task.getName());
        }
    }

    public static void complateTask(){
        //得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //处理任务，结合当前用户任务列表的查询操作.任务ID,task.getId()
        taskService.complete("10005");


    }

    public static void main(String[] args) {
        activitidep();
//        startProcessInstance();
//        findPeronalTaskList();
//        complateTask();
    }

}
