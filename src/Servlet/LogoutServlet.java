package Servlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Servlet.SessionCache;
import Servlet.Session;
/**
 * Servlet implementation class LogoutServlet
 */


public class LogoutServlet extends HttpServlet {
	protected SessionCache sessionCache;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            
	                cookie.setValue(null);
	                cookie.setMaxAge(0);
	              //  cookie.setPath(theSamePathAsYouUsedBeforeIfAny);
	                response.addCookie(cookie);
	            
	        }
	    }
	    
		request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/home.html");
    System.out.println("Logout servlet");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void endSession (Session session) {
		synchronized (sessionCache) {
			
		sessionCache.remove (session);
		System.out.println("end session servlet");
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            
	                cookie.setValue(null);
	                cookie.setMaxAge(0);
	              //  cookie.setPath(theSamePathAsYouUsedBeforeIfAny);
	                response.addCookie(cookie);
	            
	        }
	    }
		 request.getSession().invalidate();
	        response.sendRedirect(request.getContextPath() + "/home.html");
	    System.out.println("Logout servlet");
	}

}
