package com.soft.redactJxl.versions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * poi 文档的版本方法
 * @ClassName:  WorkbokVersons   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: tao wang 
 * @date:   2018年10月25日 上午10:35:51   
 *
 */
public class WorkbookVersons {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	
	/**
	 * 
	 * @Title: getWorkbok   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param file 文档目录
	 * @return      
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	
	public static Workbook getWorkbok(File file){
		Workbook wb = null;
		try {
			FileInputStream in;
			in = new FileInputStream(file);
			if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
				wb = new HSSFWorkbook(in);
			}else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
				wb = new XSSFWorkbook(in);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb;
	}
}
