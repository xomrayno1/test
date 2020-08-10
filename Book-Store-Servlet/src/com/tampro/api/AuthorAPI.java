package com.tampro.api;

import java.util.regex.Pattern;

public class AuthorAPI {

	public static void main(String[] args) {
		boolean check = Pattern.matches("[^a-z]", "adsada");
		System.out.println(check);
	}
}
