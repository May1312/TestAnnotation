package com.helian.spring.controller;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 8433492784887062947L;
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

}
