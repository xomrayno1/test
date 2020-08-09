package com.tampro;

import java.util.Scanner;

public class ChuyenXeNgoaiThanh extends ChuyenXe {

	/*
	 * Ngày tạo : 25/06/2019
	 * Version : 1.0
	 * Người tạo : Nguyễn Chí Tâm
	 * */
	//1.Attributes
	private String noiDen;
	private float soNgayDiDuoc;
	//2.Constructors methods
	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, float doanhThu, String noiDen,
			float soNgayDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	public ChuyenXeNgoaiThanh() {
		super();
	}
	//3. Get,set methods
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public float getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	public void setSoNgayDiDuoc(float soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	//4. Input,output methods
	@Override
	public void nhap(Scanner sc) {
		// TODO Auto-generated method stub
		super.nhap(sc);
		System.out.println("Nhập nơi đến");
		this.noiDen = sc.nextLine();
		System.out.println("Nhập số ngày đi");
		this.soNgayDiDuoc = Float.parseFloat(sc.nextLine());
	}
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println("\t [Nơi đến ] : "+this.noiDen
				+"\t [Số ngày đi được ] : "+this.soNgayDiDuoc);
	}
	//5. Business methods
}
