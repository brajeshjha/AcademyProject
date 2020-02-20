package com.cognizant.academy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.academy.bo.StackBo;
import com.cognizant.academy.model.Stack_model;

/**
 * Servlet implementation class StackController
 */
@WebServlet("/StackController")
public class StackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   showStack(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 if(request.getParameter("act").equals("addStack"))
		 {
			 addStack(request,response);
		 }
		 else if(request.getParameter("act").equals("rmvStack"))
		 {
			 removeStack(request,response);
		 }
		 else if(request.getParameter("act").equals("updStack"))
		 {
			 updateStack(request,response);
		 }
	}
	
	protected void addStack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  Stack_model s = new Stack_model();
		  s.setName(request.getParameter("name"));
		  StackBo bo= new StackBo();
		  bo.addStack(s);
		  showStack(request,response);
		
	}
	
    protected void updateStack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
		System.out.println(request.getParameter("param1"));
		System.out.println(request.getParameter("param2"));
		System.out.println(request.getParameter("sname"));
		Stack_model sm = new Stack_model();
		sm.setId(Integer.parseInt(request.getParameter("param2")));
		sm.setName(request.getParameter("sname"));
		
		StackBo bo = new StackBo();
		bo.updateStack(sm);
		showStack(request,response);
	}
     
    protected void removeStack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Stack_model sm = new Stack_model();
		
		sm.setId(Integer.parseInt(request.getParameter("param2")));
		StackBo bo = new StackBo();
		bo.removeStack(sm);
		showStack(request,response);
	}
    protected void showStack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Stack_model s = new Stack_model();
    	List<Stack_model> stack = new ArrayList<Stack_model>();
    	
    	StackBo bo= new StackBo();
    	stack = bo.showStack();
		request.setAttribute("List",stack);
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/jsp/Stack.jsp");
		rd.forward(request, response);
	}

}

