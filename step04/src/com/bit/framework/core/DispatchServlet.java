package com.bit.framework.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.framework.Controller;

public class DispatchServlet extends HttpServlet {
	Map<String,Controller> map=new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		File f=new File("./");
		try {
			System.out.println(f.getCanonicalPath());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream("bit.properties");
			prop.load(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set keys=prop.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			String url= ite.next();
			String info= prop.getProperty(url);
			try {
				Class clazz=Class.forName(info);
				Controller controller = (Controller) clazz.newInstance();
				map.put(url, controller);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req, resp);
	}
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		
		Controller controller=map.get(uri);
		
		String path="";
		try {
			path = controller.execute(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		
		if(path.startsWith("redirect:"))
			resp.sendRedirect(
					path.substring("redirect:".length()));
		else 
			req
				.getRequestDispatcher(prefix+path+suffix)
				.forward(req, resp);
	}
}







