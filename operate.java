

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class operate
 */
@WebServlet("/operate")
public class operate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","1234");  
			Statement stmt=con.createStatement();  
			 ResultSet rs = stmt.executeQuery("SELECT * FROM Products");

			    // Start building the HTML table
			    out.print("<table border='1' width='100%' cellpadding='10'>");
			    out.print("<tr>");
			    
			    out.print("<th>ProductName</th>");
			    out.print("<th>CategoryID</th>");
			    out.print("<th>Price</th>");
			    out.print("<th>Rating</th>");
			    out.print("<th>Stock</th>");
			    out.print("<th>Sales</th>");
			    out.print("<th>Profit</th>");
			    out.print("<th>Region</th>");
			    out.print("<th>Discount</th>");
			    out.print("<th>Action</th>");
			    out.print("</tr>");

			    // Iterate through the ResultSet and populate the table rows
			    while (rs.next()) {
			        out.print("<tr>");

			        
			        out.print("<td>" + rs.getString("ProductName") + "</td>");
			        out.print("<td>" + rs.getInt("CategoryID") + "</td>");
			        out.print("<td>" + rs.getDouble("Price") + "</td>");
			        out.print("<td>" + rs.getDouble("Rating") + "</td>");
			        out.print("<td>" + rs.getInt("Stock") + "</td>");
			        out.print("<td>" + rs.getInt("Sales") + "</td>");
			        out.print("<td>" + rs.getDouble("Profit") + "%</td>");
			        out.print("<td>" + rs.getString("Region") + "</td>");
			        out.print("<td>" + rs.getDouble("Discount") + " %</td>");
			        
			        // Adding links for delete and edit actions with respective IDs
			        out.print("<td><a href='opup?id=" + rs.getInt("id") + "'>delete</a></td>");
			        out.print("<td><a href='opedit?id=" + rs.getInt("id") + "'>edit</a></td>");

			        out.print("</tr>");
			    }

			    out.print("</table>");
			    out.print("<a href='operation.html'>Insert more...</a>");


				

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","1234");  
		    Statement stmt=con.createStatement();  
			
		  

			  
		    String ProductName = request.getParameter("ProductName");
		    int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
		    double Price = Double.parseDouble(request.getParameter("Price"));
		    double Rating = Double.parseDouble(request.getParameter("Rating"));
		    int Stock = Integer.parseInt(request.getParameter("Stock"));
		    int Sales = Integer.parseInt(request.getParameter("Sales"));
		    double Profit = Double.parseDouble(request.getParameter("Profit"));
		    String Region = request.getParameter("Region");
		    double Discount = Double.parseDouble(request.getParameter("Discount"));

				
				
				
		    String sql = "INSERT INTO Products (ProductName, CategoryID, Price, Rating, Stock, Sales, Profit, Region, Discount) " +
	                 "VALUES ('" + ProductName + "', " + CategoryID + ", " + Price + ", " + Rating + ", " + Stock + ", " +
	                 Sales + ", " + Profit + ", '" + Region + "', " + Discount + ")";

	    // Execute the insert statement
	    stmt.executeUpdate(sql);

	    System.out.println("Data inserted successfully.");
	    response.sendRedirect("operate");

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	}


