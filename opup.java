

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class opup
 */
@WebServlet("/opup")
public class opup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public opup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","1234");  
			Statement stmt=con.createStatement();  
			
			int id =Integer.parseInt(request.getParameter("id"));
			stmt.executeUpdate("delete from Products where id="+id);
			
			System.out.println("<--------data inserted-------->");
			response.sendRedirect("operate");
			
			
					

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block===
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
		    int id=Integer.parseInt(request.getParameter("id"));
		    String ProductName = request.getParameter("ProductName");
		    int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
		    double Price = Double.parseDouble(request.getParameter("Price"));
		    double Rating = Double.parseDouble(request.getParameter("Rating"));
		    int Stock = Integer.parseInt(request.getParameter("Stock"));
		    int Sales = Integer.parseInt(request.getParameter("Sales"));
		    double Profit = Double.parseDouble(request.getParameter("Profit"));
		    String Region = request.getParameter("Region");
		    double Discount = Double.parseDouble(request.getParameter("Discount"));
		 			
		 			
		    String sql = "UPDATE Products SET ProductName='"+ProductName+"', CategoryID="+CategoryID+", Price="+Price+", Rating="+Rating+", Stock="+Stock+", Sales="+Sales+", Profit='"+Profit+"', Region='"+Region+"', Discount='"+Discount+"' WHERE id="+id;

		    stmt.executeUpdate(sql);
		    System.out.println("<--------data update-------->");
			response.sendRedirect("operate");
			
			
					

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}


