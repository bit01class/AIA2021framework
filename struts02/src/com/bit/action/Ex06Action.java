package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex06Action implements Action {
	String id;
	int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("id:"+id);
		if(age==0) return Action.INPUT;
		return Action.SUCCESS;
	}

}
