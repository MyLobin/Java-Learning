package com.lobin.activitiDemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class LeaveProcessTest {
	@Test
	public void testStartProcess() {
		// create process engine
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
				.buildProcessEngine();
		// deploy process definition file
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("processes/leave.bpmn").deploy();
		// get process definition
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
		assertEquals("leave", processDefinition.getKey());
		// start process instance
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// prepare variable
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("applyUser", "lobin");
		variables.put("days", 3);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", variables);
		assertNotNull(processInstance);
		System.out.println("id:" + processInstance.getId() + " name:" + processInstance.getName());
		// get task
		TaskService taskService = processEngine.getTaskService();
		Task taskOfDeptLeader = taskService.createTaskQuery().taskCandidateGroup("deptLeader").singleResult();
		assertNotNull(taskOfDeptLeader);
		System.out.println("Leader:" + taskOfDeptLeader.getName());
		// claim task
		taskService.claim(taskOfDeptLeader.getId(), "leaderUser");
		variables.put("approved", true);
		// complete task
		taskService.complete(taskOfDeptLeader.getId(), variables);
		// query the task again
		taskOfDeptLeader = taskService.createTaskQuery().taskCandidateGroup("deptLeader").singleResult();
		assertNull(taskOfDeptLeader);
		// query the task from history
		HistoryService historyService = processEngine.getHistoryService();
		long count = historyService.createHistoricProcessInstanceQuery().finished().count();
		assertEquals(1,count);
		System.out.println("number of finished task:"+count);

	}
}
