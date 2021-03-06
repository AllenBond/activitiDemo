package com.allen.activiti.advanced;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author allen
 * @title: AssigneeUEL
 * @projectName activitiDemo
 * @description: 第二种方式动态设置assignee（第一种方式是用固定的用户名称进行指定）
 * @date 2020/7/1715:49
 */
public class AssigneeUEL {


    public static void main(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();

        //设置assignee的取值
        Map<String,Object> map= new HashMap<String, Object>();
        map.put("assignee0","张三");
        map.put("assignee1","李四");
        map.put("assignee2","王五");

        //启动流程实例
        runtimeService.startProcessInstanceById("myProcess_1:2:17503",map);

        //输出
        System.out.println(defaultProcessEngine.getName());
    }

//    第三中方式：使用监听器进行分配assignee
    //1。创建一个实现了TaskListener的类
    //2。在创建bpmn文件时，配置我们的Listener。然后添加Class选定刚才TaskListener的实现类

}
