

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class deleteProfile
 */
@WebServlet("/deleteProfile")
public class deleteProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out = response.getWriter();
		
		String name=request.getParameter("username");
		//String address=request.getParameter("address");
		String email=request.getParameter("useremail");
		//String pass_1=request.getParameter("pass_1");
		String pass_2=request.getParameter("userpassword");
		
		 /*PrintWriter out = response.getWriter();
		 String jdbcURL ="jdbc:postgresql://localhost/mosque";
		    String username="postgres";
		    String password="system";
		    */
		  
		String jdbcURL ="jdbc:postgresql://ec2-3-211-221-185.compute-1.amazonaws.com:5432/dd283fabsjbk3c";
	    String username="roudqjprncsaet";
	    String password="f77b9dae0ee6b371ee0855996a822412bd842ed5fa9e492df8795c2c9632a1d6";
	    HttpSession session = request.getSession();
	    String user = (String)session.getAttribute("username");
	    
	    
	   
	    
	    try {
	    	 Class.forName("org.postgresql.Driver");
	    	 Connection connection=DriverManager.getConnection(jdbcURL,username,password);
	    	 
	    	 PreparedStatement pst = connection
            	     .prepareStatement("delete from users where username ='"+user+"'");
            	  
            	   
            	   pst.executeUpdate();
            	   response.sendRedirect("../../../index.html");
	 	    
	 	     
            	   connection.close();
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    	System.out.print("not connected");
	    	}
	    
	}

}
