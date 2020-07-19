package com.allen.activiti.introdution;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 * @author allen
 * @date 2020/7/16 20:09
 */

public class ActivitiDeployment03 {

    public static void queryBpmnFile(){
        //获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //获取repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //获取ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //根据key查询出流程信息
        processDefinitionQuery.processDefinitionKey("myProcess_1");
        //将流程返回结果接收
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        //通过流程定义信息，得到部署ID
        String deploymentId = processDefinition.getDeploymentId();
        //通过RepositoryService的方法，实现读取图片信息以及bpmn文件信息
        //getResourceAsStram()方法的参数说明：第一个参数部署id，第二个参数代表资源名称
        //processDefinition.getDiagramResourceName()代表获取png图片资源的名称
        //processDefinition.getResourceName()代表bpmn文件的名称
//        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        //构建outputStream流
        try {
            FileOutputStream bpmnOs = new FileOutputStream("D:\\"+processDefinition.getResourceName());
            //输出输出流转换
            IOUtils.copy(bpmnIs,bpmnOs);
            bpmnOs.close();
            bpmnIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        queryBpmnFile();
    }

}
