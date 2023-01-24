package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.authorize.DetailsAdder;
import com.authorize.MailChecker;


/**
 * Servlet implementation class getTableData
 */

@MultipartConfig
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Working ");
        RequestDispatcher rd = request.getRequestDispatcher("assets/html/register.html");
        rd.forward(request, response);

    }

    /**
     * @MultipartConfig
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String jsonString = request.getParameter("userData");
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jo = (JSONObject) obj;
            String email = (String) jo.get("emailId");
            String first_name=(String) jo.get("firstName");
            String lastName=(String) jo.get("lastName");
            String password=(String) jo.get("password");
            String nickname=first_name;
            MailChecker mailObj=new MailChecker();
            if(mailObj.isExsist(email))
            {
                System.out.println("already exsist");
                response.getWriter().append("Already exsist");
            }
            else
            {

                DetailsAdder detailObj=new DetailsAdder();
                detailObj.addDetails(first_name, lastName, nickname,email, password);
                response.getWriter().append("Success");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("i am form register exception");
        }
    }

}
