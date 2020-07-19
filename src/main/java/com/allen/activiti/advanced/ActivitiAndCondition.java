package com.allen.activiti.advanced;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class ActivitiAndCondition {

    /**
     * 创建新的部署流程，发布
     */
    public static void publishProcess(){
        //1.定义创建流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.定义repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/hoilday3.bpmn").name("请假流程-流程变量").deploy();


        System.out.println(deploy.getId());
        System.out.println(deploy.getName());

    }

    public static void b(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        String key = "myProcess_1";
        Map<String,Object> map = new HashMap<String, Object>();

        Holiday holiday = new Holiday();
        holiday.setNum(5);
        map.put("holiday",holiday);

        //启动流程实例，并且设置流程变量的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);

        //输出实例信息
        System.out.println(processEngine.getName());
        System.out.println(processEngine.getProcessEngineConfiguration());
    }

    public static void finishTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        String key = "myProcess_1";
        Task task = taskService.createTaskQuery().processDefinitionId(key)
                .taskAssignee("").singleResult();

        if (task!=null){
            taskService.complete(task.getId());
            System.out.println("任务执行完成");
        }

    }

    public static void main(String[] args) {
        //发布部署流程
        publishProcess();
        b();
        finishTask();
    }

}
