package com.tampro;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachChuyenXe {
	private ArrayList<ChuyenXe> listDsChuyenXe;
	private float tongDoanhThu;
	private float doanhThuNoi;
	private float doanhThuNgoai;
	
	

	
	public DanhSachChuyenXe(ArrayList<ChuyenXe> listDsChuyenXe) {
		
		this.listDsChuyenXe = listDsChuyenXe;
	}

	public DanhSachChuyenXe() {
		listDsChuyenXe = new ArrayList<ChuyenXe>();
		ChuyenXe cx = new ChuyenXeNoiThanh("123","Nguyễn A","78G1-321",1200,"13",5.4f);
		ChuyenXe cx1 = new ChuyenXeNoiThanh("321","Nguyễn B","78D1-321",1700,"11",9.4f);
		ChuyenXe cx2 = new ChuyenXeNoiThanh("456","Nguyễn C","78C1-321",1500,"12",7.4f);
		ChuyenXe nt = new ChuyenXeNgoaiThanh("001", "B Nguyễn", "77G1-21", 2000, "Bình Thuận",1);
		ChuyenXe nt2 = new ChuyenXeNgoaiThanh("002", "A Nguyễn", "77D1-211", 3000, "Quy Nhơn ",1.5f);
		ChuyenXe nt3 = new ChuyenXeNgoaiThanh("003", "C Nguyễn", "77DH1-211", 5000, "Bình Thuận",1.5f);
		listDsChuyenXe.add(cx);
		listDsChuyenXe.add(cx1);
		listDsChuyenXe.add(cx2);
		listDsChuyenXe.add(nt);
		listDsChuyenXe.add(nt2);
		listDsChuyenXe.add(nt3);
		
	}

	public float getTongDoanhThu() {
		return tongDoanhThu;
	}
	public float getDoanhThuNoi() {
		return doanhThuNoi;
	}
	public float getDoanhThuNgoai() {
		return doanhThuNgoai;
	}
	public ArrayList<ChuyenXe> getListDsChuyenXe() {
		return listDsChuyenXe;
	}

	public void setListDsChuyenXe(ArrayList<ChuyenXe> listDsChuyenXe) {
		this.listDsChuyenXe = listDsChuyenXe;
	}
	public void addChuyenXe(ChuyenXe cx) {
		listDsChuyenXe.add(cx);
	}
	public void xuat() {
		for(ChuyenXe items : listDsChuyenXe) {
			items.xuat();
			
		}
	}
	public void nhap(Scanner sc) {
		boolean flag = true;
		ChuyenXe cx;
		do {
			System.out.println("Nhâp 1 . Chuyến xe nội thành");
			System.out.println("Nhâp 2 . Chuyến xe ngoại thành");
			System.out.println("Nhập 3 . Xuất toàn bộ");
			System.out.println("Nhập 4 . Xuất toàn bộ doanh thu");
			System.out.println("Nhập 5 . Xuất doanh thu nội");
			System.out.println("Nhập 6 . Xuất doanh thu ngoại");
			System.out.println("Nhập 7 . Xuất doanh thu bình thuận");
			System.out.println("Nhâp 0 . Thoát nhập");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				cx = new ChuyenXeNoiThanh();
				cx.nhap(sc);
				addChuyenXe(cx);
				break;
			case 2:
				cx = new ChuyenXeNgoaiThanh();
				cx.nhap(sc);
				addChuyenXe(cx);
				break;
			case 3:
				xuat();
				break;
			case 4:
				tinhTongDoanhThu();
				System.out.println("Tổng doanh thu là : "+this.tongDoanhThu);
				break;
			case 5:
				tinhTongDoanhThuChuyenXeNoiThanh();
				System.out.println("Doanh thu nội là : "+this.doanhThuNoi);
				break;
			case 6:
				tinhTongDoanhThuChuyenXeNgoaiThanh();
				System.out.println("Doanh thu ngoại là : "+this.doanhThuNgoai);
				break;
			case 7:
				float doanThuBinhThuan = tinhTongDoanhThuChuyenXeNgoaiThanhBinhThuan();
				System.out.println("Doanh thu ngoại bình thuận là : "+doanThuBinhThuan);
				break;
			default:
				flag = false;
				break;
			}
			
			
		}while(flag);
	}
	
	public void tinhTongDoanhThu() {
		int tongDoanhThu = 0 ;
		for(ChuyenXe cx : listDsChuyenXe) {
			tongDoanhThu +=cx.doanhThu;
		}
		this.tongDoanhThu = tongDoanhThu;
	}
	public void tinhTongDoanhThuChuyenXeNoiThanh(){
		int tongDoanhThu = 0 ;
		for(ChuyenXe items : listDsChuyenXe) {
			if(items instanceof ChuyenXeNoiThanh) { // kiểm tra items có phải là instance của ChuyenXeNoiThanh hay không
				tongDoanhThu += items.doanhThu;
			}
		}
		this.doanhThuNoi = tongDoanhThu;
		
	}
	public void tinhTongDoanhThuChuyenXeNgoaiThanh(){
		int tongDoanhThu = 0 ;
		for(ChuyenXe items : listDsChuyenXe) {
			if(items instanceof ChuyenXeNgoaiThanh) {
				tongDoanhThu += items.doanhThu;
			}
		}
		this.doanhThuNgoai = tongDoanhThu;
	}
	// tính doanh thu các chuyến xe ngoại thành có nơi đến là bình thuận
	public float tinhTongDoanhThuChuyenXeNgoaiThanhBinhThuan(){
		float tongDoanhThu = 0 ;
		for(ChuyenXe items : listDsChuyenXe) {
			if(items instanceof ChuyenXeNgoaiThanh) {
				if(((ChuyenXeNgoaiThanh) items).getNoiDen().equalsIgnoreCase("Bình Thuận") ) { // Casting - ép kiểu trong đối tương 
					// ép cái items về đúng chuẩn ChuyenXeNgoaiThanh sau đó lấy ra nơi đến. 
					// nơi đến năm ở lớp con ko phải ở lớp cha , vì thế cần ép  về kiểu 
					
					tongDoanhThu += items.doanhThu;
				}
			}
		}
		return  tongDoanhThu;
	}
	
	

}
