package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Pablo Aguilar
 * Fecha: 31/10/2025
 * Descripción:
 * Servlet que maneja el procesamiento de formularios de autenticación.
 * Recibe datos mediante POST y valida las credenciales del usuario.
 *
 */
@WebServlet("/servletFormulario")
public class Formulario extends HttpServlet {

    /**
     * Clave de acceso predefinida para la validación de usuarios.
     * En una aplicación real, esto debería almacenarse de forma segura
     * y utilizar encriptación.
     */
    private static final String CLAVE_VALIDA = "12345";

    /**
     * Procesa las solicitudes HTTP POST enviadas desde el formulario de login.
     * Valida las credenciales del usuario y genera una respuesta HTML apropiada.
     *
     * @param req  El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param resp El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error específico del servlet
     * @throws IOException      Si ocurre un error de entrada/salida
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Establece el tipo de contenido de la respuesta como HTML
        resp.setContentType("text/html");

        // Obtiene los parámetros enviados desde el formulario
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        // Obtiene el escritor para generar la respuesta HTML
        PrintWriter out = resp.getWriter();

        // Valida si la contraseña ingresada coincide con la clave predefinida
        if (CLAVE_VALIDA.equals(password)) {
            // Si la contraseña es correcta, genera página de bienvenida
            generarPaginaBienvenida(out, usuario);
        } else {
            // Si la contraseña es incorrecta, genera página de acceso denegado
            generarPaginaAccesoDenegado(out);
        }
    }

    /**
     * Genera una página HTML de bienvenida para usuarios autenticados correctamente.
     *
     * @param out     El PrintWriter utilizado para escribir la respuesta HTML
     * @param usuario El nombre de usuario que ha iniciado sesión correctamente
     */
    private void generarPaginaBienvenida(PrintWriter out, String usuario) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Acceso Permitido</title>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <style>");
        out.println("        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f0f8ff; }");
        out.println("        h1 { color: #2e8b57; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>Bienvenido a la página " + (usuario != null ? usuario : "Usuario") + "</h1>");
        out.println("    <p>Has accedido correctamente al sistema.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Genera una página HTML de error cuando las credenciales son incorrectas.
     *
     * @param out El PrintWriter utilizado para escribir la respuesta HTML
     */
    private void generarPaginaAccesoDenegado(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>Acceso Denegado</title>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <style>");
        out.println("        body { font-family: Arial, sans-serif; margin: 40px; background-color: #fff0f0; }");
        out.println("        h1 { color: #dc143c; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>No tienes acceso a este sitio</h1>");
        out.println("    <p>Las credenciales proporcionadas son incorrectas.</p>");
        out.println("    <p><a href='javascript:history.back()'>Volver al formulario</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}