package com.bit.sts07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	String path="D:\\stsWorkspace\\upload\\";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("upload form page ...");
		return "home";
	}
	
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String upload(MultipartFile file,Model model) {
		// originName, reName
		logger.debug(file.getOriginalFilename());
		logger.debug(file.getContentType());
		String fname=System.currentTimeMillis()+"@"+file.getOriginalFilename();
		File result=new File(path+fname);
		try {
			file.transferTo(result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("origin", file.getOriginalFilename());
		model.addAttribute("reName", fname);
		return "down";
	}
	@RequestMapping("/down")
	public void down(String rename,HttpServletResponse res) {
		logger.debug(rename);
		File file=new File(path+rename);
		String filename=rename.substring(rename.indexOf('@')+1);
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition"
				, "attachment; filename=\""+filename+"\"");
		try(
			OutputStream os = res.getOutputStream();
			InputStream is = new FileInputStream(file);
		) {
			int su=-1;
			while((su=is.read())!=-1) os.write(su);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}











