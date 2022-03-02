package org.comstudy21.myapp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
   
   private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, UnsupportedEncodingException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html; charset=UTF-8");
      
//      System.out.println("process - DispatcherServlet");
//      System.out.println("METHOD : " + req.getMethod());
//      System.out.println("ctxPath : " + req.getContextPath());
//      System.out.println("컨텐트 형식 : " + req.getContentType());
//      System.out.println("reqUri : " + req.getRequestURI());
      
      String ctxPath = req.getContextPath();
      String reqUri = req.getRequestURI();
      int beginIndex = ctxPath.length();
      int endIndex = reqUri.lastIndexOf(".");
      String path = reqUri.substring(beginIndex, endIndex);
//      System.out.println("path => " + path);
      endIndex = path.lastIndexOf("/");
      String dirPath = endIndex == -1 ? "/home" : path.substring(1, endIndex);
//      System.out.println("dirPath => " + dirPath);
      
      String viewName = "/WEB-INF/views/";
      if("/home".equals(path)) {
    	  viewName += "home.jsp";
      } else if("/member/list".equals(path)) {
    	  viewName += "member/list.jsp";
      } else if("/board/list".equals(path)) {
    	  viewName += "board/list.jsp";
      }
   }

   // forward 하기
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("doGet - DispatcherServlet");
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("doPost - DispatcherServlet");
      process(req, resp);
   }

   @Override
   public void destroy() {
      System.out.println("destroy - DispatcherServlet");
   }

   @Override
   public void init() throws ServletException {
      System.out.println("init - DispatcherServlet");
   }

}