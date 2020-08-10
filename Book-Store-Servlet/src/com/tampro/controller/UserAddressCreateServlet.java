package com.tampro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tampro.model.Address;
import com.tampro.model.District;
import com.tampro.model.Province;
import com.tampro.model.Users;
import com.tampro.model.Ward;
import com.tampro.service.AddressService;
import com.tampro.service.DistrictService;
import com.tampro.service.ProvinceService;
import com.tampro.service.WardService;
import com.tampro.service.impl.AddressServiceImpl;
import com.tampro.service.impl.DistrictServiceImpl;
import com.tampro.service.impl.ProvinceServiceImpl;
import com.tampro.service.impl.WardServiceImpl;
import com.tampro.utils.FormatUtils;
import com.tampro.utils.PathRequest;

@WebServlet(PathRequest.ADDRESS_CREATE)
public class UserAddressCreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AddressService addressService = new AddressServiceImpl();
	ProvinceService provinceService = new ProvinceServiceImpl();
	DistrictService districtService = new DistrictServiceImpl();
	WardService wardService = new WardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/createaddress.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		Address addressDefault = addressService.getAddressDefaultByIdUser(users.getId()); // tìm kiếm địa chỉ mặc định trong users

		Province province = provinceService.getProvinceById(Integer.parseInt(request.getParameter("province")));
		District district  = districtService.getDistrictById(Integer.parseInt(request.getParameter("district")));
		Ward ward = wardService.getWardById(Integer.parseInt(request.getParameter("ward")));
		String description = request.getParameter("description");
		String name = request.getParameter("name");		
		String phone = request.getParameter("phone");
		
		if(province == null || district == null || ward == null) {
			request.setAttribute("error", "Thêm Thất Bại");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/giaodien/user/createaddress.jsp");
			dispatcher.forward(request, response);			
		}
		else {			
			if(FormatUtils.formatAddress(name, phone, description)) {
				Address address = new Address();		
				address.setUsers_Id(users.getId());
				address.setName(name);
				address.setPhone(phone);
				address.setProvince(province);
				address.setDistrict(district);
				address.setWard(ward);
				address.setDescription(description);
				if (request.getParameter("status") != null) { 
					int status = Integer.parseInt(request.getParameter("status"));
					address.setStatus(status);  
					if (addressDefault != null) { 
						addressDefault.setStatus(0);
						addressService.updateAddress(addressDefault);
					} 
				}
				addressService.addAddress(address);
			}
			response.sendRedirect(request.getContextPath() + PathRequest.ADDRESS_USER);
		}		
	}
}
