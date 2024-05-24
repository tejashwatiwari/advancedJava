package com.apex.BasicSpringProject.bean;

import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PersonSetterInjection {
	private String name;
	private int age;
	private String city;

	public String getName() {
		return name;
	}

	@Value("Tej")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Value("12")
	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	@Value("JSR")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("Entered into Init Method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Entered into Destroy Method");
	}

}
