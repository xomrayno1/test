package com.tampro.utils;

import java.util.UUID;

public class WebUtils {
	public static String makeId() {
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(makeId());
	}

}
