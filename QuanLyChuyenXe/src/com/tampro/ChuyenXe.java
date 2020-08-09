package com.tampro;

import java.util.Scanner;

public class ChuyenXe {
	/*
	 * Mục đích : Lớp Cha quản lý chuyến xe.
	 * Ngày tạo : 25/06/2019
	 * Version : 1.0
	 * Người tạo : Nguyễn Chí Tâm
	 * */
	//1.Attributes
	protected String maSoChuyen ; 
	protected String hoTenTaiXe ; 
	protected String soXe ; 
	protected float doanhThu ; 
	//2.Constructors methods
	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, float doanhThu) {
		this.maSoChuyen = maSoChuyen;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	public ChuyenXe() {
	
		
	}
	//3. Get,set methods
	public String getMaSoChuyen() {
		return maSoChuyen;
	}
	public void setMaSoChuyen(String maSoChuyen) {
		this.maSoChuyen = maSoChuyen;
	}
	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}
	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}
	public float getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(float doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	//4. Input,output methods

	public void nhap(Scanner sc) {
		System.out.println("Nhập mã số chuyến \t");
		this.maSoChuyen = sc.nextLine();
		System.out.println("Nhập họ tên tài xế \t");
		this.hoTenTaiXe = sc.nextLine();
		System.out.println("Nhập số xe \t");
		this.soXe = sc.nextLine();
		System.out.println("Nhập doanh thu \t");
		this.doanhThu = Float.parseFloat(sc.nextLine());
	}
	public void xuat() {
		System.out.print("\t [Mã số chuyến ] : "+this.maSoChuyen
				+"\t [Họ tên tài xế ] : "+this.hoTenTaiXe
				+"\t [Số xe ] : "+this.soXe
				+"\t [Doanh thu ] : "+this.doanhThu);
	}
	//5. Business methods
	

	
	
	
	
	
}
