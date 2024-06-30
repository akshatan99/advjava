

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
 * Servlet implementation class opedit
 */
@WebServlet("/opedit")
public class opedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public opedit() {
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
			
			
			int id= Integer.parseInt(request.getParameter("id"));
			ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE id=" + id);
			if (rs.next()) {
			    out.print("<form action='opup' method='post'>"
			           
			    		
			            + "<input type='text' name='ProductName' value='" + rs.getString("ProductName") + "' />"
			            + "<input type='text' name='CategoryID' value='" + rs.getInt("CategoryID") + "' />"
			            + "<input type='text' name='Price' value='" + rs.getDouble("Price") + "' />"
			            + "<input type='text' name='Rating' value='" + rs.getDouble("Rating") + "' />"
			            + "<input type='text' name='Stock' value='" + rs.getInt("Stock") + "' />"
			            + "<input type='text' name='Sales' value='" + rs.getInt("Sales") + "' />"
			            + "<input type='text' name='Profit' value='" + rs.getDouble("Profit") + "' />"
			            + "<input type='text' name='Region' value='" + rs.getString("Region") + "' />"
			            + "<input type='text' name='Discount' value='" + rs.getDouble("Discount") + "' />"
			            + "<input type='hidden' name='id' value='" + rs.getInt("id") + "' />"
			            + "<input type='submit' />"
			            + "</form>");
			}
			
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
