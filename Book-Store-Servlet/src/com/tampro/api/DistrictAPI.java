package com.tampro.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tampro.model.District;
import com.tampro.service.DistrictService;
import com.tampro.service.ProvinceService;
import com.tampro.service.WardService;
import com.tampro.service.impl.DistrictServiceImpl;
import com.tampro.service.impl.ProvinceServiceImpl;
import com.tampro.service.impl.WardServiceImpl;

@WebServlet("/api/district")
public class DistrictAPI  extends HttpServlet{

	ProvinceService provinceService = new ProvinceServiceImpl();
	DistrictService districtService = new DistrictServiceImpl();
	WardService wardService = new WardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");		
		int id = Integer.parseInt(request.getParameter("id"));
		Gson gson = new Gson();
		PrintWriter writer  = response.getWriter();
		List<District> listDistrict = districtService.getAllByIdProvince(id);
		writer.println(gson.toJson(listDistrict));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
