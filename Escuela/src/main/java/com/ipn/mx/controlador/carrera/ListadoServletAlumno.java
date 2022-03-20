package com.ipn.mx.controlador.carrera;

import com.ipn.mx.modelo.dao.Alumno;
import com.ipn.mx.modelo.dto.AlumnoDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListadoServletAlumno extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Lista de Alumnos</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' ></script>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>																																													");
            out.println("            <nav class='navbar navbar-expand-lg navbar-light bg-info'>																																	");
            out.println("                <div class='container-fluid'>                                                                                                                                                              ");
            out.println("                    <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>     ");
            out.println("                        <span class='navbar-toggler-icon'></span>                                                                                                                                          ");
            out.println("                    </button>                                                                                                                                                                              ");
            out.println("                    <div class='collapse navbar-collapse' id='navbarNav'>                                                                                                                                  ");
            out.println("                        <ul class='navbar-nav'>                                                                                                                                                            ");
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link' href='../index.html'>Escuela</a>");
            out.println("</li>");

            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link' href='./carrera/nuevo.html'>Agregar Carrera</a>                                                                                                        ");
            out.println("                                <!-- <a class='nav-link' href='./CarreraServlet'>Carrera</a>-->                                                                                                            ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link active' href='ListadoServlet'>Listado de Carreras</a>                                                                                                          ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                        </ul>                                                                                                                                                                              ");
            out.println("                    </div>                                                                                                                                                                                 ");
            out.println("                </div>                                                                                                                                                                                     ");
            out.println("            </nav>                                                                                                                                                                                         ");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<h1>Alumnos de la Escuela </h1>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr>");
            out.println("<th>Ver Carrera</th>");
            out.println("<th>Nombre Alumno</th>");
            out.println("<th>Apellido paterno</th>");
            out.println("<th>Apellido materno</th>");
            out.println("<th>Correo</th>");
            out.println("<th>ID de carrera</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.println("</tr>");

            Alumno dao = new Alumno(); // Objeto que hace consultas  
            AlumnoDTO dto = new AlumnoDTO(); // Objeto que accede a los registros expresados en dto 

            try {
                List lista = dao.readAll();
                for (int i = 0; i < lista.size(); i++) {
                    dto = (AlumnoDTO) lista.get(i);
                    out.println("<tr>");
                    // La referencia está al mismo nivel de este Servlet 
                    out.println("<td><a href='VerAlumnoServlet?id=" + dto.getEntidad().getIdAlumno()+ "' class='btn btn-outline-warning'>"
                            + "Ver"
                            + "</a></td>");
                    out.println("<td>" + dto.getEntidad().getNombreAlumno()+ "</td>");
                    out.println("<td>" + dto.getEntidad().getPaternoAlumno()+ "</td>");
                    out.println("<td>" + dto.getEntidad().getMaternoAlumno()+ "</td>");
                    out.println("<td>" + dto.getEntidad().getEmailAlumno()+ "</td>");
                    out.println("<td>" + dto.getEntidad().getIdCarrera()+ "</td>");
                    // ----> ELIMINANDO UN REGISTRO <----
                    // En la línea 78 se está mandando, a través de la URL, el id del elemento que se va a eliminar 
                    out.println("<td> <a href='EliminarAlumnoServlet?id=" + dto.getEntidad().getIdAlumno()+ "' class='btn btn-outline-danger'>Eliminar</a></td>");
                    out.println("<td> <a href='ActualizarAlumnoServlet2?id=" + dto.getEntidad().getIdAlumno()+ "' class='btn btn-outline-success'>"
                            + "Actualizar"
                            + "</a></td>");
                    out.println("</tr>");
                }

                //out.println(dao.readAll());
                //dao.create(dto);
                //dao.delete(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ListadoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
