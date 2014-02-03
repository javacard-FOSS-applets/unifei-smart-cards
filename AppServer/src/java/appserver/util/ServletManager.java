/*
 * ServletManager.java
 *
 * Created on 14 de Fevereiro de 2007, 10:07
 */

package appserver.util;

import java.io.*;
import javax.servlet.http.*;

/**
 * Fornece m�todos para suportar e padronizar servi�os dos servlets.
 *
 * @author Tiago Romero Garcia
 * @version 0.1.9
 */
public class ServletManager
{  
   /**
    * Despacha uma mensagem de exce��o a ser tratada por um servlet, e se n�o
    * for poss�vel, por javascript no cliente.
    *
    * @param message    Mensagem de exce��o
    * @param response   Response do servlet atual
    */
   public static void dispatchException(String message, HttpServletResponse response)
   {
      response.reset();
      try
      {
         response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
      }
      catch (IOException ex)
      {
         response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
   }
   
}
