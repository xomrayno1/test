package com.tampro;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		DanhSachChuyenXe ds = new DanhSachChuyenXe();
		ds.nhap(sc);
		ds.xuat();
	}
}
