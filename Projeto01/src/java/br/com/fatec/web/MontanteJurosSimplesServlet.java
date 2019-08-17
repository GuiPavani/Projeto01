/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet(name = "MontanteJurosSimplesServlet", urlPatterns = {"/montante-juros-simples.html"})
public class MontanteJurosSimplesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<link rel=\'stylesheet\' href=\'https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' integrity=\'sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\' crossorigin=\'anonymous\'>");

            try {
                
                DecimalFormat df = new DecimalFormat("0.00");
                float P = Float.parseFloat(request.getParameter("capital"));
                double i = Double.parseDouble(request.getParameter("taxa"));
                double n = Double.parseDouble(request.getParameter("tempo"));

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Montante do Juros Simples</title>");
                out.println("</head>");
                out.println("<body>");                
                
                out.println("<div class='col-12'>");
                
                out.println("<h2>Juros Simples<h2>");
                out.println("<h4>Montante final: R$ " + df.format(P + P * n *i/100  ) + "<h4>");
                
                out.println("<a href='juros-simples.html' class='btn btn-primary'>Voltar</a>");
                
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (NumberFormatException ex) {
                
                out.println("<h2>Você digitou algo diferente de um número</h2>");
                out.println("<h2>Por favor volte ao Formulário e digite números</h2>");
                out.println("<a href='juros-simples.html' class='btn btn-primary'>Voltar</a><br>");
            }
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
