package com.tampro;

import java.util.Scanner;

public class ChuyenXeNoiThanh extends ChuyenXe{

	/*
	 * Ngày tạo : 25/06/2019
	 * Version : 1.0
	 * Người tạo : Nguyễn Chí Tâm
	 * */
	//1.Attributes
	private String soTuyen;
	private float soKm;
	//2.Constructors methods
	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, float doanhThu, String soTuyen,
			float soKm) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}
	public ChuyenXeNoiThanh() {
		super();
	}
	//3. Get,set methods
	public String getSoTuyen() {
		return soTuyen;
	}
	public void setSoTuyen(String soTuyen) {
		this.soTuyen = soTuyen;
	}
	public float getSoKm() {
		return soKm;
	}
	public void setSoKm(float soKm) {
		this.soKm = soKm;
	}
	
	//4. Input,output methods
	@Override
	public void nhap(Scanner sc) {
		// TODO Auto-generated method stub
		super.nhap(sc);
		System.out.println("Nhập số tuyến \t");
		this.soTuyen = sc.nextLine();
		System.out.println("Nhập số km \t");
		this.soKm = Float.parseFloat(sc.nextLine());
	}
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println("\t [Số tuyến ] : "+this.soTuyen
				+"\t [Số km ] :"+this.soKm);
	}
	//5. Business methods
}
