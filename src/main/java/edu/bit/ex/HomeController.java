package edu.bit.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.ex.vo.JSONTest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * @RequestMapping(value = "/autocomplete") public Map<String, Object>
	 * autocomplete(Model model) {
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */
	
	@RequestMapping(value="/jsonTest") 
	@ResponseBody
	public  JSONTest jsonTest() {
		//가상의 배열및 리스트에 데이터 add 
		ArrayList<String> arraylist = new ArrayList<String>(); 
		arraylist.add("a"); 
		arraylist.add("b"); 
		String[] array = {"a","b","c"}; 
		//VO객체에 SET한후 vo객체자체를 return 
		JSONTest test = new JSONTest(); 
		test.setId(1); 
		test.setTxt("textTxt"); 
		test.setList(arraylist); 
		test.setArr(array); 
		return test; 
	}
	
	@ResponseBody
	@RequestMapping(value="/json03")
	public  List<String> json03() {
		System.out.println("json03");
		//가상의 배열및 리스트에 데이터 add 
		ArrayList<String> arraylist = new ArrayList<String>(); 
		arraylist.add("abc"); 
		arraylist.add("cde"); 
		
		return arraylist; 
	}
}




