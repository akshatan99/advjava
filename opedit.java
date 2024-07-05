

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
			    		+"<div style=\\\"padding: 10px;\\\">"
			    		+"<p>Fill the details here...</p>"
			    		+"</div>"
			           +"<div style=\"padding: 10px;\">"
			            +"<label for=\"ProductName\">1.Enter ProductName:</label>"
			            + "<input type='text' name='ProductName' value='" + rs.getString("ProductName") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"CategoryID\">2.Enter CategoryID:</label>"
			            + "<input type='text' name='CategoryID' value='" + rs.getInt("CategoryID") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"Price\">3.Enter Price:</label>"
			            + "<input type='text' name='Price' value='" + rs.getDouble("Price") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"Rating\">4.Enter Rating:</label>"
			            + "<input type='text' name='Rating' value='" + rs.getDouble("Rating") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"Stock\">5.Enter Stock:</label>"
			            + "<input type='text' name='Stock' value='" + rs.getInt("Stock") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"Profit\">7.Enter Profit:</label>"
			            + "<input type='text' name='Sales' value='" + rs.getInt("Sales") + "' />"
			             +"</div>"
			             +"<div style=\"padding: 10px;\">"
			             +"<label for=\"Profit\">7.Enter Profit:</label>"
			            + "<input type='text' name='Profit' value='" + rs.getDouble("Profit") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\\\"Region\\\">8.Enter Region:</label>"
			            + "<input type='text' name='Region' value='" + rs.getString("Region") + "' />"
			            +"</div>"
			            +"<div style=\"padding: 10px;\">"
			            +"<label for=\"Discount\">9.Enter Discount:</label>"
			            + "<input type='text' name='Discount' value='" + rs.getDouble("Discount") + "' />"
			            +"</div>"
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
