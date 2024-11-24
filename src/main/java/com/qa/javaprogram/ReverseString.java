package com.qa.javaprogram;

public class ReverseString {

	public void reverse(String data) {
		StringBuilder str= new StringBuilder(data).reverse();
	System.out.println(str);
	}
	
	public void main(String[] args) {
		reverse("Automation");
	}
}
