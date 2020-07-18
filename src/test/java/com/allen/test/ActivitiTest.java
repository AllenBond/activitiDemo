package com.allen.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @author allen
 * @title: ActivitiTest
 * @projectName activitiDemo
 * @description: TODO
 * @date 2020/7/1611:52
 */
public class ActivitiTest {


    @Test
    public void testGenTable(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        System.out.println(processEngine);
    }

//    @Test
//    public void testGenTable(){
//        //1.创建一个ProcessEngineConfiguration对象,如果bean的名字不是processEngineConfiguration，需要用第二个参数指定Bean
//        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//        //2.创建ProcessEngine对象
//        ProcessEngine processEngine = configuration.buildProcessEngine();
//        //3.输出对象
//        System.out.println(processEngine);
//    }
}
