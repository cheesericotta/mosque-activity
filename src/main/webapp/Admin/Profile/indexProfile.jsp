<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import= "java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <title>Profile | Al-Ikwaniah Mosque Activity System</title>

  <style>
    
    @import "../../css/topnavbar.css";

    body {
      background: #b6b6b6;
    }

    .form-control:focus {
      box-shadow: none;
      border-color: #7abe2c;
    }

    .profile-button {
      background: #92CF4C;
      box-shadow: none;
      border: none;
    }

    .profile-button:hover {
      background: #7abe2c;
    }

    .back:hover {
      color: #7abe2c;
      cursor: pointer;
    }

    .labels {
      font-size: 11px;
    }

    .add-experience:hover {
      background: #7abe2c;
      color: #fff;
      cursor: pointer;
      border: solid 1px #7abe2c;
    }
  </style>
</head>

<body>

<%
			
			String user = (String)session.getAttribute("username");
			String jdbcURL ="jdbc:postgresql://ec2-3-211-221-185.compute-1.amazonaws.com:5432/dd283fabsjbk3c";
			String username="roudqjprncsaet";
			String password="f77b9dae0ee6b371ee0855996a822412bd842ed5fa9e492df8795c2c9632a1d6";
			try{ 
				
		    	 Class.forName("org.postgresql.Driver");
		    	 Connection connection=DriverManager.getConnection(jdbcURL,username,password);
		    	 
		    	 
		            // String sql="(Select username,password from student where name='"+name+"' and '"+pass+"')";
			
		             String sql="Select * from users where username='"+user+"'";
			 	     Statement stat=connection.createStatement();
			 	  	 ResultSet rs=  stat.executeQuery(sql);
			 	  	
			 	  	while(rs.next()){
%>

  <div class="topnav">
    <a href="../Home/index.html">Home</a>
    <a class="active" href="../Profile/index.html">Profile</a>
    <a href="../Activity/index.html">Activity</a>
    <button class="logout" onclick="openForm()">Log Out</button>
    <div class="form-popup" id="logout-form">
      <form action="#" class="form-container">
        <div class="logout-header">Confirm Log Out?</div>
        <button type="submit" class="btn">Log Out</button>
        <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        <script src="../../js/openForm.js"></script>
      </form>
    </div>
  </div>

  <div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
      <div class="col-md-3 border-right">
        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
            src="https://i.imgur.com/O1RmJXT.jpg" width="90"><span class="font-weight-bold"><%=rs.getString("username") %></span><span class="text-black-50"><%=rs.getString("useremail") %></span><span>Admin</span></div>
      </div>
      <div class="col-md-5 border-right">
        <div class="p-3 py-5">
          <div class="d-flex justify-content-between align-items-center mb-3">
            <h6 class="text-right">Admin Profile</h6>
          </div>
          <div class="row mt-2">
            <div class="col-md-6"><label class="labels">Name</label>
              <h6><%=rs.getString("username") %></h6>
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-md-6"><label class="labels">Email</label>
              <h6><%=rs.getString("useremail") %></h6>
            </div>
            <div class="col-md-6"><label class="labels">Telephone Number</label>
              <h6>012345678</h6>
            </div>
          </div>
          <div class="row mt-3">
            <div class="col-md-6"><label class="labels">Position</label>
              <h6>Admin</h6>
            </div>
          </div>
          <div class="mt-5 text-center"><a href="Update/indexUpdate.jsp?username=<%=rs.getString("username") %>"><button class="btn btn-primary profile-button" type="button">Update Profile</button></a></div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="p-3 py-5">
          <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
              src="../../assets/brand/mosque.svg" width="190" height="110">
            <div class="col-md-4"><label class="labels"></label></div> <br>
            <span class="font-weight-bold">Masjid Al-Ikhwaniah</span><span class="text-black-50">
              <span class="font-weight-bold">Jalan Cheras Utama 9, Taman Cheras Utama, 56000 Cheras,
                Selangor.</span><span class="text-black-25">
                <div class="col-md-4"><label class="labels" allign="center"></label></div>
                <span class="font-weight-bold">012-291 7885</span><span class="text-black-50">
          </div>
        </div>
      </div>
      <% 
	}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
</body>

</html>