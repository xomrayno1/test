package com.tampro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tampro.model.Address;
import com.tampro.model.District;
import com.tampro.model.Province;
import com.tampro.model.Ward;
import com.tampro.service.AddressService;
import com.tampro.service.DistrictService;
import com.tampro.service.ProvinceService;
import com.tampro.service.WardService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.service.impl.DistrictServiceImpl;
import com.tampro.service.impl.ProvinceServiceImpl;
import com.tampro.service.impl.WardServiceImpl;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADDRESS_EDIT)
public class UserEditAddressServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	AddressService addressService = new AddressServiceImpl();
	ProvinceService provinceService = new ProvinceServiceImpl();
	DistrictService districtService = new DistrictServiceImpl();
	WardService wardService = new WardServiceImpl();
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Address  address= addressService.getAddressById(id);
		request.setAttribute("address", address);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/editaddress.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Address address = addressService.getAddressById(id);
		Address addressDefault = addressService.getAddressDefaultByIdUser(address.getUsers_Id());	
		
		Province province = provinceService.getProvinceById(Integer.parseInt(request.getParameter("province")));
		District district  = districtService.getDistrictById(Integer.parseInt(request.getParameter("district")));
		Ward ward = wardService.getWardById(Integer.parseInt(request.getParameter("ward")));
		
		address.setName(request.getParameter("name"));
		address.setPhone(request.getParameter("phone"));
		address.setProvince(province);
		address.setDistrict(district);
		address.setWard(ward);
		address.setDescription(request.getParameter("description"));
				
		if(request.getParameter("status") != null) {
			int status = Integer.parseInt(request.getParameter("status"));
			address.setStatus(status);
			if(addressDefault != null) {
				addressDefault.setStatus(0);
				addressService.updateAddress(addressDefault);
			}
		}
		addressService.updateAddress(address);
		response.sendRedirect(request.getContextPath() + PathRequest.ADDRESS_USER);
	}

}