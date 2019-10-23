package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// à remplir
@WebServlet(name = "MaServlet", urlPatterns = { "/hello", "/bonjour" })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// à remplir
		ServletOutputStream out = resp.getOutputStream();//R�ponse de la servlet
		out.write("hello guys ! Java4life".getBytes());
		out.flush();
		out.close();
	}

}
