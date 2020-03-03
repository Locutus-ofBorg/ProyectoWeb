package com.vipper.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vipper.persistencia.AccesoBBDD;

/**
 * Servlet implementation class ServletControl
 */
@WebServlet("/ServletControl")
public class ServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet" + request.getParameter("usuario") + request.getParameter("password"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	out.println("<!DOCTYPE html>");
        	out.println("<html>");
        	out.println("<head>");
        	out.println("<title>Servlet ServletControl doGet</title>");            
        	out.println("</head>");
        	out.println("<body>");
        	out.println("<h1>Servlet ServletControl at " + request.getContextPath() + "</h1>");
        	out.println("Bienvenido " + request.getParameter("usuario") + " al doGet");
        	out.println("<br>");
        	out.println("<br>");
        	out.println("</body>");
        	out.println("</html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("doPost" + request.getParameter("usuario") + request.getParameter("password"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	out.println("<!DOCTYPE html>");
        	out.println("<html>");
        	out.println("<head>");
        	out.println("<title>Servlet ServletControl doPost</title>");            
        	out.println("</head>");
        	out.println("<body>");
        	out.println("<h1>Servlet ServletControl at " + request.getContextPath() + "</h1>");

        	out.println("Bienvenido " + request.getParameter("usuario") + " al doPost");
        	out.println("<br>");
        	out.println("<br>");
            
            /*
            Conexion c1 = new Conexion();
            try {
				c1.abrirConexion();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println(e.toString());
			}
            */
            
            AccesoBBDD ab1 = new AccesoBBDD();
            
            String jusuario = request.getParameter("usuario");
            String jpassword = request.getParameter("password");
            
            try {
                String passwordBBDD = ab1.verificarPassword(jusuario);
                System.out.println(jusuario + "/" + jpassword + "//" + passwordBBDD);
                if ( jpassword.equals(passwordBBDD) ) {
                    out.print("Bienvenido " + jusuario);
                } else {
                    out.print("Contraseña incorrecta");
                }
            } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
            	System.out.println(e.toString());
			}
            


        	out.println("</body>");
        	out.println("</html>");
        }
	}

}
