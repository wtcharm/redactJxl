package com.soft.redactJxl.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.soft.redactJxl.exception.WriteExcelException;
import com.soft.redactJxl.utils.DataUtils;
import com.soft.redactJxl.versions.WorkbookVersons;


public class WriteExcel {

	/**
	 * 进行数据的写入操作
	 * @Title: writeExcel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param list 个人工作内容
	 * @param cloumnCount 个人工作内容数据个数
	 * @param finalXlsxPath   文档路径
	 * @param teams 	团队合作模块
	 * @param attitude  工作态度模块
	 * @param capacity  工作能力模块
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */

	public static void writeExcel(List<Map<String,String>> list, int cloumnCount,String finalXlsxPath,List<Map<String, String>> teams,List<Map<String, String>> attitude,List<Map<String, String>> capacity){
		OutputStream out = null;
		try {

			if(list.size() != 4 || teams.size() != 4 || attitude.size() !=5 || capacity.size() !=4) {
				System.out.println("=====================");
				throw new WriteExcelException(200,"数据个数不对");
			}

			// 获取总列数
			int columnNumCount = cloumnCount;
			// 读取Excel文档
			File finalXlsxFile = new File(finalXlsxPath);
			//进行文档版本判定
			Workbook workBook = WorkbookVersons.getWorkbok(finalXlsxFile);
			// sheet 对应一个工作页
			Sheet sheet = workBook.getSheetAt(0);

			out =  new FileOutputStream(finalXlsxPath);
			workBook.write(out);
			//人员数据
			boolean acieverment = updateAchievement(list, sheet, columnNumCount);
			System.out.println("人员数据 :" + acieverment);
			//团队数据
			boolean team = updateTeamContent(teams, sheet, 4);
			System.out.println("团队数据 :" + team);
			//工作态度
			boolean att = updateAttitudeContent(attitude, sheet, 5);
			System.out.println("工作态度 :" + att);
			//个人能力
			boolean ca = updateCapacityContent(capacity, sheet, 4);
			System.out.println("个人能力 :" + ca);
			// 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
			out =  new FileOutputStream(finalXlsxPath);
			workBook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(out != null){
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("数据导出成功");
	}

	/**
	 * 进行工作成果数据修改
	 * @Title: createAchievement   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param list 数据内容
	 * @param sheet 工作表
	 * @param columnNumCount 填写的数量
	 * @return     添加完成返回true 否则返回false
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */

	public static boolean updateAchievement(List<Map<String,String>> listMap, Sheet sheet,int columnNumCount) {
		//得到权重的随机数 
		List<Integer> numArray = DataUtils.getMathSum(columnNumCount, 100);
		//最终的结果集合
		List<Map<String,String>> list = DataUtils.getBigNumMap(numArray, 55, 48, listMap,60);
		for (int j = 0; j < list.size(); j++) {
			// 从第四行开始创建数据
			Row row = sheet.getRow( j+3);//行
			// 得到要插入的每一条记录
			Map<String,String> dataMap = list.get(j);
			String index = dataMap.get("index");//指标
			String describe = dataMap.get("describe");//自评描述
			String bigNum = dataMap.get("bigNum");//权重
			String num = dataMap.get("num");//分值
			for (int k = 0; k <= columnNumCount; k++) {
				// 在一行内循环
				Cell two = row.getCell(1);
				two.setCellValue(index);

				Cell first = row.getCell(2);
				first.setCellValue(Double.parseDouble(bigNum));

				Cell second = row.getCell(3);
				second.setCellValue(Double.parseDouble(num));

				Cell third = row.getCell(4);
				third.setCellValue(describe);
			}
		}
		return true;
	}

	/**
	 * 团队分析数据计算
	 * @Title: updateTeamContent   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param teams 自我评价数据
	 * @param sheet 文档操作
	 * @param columnNumCount 操作个数 4
	 * @return      
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	public static boolean updateTeamContent(List<Map<String,String>> teams ,Sheet sheet,int columnNumCount) {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		numArray.add(30);
		numArray.add(30);
		numArray.add(30);
		numArray.add(10);
		List<Map<String,String>> list = DataUtils.getBigNumMap(numArray, 12, 9, teams,15);
		for (int j = 0; j < list.size(); j++) {
			// 从第四行开始创建数据
			Row row = sheet.getRow( j+7);//行
			// 得到要插入的每一条记录
			Map<String,String> dataMap = list.get(j);
			String describe = dataMap.get("describe");//自评描述
			String num = dataMap.get("num");//分值
			for (int k = 0; k <= columnNumCount; k++) {
				// 在一行内循环
				Cell second = row.getCell(3);
				second.setCellValue(Double.parseDouble(num));
				Cell third = row.getCell(4);
				third.setCellValue(describe);
			}
		}
		return true;
	}

	/**
	 *  工作态度接口
	 * @Title: updateAttitudeContent   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param attitude   自我评价数据
	 * @param sheet  文档操作
	 * @param columnNumCount 操作个数 5
	 * @return      
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	public static boolean updateAttitudeContent(List<Map<String,String>> attitude ,Sheet sheet,int columnNumCount) {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		numArray.add(5);
		numArray.add(5);
		numArray.add(50);
		numArray.add(30);
		numArray.add(10);
		List<Map<String,String>> list = DataUtils.getBigNumMap(numArray, 10, 8, attitude,10);
		for (int j = 0; j < list.size(); j++) {
			// 从第四行开始创建数据
			Row row = sheet.getRow( j+11);//行
			// 得到要插入的每一条记录
			Map<String,String> dataMap = list.get(j);
			String describe = dataMap.get("describe");//自评描述
			String num = dataMap.get("num");//分值
			for (int k = 0; k <= columnNumCount; k++) {
				// 在一行内循环
				Cell second = row.getCell(3);
				second.setCellValue(Double.parseDouble(num));
				Cell third = row.getCell(4);
				third.setCellValue(describe);
			}
		}
		return true;
	}

	/**
	 * 工作能力
	 * @Title: updateCapacityContent   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param capacity   能力描述
	 * @param sheet  	文档操作
	 * @param columnNumCount 操作个数 4
	 * @return      
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	public static boolean updateCapacityContent(List<Map<String,String>> capacity ,Sheet sheet,int columnNumCount) {
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		numArray.add(30);
		numArray.add(30);
		numArray.add(30);
		numArray.add(10);
		List<Map<String,String>> list = DataUtils.getBigNumMap(numArray, 14, 10, capacity,15);
		for (int j = 0; j < list.size(); j++) {
			// 从第四行开始创建数据
			Row row = sheet.getRow( j+16);//行
			// 得到要插入的每一条记录
			Map<String,String> dataMap = list.get(j);
			String describe = dataMap.get("describe");//自评描述
			String num = dataMap.get("num");//分值
			for (int k = 0; k <= columnNumCount; k++) {
				// 在一行内循环
				Cell second = row.getCell(3);
				second.setCellValue(Double.parseDouble(num));
				Cell third = row.getCell(4);
				third.setCellValue(describe);
			}
		}
		return true;
	}

}
