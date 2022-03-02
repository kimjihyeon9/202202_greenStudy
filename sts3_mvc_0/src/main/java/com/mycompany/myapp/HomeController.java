package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.saram.SaramDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// views 페이지 설정
		// /WEB-INF/spring/appServlet/servlet-context.xml
		return "home"; // /WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value="/profile")
	public String profile(Model model) {
		model.addAttribute("user_name", "홍길동");
		model.addAttribute("saram_dto", new SaramDto("HONG","홍길동","hong@a.com"));
		return "profile";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		ArrayList<SaramDto> saramList = new ArrayList();
		saramList.add(new SaramDto("KIM", "김길동", "kim@a.com"));
		saramList.add(new SaramDto("LEE", "이길동", "lee@a.com"));
		saramList.add(new SaramDto("PARK", "박길동", "park@a.com"));
		model.addAttribute("user_list", saramList);
		return "list";
	}
	
}
