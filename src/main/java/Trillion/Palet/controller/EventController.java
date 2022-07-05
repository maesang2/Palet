package Trillion.Palet.controller;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Trillion.Palet.DTO.DrawingDTO;
import Trillion.Palet.service.EventService;


@Controller
@RequestMapping("/event/")
public class EventController {
	
	@Autowired
	private EventService eServ;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("participation")
	public String participation(Model model) {
		String realpath = "/event/event/"; 
		model.addAttribute("realpath",realpath);
		List<DrawingDTO> list = eServ.selectImage();
		model.addAttribute("list", list);
		/*
		 * Iterator<Map<String,Object>> resultMap =
		 * 
		 * byte[] arr = (byte[]) resultMap.get("base64"); String base64ToString = new
		 * String(arr);
		 * 
		 * model.addAttribute("imgSrc",base64ToString);
		 */
	    
	    
	  
	    
		
		return "/event/event";
	}
	
	
	
	@RequestMapping("paint")
	public String paint() {
		return "/event/paint";
	}
	
	@ResponseBody
	@RequestMapping("send")
	public String send(DrawingDTO dto, MultipartFile file) throws Exception{
		//String email = (String)session.getAttribute("loginEmail");
		String email="123";

		dto.setEmail(email);
		
		String fileName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		
		System.out.println(fileName);
		System.out.println(file);
		System.out.println(bytes);
		
		// 게시물을 등록한 적이 있을 때
		/*
		 * if(eServ.isEmailExist(email)) { return "false"; }
		 */
		
		//String realPath = session.getServletContext().getRealPath("uplaod");
		//eServ.add(dto, fileName, file);
		return "true";
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
