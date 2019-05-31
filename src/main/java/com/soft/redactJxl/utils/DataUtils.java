package com.soft.redactJxl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 进行数据的初始化处理
 * @ClassName:  DataUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: tao wang 
 * @date:   2018年10月25日 上午11:06:12   
 *
 */
public class DataUtils {
	/**
	 * 计算多个随机数加起来等于某一个限定的值
	 * @Title: getMathSum   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param num 随机数个数
	 * @return   返回拿到的随机数据
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	public static List<Integer> getMathSum(int num,int sum){
		List<Integer> array = new ArrayList<Integer>();
		int Max=40,Min=10;
		//进行随机数求取
		int count = 0;
		for (int i = 0; i < num; i++) {
			int a = (int)Math.round(Math.random()*(Max-Min)+Min);
			count = count +a;
			array.add(a);
		}
		if(count == sum) {
			return array;
		}
		return getMathSum(num,sum);
	}

	/**
	 * 取小于第一个数值的数据
	 * @Title: getBigNumMap   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param bigNum  整数集合
	 * @param max 最大比例范围
	 * @param min 最小比例范围
	 * @param divisor 除数
	 * @return      
	 * @date: 2018年10月25日 
	 * @author: tao wang      
	 * @throws
	 */
	public static List<Map<String,String>> getBigNumMap(List<Integer> numArray,int max,int min,List<Map<String,String>> listMap, int divisor){
		//保存两个数的map
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		int randMin=10;
		int count = 0;//数的合计
		for (int i = 0; i < numArray.size(); i++) {
			Integer bigNum = numArray.get(i);
			int a = (int)Math.round(Math.random()*(bigNum-randMin)+randMin);
			while (a > bigNum) {
				a = (int)Math.round(Math.random()*(bigNum-randMin)+randMin);
			}
			count = count + a;
			Map<String,String> map = new HashMap<String,String>();
			map.put("bigNum", bigNum + "");
			map.put("num",a + "");
			mapList.add(map);
		}
		if(min < (count * divisor )/100 &&  (count * divisor)/100 < max) {
			//两个map做汇总
			List<Map<String,String>> mapArray = new ArrayList<Map<String,String>>();
			for (int i = 0; i < listMap.size(); i++) {
				Map<String,String> mapA = listMap.get(i);
				Map<String,String> mapB = mapList.get(i);
				mapA.putAll(mapB);
				mapArray.add(mapA);
			}
			return mapArray;
		}
		return getBigNumMap(numArray,max,min,listMap,divisor);
	}

	
	public static void main(String[] args) {

		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("name", "测试1.." + i);
			mapList.add(map);
		}
		List<Integer> sumArra = getMathSum(4, 100);
		System.out.println("== "  + sumArra.toString());
		List<Map<String,String>> big = getBigNumMap(sumArra, 60, 50,mapList,60);
		System.out.println(big.toString());

	}
}
