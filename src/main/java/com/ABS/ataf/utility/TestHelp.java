package com.ABS.ataf.utility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHelp {
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}

	@BeforeMethod
	public void beforemethod1() {
		System.out.println("Before method 1");
	}
	
	@BeforeMethod
	public void beforemethod2() {
		System.out.println("Before method 2");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class");
	}

}
