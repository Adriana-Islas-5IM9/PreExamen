/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ipn.cecyt9.mesne.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.ipn.cecyt9.mesne.model.Registro;
import mx.edu.ipn.cecyt9.mesne.utils.Conexion;

/**
 *
 * @author Alumno
 */
public class ConsultaServlet extends HttpServlet {

   private Connection conex;
   private ResultSet res = null;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Conexion con = new Conexion();
        con.conecta();
        conex = con.getConnection();
        Registro reg = null;
        ArrayList<Registro> regs = new ArrayList();

        final String INSERT = "select * from registro();";

        try {
            con.query(INSERT);
            
            while (res.next()) {
                reg = new Registro();
                reg.setNombre(res.getNString("nombre"));
                reg.setApellido(res.getNString("apellido"));
                reg.setIdRegistro(res.getInt("idRegistro"));
                
                regs.add(reg);  
            }
            conex.close();
        } catch (Exception eee) {
            System.out.println("No se encontraron los registros");
        }
        
        request.getServletContext().setAttribute("Registros", reg);
        response.sendRedirect("JSP/Consulta.jsp");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
