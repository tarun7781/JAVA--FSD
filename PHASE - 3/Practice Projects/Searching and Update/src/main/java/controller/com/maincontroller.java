package controller.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import dao.com.eproductDao;
import entity.com.eproductEntity;
import org.apache.log4j.Logger;

@Controller
public class maincontroller {

	@Autowired
	eproductDao dao;
	

	private Logger logger = Logger.getLogger(maincontroller.class);

	@GetMapping("/productid")
	public String getProduct(HttpServletRequest request, ModelMap map, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		if (id > 0) {
			eproductEntity entity = dao.getProductById(id);

			logger.info("This Is An Info Log Entry ......!");
			logger.info(entity);
			map.addAttribute("obj", entity);
			return "details";
		} else {
			try {
				try {
					request.getRequestDispatcher("/index.jsp").include(request, response);
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("Oops!!Invalid Credentials:)");

				} catch (ServletException e) {
					e.printStackTrace();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@GetMapping("/update")
	public String updateProduct(HttpServletRequest request, ModelMap map) {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		{
			eproductEntity entity = new eproductEntity();
			entity.setId(id);
			entity.setName(name);
			entity.setPrice(price);
			dao.updateProduct(entity);
			map.addAttribute("obj", entity);
			return "details";
		}
	}
}
