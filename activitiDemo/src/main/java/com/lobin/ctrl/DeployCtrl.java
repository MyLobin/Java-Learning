package com.lobin.ctrl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@CrossOrigin
@RestController
public class DeployCtrl {
	@Autowired
	RepositoryService repositoryService;

	@Autowired
	private ProcessEngine processEngine;

	@RequestMapping(value = "/test")
	public String test() {
		return "test";
	}

	/**
	 * 部署流程资源
	 */
	@RequestMapping(value = "/deploy")
	public String deploy(@RequestParam(value = "file", required = true) MultipartFile file) {
		System.out.println("deploy");
		// 获取上传的文件名
		String fileName = file.getOriginalFilename();

		try {
			// 得到输入流（字节流）对象
			InputStream fileInputStream = file.getInputStream();

			// 文件的扩展名
			String extension = FilenameUtils.getExtension(fileName);

			// zip或者bar类型的文件用ZipInputStream方式部署
			DeploymentBuilder deployment = repositoryService.createDeployment();
			if (extension.equals("zip") || extension.equals("bar")) {
				ZipInputStream zip = new ZipInputStream(fileInputStream);
				deployment.addZipInputStream(zip);
			} else {
				// 其他类型的文件直接部署
				deployment.addInputStream(fileName, fileInputStream);
			}
			deployment.deploy();
			System.out.println("the file name is:" + fileName);
		} catch (Exception e) {
			// logger.error("error on deploy process, because of file input
			// stream");
			return "error:" + e.toString();
		}

		return "redirect:process-list";
	}

	/**
	 * 流程定义列表
	 */
	@RequestMapping(value = "/list")
	public String processList() {

		List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().list();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		for (ProcessDefinition p : processDefinitionList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pName", p.getName());
			map.put("pId", p.getId());
			list.add(map);
		}
		System.out.println(list.size());
		Map<String, Object> mapRows = new HashMap<String, Object>();
		mapRows.put("rows", list);
		mapRows.put("total", 800);
		return JSON.toJSONString(mapRows);
	}
}
