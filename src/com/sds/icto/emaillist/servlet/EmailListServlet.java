package com.sds.icto.emaillist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.emaillist.action.ActionFactory;
import com.sds.icto.emaillist.action.formAction;
import com.sds.icto.emaillist.action.indexAction;
import com.sds.icto.emaillist.action.insertAction;
import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/EL")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{	
			request.setCharacterEncoding( "utf-8" );
			
			String a = request.getParameter( "a" );

			ActionFactory af = ActionFactory.getInstance();	
			Action action = af.getAction( a );
			
			action.execute(request, response);	

			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		
	}

}
