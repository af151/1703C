package com.zhaoao.test;



import java.util.HashMap;

import org.junit.Test;

import com.zhaoao.common.utils.AssertUtil;
import com.zhaoao.common.utils.Common;

public class AssertTest{
	@Test
	public void fun1Test(){
		try {
			AssertUtil.isTrue(false, "这不是一个True");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void fun2Test(){
		try {
			AssertUtil.isFalse(true, "这不是一个flase");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void fun3Test(){
		try {
			AssertUtil.notNull("aaa", "这是一个空");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void fun4Test(){
		try {
			AssertUtil.isNull("", "这不是一个空");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	/*@Test
	public void fun5Test(){
		try {	 
			Collection<Integer> coll = new Collection<Integer>();
			coll.add(66);
			AssertUtil.notEmpty(coll, "z这个集合是空");
		} catch (Common e) {
			e.printStackTrace();
		}
	} */
	@Test
	public void fun6Test(){
		try {	 
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			map.put("aa", 11);
			AssertUtil.notmEmpty(map , "这个集合为空");	
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void fun7Test(){
		try {	 
			AssertUtil.hasText(" ", "字符串必须有值");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void fun8Test(){
		try {	 
			AssertUtil.greaterThanZero(66, "这是一个正数");
		} catch (Common e) {
			e.printStackTrace();
		}
	} 
}
