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

import com.cognizant.academy.bo.ObjectiveBo;

import com.cognizant.academy.model.Objective_model;

/**
 * Servlet implementation class ObjectiveController
 */
@WebServlet("/ObjectiveController")
public class ObjectiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObjectiveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("act").equals("showobj"))
		{
			showObjective(request,response);
		}
		else if(request.getParameter("act").equals("addobj"))
		{
			addObjective(request,response);
		}
		else if(request.getParameter("act").equals("rmvObj"))
		{
			removeObjective(request,response);
		}
		else if(request.getParameter("act").equals("updObj"))
		{
			updateObjective(request,response);
		}
			
	}
	
	
    protected void addObjective(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    System.out.println(request.getParameter("Name"));
	    System.out.println(request.getParameter("Description"));
	    System.out.println(request.getParameter("Level"));
	    Objective_model obj = new Objective_model();
	    obj.setName(request.getParameter("Name"));
	    obj.setLevel(request.getParameter("Level"));
	    obj.setDescription(request.getParameter("Description"));
	    ObjectiveBo bo = new ObjectiveBo();
	    int stack_id =Integer.parseInt(request.getParameter("param2")) ;
		bo.addObjective(obj,stack_id );
    	showObjective(request,response);
	}
	
    protected void updateObjective(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int id = Integer.parseInt(request.getParameter("id"));
		 String name,desc,level;
		 System.out.println(request.getParameter("name"));
		 System.out.println(request.getParameter("desc"));
		 System.out.println(request.getParameter("level"));
		 System.out.println(request.getParameter("obname"));
		 System.out.println(request.getParameter("obdesc"));
		 System.out.println(request.getParameter("oblevel"));
		 System.out.println(request.getParameter("param2"));
		 
		 if(request.getParameter("obname")=="")
			 name = request.getParameter("name");
		 else
			  name= request.getParameter("obname");
		 if(request.getParameter("obdesc")=="")
		 {
		    desc = request.getParameter("desc");
		 }
		 else
			 desc = request.getParameter("obdesc");
		 if(request.getParameter("oblevel")==null)
		    level = request.getParameter("level");
		 else
			 level = request.getParameter("oblevel");
		 
		 System.out.println(name+" "+desc+" "+" "+level+" "+id);
		 Objective_model ob = new Objective_model();
		 ob.setId(id);
        ob.setDescription(desc);
        ob.setLevel(level);
        ob.setName(name);
       
		ObjectiveBo bo = new ObjectiveBo();
		bo.updateObjective(ob);
		showObjective(request,response);
	}
     
    protected void removeObjective(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Objective_model objm = new Objective_model();
		objm.setId(Integer.parseInt(request.getParameter("id")));
		
    	ObjectiveBo bo = new ObjectiveBo();
    	bo.removeObjective(objm);
    	
		showObjective(request,response);
	}
    protected void showObjective(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<Objective_model> obl = new ArrayList<Objective_model>();
		int stack_id = Integer.parseInt(request.getParameter("param2"));
		ObjectiveBo bo = new ObjectiveBo();
		obl = bo.showObjective(stack_id);
		System.out.println(obl.size()+"  obj");
    	request.setAttribute("list",obl);
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/jsp/Objective.jsp");
		rd.forward(request, response);
	}

}
