package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletFormulario")
public class Formulario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //Obtenemos parametros
        String usuario = req.getParameter("usuario");
        String clave="12345";
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        if(password.equals(clave)){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido a la pagina " + usuario + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Acceso denegado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>No tienes acceso a este sitio</h1>");
            out.println("</body>");
            out.println("</html>");
        };

    }
}
