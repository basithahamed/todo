package com.filter;




import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.authorize.LoginChecker;





/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
            String jsonString =  request.getParameter("userData");
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jo = (JSONObject) obj;
            String email = (String) jo.get("emailId");
            String password = (String) jo.get("password");
            System.out.println("name:"+email);
            LoginChecker loginObj=new LoginChecker();
            if(loginObj.validater(email,password))
            {
                response.getWriter().append("Success");
            }
            else
            {               
                 System.out.println("fail");

                response.getWriter().append("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("i am from exception");
        }
		
//         
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
