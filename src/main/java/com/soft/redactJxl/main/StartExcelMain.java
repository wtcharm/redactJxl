package com.soft.redactJxl.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soft.redactJxl.write.WriteExcel;

public class StartExcelMain {

	public static void main(String[] args) {
		Map<String,String> dataMap0=new HashMap<String,String>();
		dataMap0.put("index", "文件管理阿里以及内网代码的合并以及Apollo的配置"); //工作内容
		dataMap0.put("describe", "完成");//描述
		Map<String,String> dataMap1=new HashMap<String,String>();
		dataMap1.put("index","文件管理查询代办列表bug的修改");
		dataMap1.put("describe", "完成");
		Map<String,String> dataMap2=new HashMap<String,String>();
		dataMap2.put("index", "文件管理向mq发送消息失败问题的修改");
		dataMap2.put("describe", "完成");
		Map<String,String> dataMap3=new HashMap<String,String>();
		dataMap3.put("index", "文件管理统计接口代码的编写");
		dataMap3.put("describe", "完成");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list.add(dataMap0);
		list.add(dataMap1);
		list.add(dataMap2);
		list.add(dataMap3);
		//团队
		List<Map<String, String>> teams = new ArrayList<>();
		Map<String,String> teamMap0=new HashMap<String,String>();
		teamMap0.put("describe", "编写项目文档");//描述
		Map<String,String> teamMap1=new HashMap<String,String>();
		teamMap1.put("describe", "积极参与讨论");//描述
		Map<String,String> teamMap2=new HashMap<String,String>();
		teamMap2.put("describe", "积极参加日常知识讲座");//描述
		Map<String,String> teamMap3=new HashMap<String,String>();
		teamMap3.put("describe", "良好");//描述
		teams.add(teamMap0);
		teams.add(teamMap1);
		teams.add(teamMap2);
		teams.add(teamMap3);
		List<Map<String, String>> attitude = new ArrayList<>();
		Map<String,String> attitudeMap0=new HashMap<String,String>();
		attitudeMap0.put("describe", "良好");//描述
		Map<String,String> attitudeMap1=new HashMap<String,String>();
		attitudeMap1.put("describe", "尽快完成工作任务，加班");//描述
		Map<String,String> attitudeMap2=new HashMap<String,String>();
		attitudeMap2.put("describe", "积极完成工作任务");//描述
		Map<String,String> attitudeMap3=new HashMap<String,String>();
		attitudeMap3.put("describe", "能与同事配合融洽");//描述
		Map<String,String> attitudeMap4=new HashMap<String,String>();
		attitudeMap4.put("describe", "良好");//描述
		attitude.add(attitudeMap0);
		attitude.add(attitudeMap1);
		attitude.add(attitudeMap2);
		attitude.add(attitudeMap3);
		attitude.add(attitudeMap4);
		List<Map<String, String>> capacity = new ArrayList<>();
		Map<String,String> capacityMap0=new HashMap<String,String>();
		capacityMap0.put("describe", "沟通良好");//描述
		Map<String,String> capacityMap1=new HashMap<String,String>();
		capacityMap1.put("describe", "良好");//描述
		Map<String,String> capacityMap2=new HashMap<String,String>();
		capacityMap2.put("describe", "良好");//描述
		Map<String,String> capacityMap3=new HashMap<String,String>();
		capacityMap3.put("describe", "良好");//描述
		capacity.add(capacityMap0);
		capacity.add(capacityMap1);
		capacity.add(capacityMap2);
		capacity.add(capacityMap3);

		WriteExcel.writeExcel(list, list.size(), "E:/文档/test/王涛_2019年x月份绩效.xlsx",teams,attitude,capacity);


	}

}
