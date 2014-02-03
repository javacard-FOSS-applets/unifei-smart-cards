/*
 * ServletGerenciarAplicacao.java
 *
 * Created on 30 de Julho de 2007, 17:44
 */

package appserver.servlets;

import appserver.modelo.AplicacaoJavaCard;
import appserver.modelo.controle.AplicacaoJavaCardDAO;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Tiago
 * @version
 */
public class ServletRemoverAplicacao extends HttpServlet
{
   /** Processes requests for  HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      // Obten��o dos par�metros
      Long id = Long.parseLong((String)request.getParameter("id"));
      
      // Busca e Remove
      AplicacaoJavaCard aplicacao = AplicacaoJavaCardDAO.queryById(id);      
      if (aplicacao == null) 
          throw new ServletException("N�o foi poss�vel encontrar a aplica��o.");
      
      try
      {
         AplicacaoJavaCardDAO.removeAplicacaoJavaCard(aplicacao);
      }
      catch (Exception ex)
      {
          throw new ServletException("N�o foi poss�vel remover a aplica��o.");
      }
      
      // Retorna OK
      response.setStatus(HttpServletResponse.SC_OK);         
   }
   
}
