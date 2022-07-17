

import java.io.IOException
;
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
 * Servlet implementation class ConnectLogin
 */
@WebServlet("/ConnectLogin")
public class ConnectLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectLogin() {
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
		String pass=request.getParameter("pass");
		
		String DB_DRIVER = "com.mysql.jdbc.Driver";
		String DB_CONNECTION = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_905f91989a96636?reconnect=true";
		String DB_USER = "b33c75431cbd59";
		String DB_PASSWORD = "3215937f";
		
		
	    
	    try {
	    	 
	    	 Class.forName(DB_DRIVER);
	    	 Connection connection=DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
	    	
	    	 
	            // String sql="(Select username,password from student where name='"+name+"' and '"+pass+"')";
	             PreparedStatement pst = connection
	            	     .prepareStatement("Select Username,UserPassword from user where Username=? and UserPassword=?");
	            	   pst.setString(1, name);
	            	   pst.setString(2, pass);
	            	   ResultSet rs = pst.executeQuery();
	            	   if (rs.next()) {
	            		   HttpSession session = request.getSession();
	                       session.setAttribute("username", name);
	            		   out.print("You are successfully loggedin...");
	            		   response.sendRedirect("Admin/Home/index.html");
	            	   }else {
	            		    out.println("Username or Password incorrect");
	            		    response.sendRedirect("Sign In/index.html");
	            		   
	            	   }
	 	    

	            // Statement stat=connection.createStatement();
	            // int row=stat.executeUpdate(sql);
	 	       /*  connection.close();
	 	     if (row>0) {
	 	    	 
	 	    	 response.sendRedirect("Admin/Home/index.html");
	 	    	 
	 	     }*/
	 	     
	 	     }
	    catch(Exception e){
	    	e.printStackTrace();
	    	out.print("not connected");
	    	}
	    
	    
	    
		
	}

}
