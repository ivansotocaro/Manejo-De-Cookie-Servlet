package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8");
        
        boolean nuevoVisitante = true;
        
        Cookie[] cookie = req.getCookies();
        
        if (cookie != null) {
            for(Cookie c: cookie){
                if (c.getName().equals("Visitante") && c.getValue().equals("si")) {
                    nuevoVisitante = false;
                    break;
                }
            }
        }
        
        String msj = null;
        if (nuevoVisitante) {
            Cookie cs = new Cookie("Visitante","si");
            resp.addCookie(cs);
            msj = "Gracias por visitar nuestro sitio";
        }else{
             msj = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        
        PrintWriter out =  resp.getWriter();
        out.print("Mensaje: " + msj);
        out.close();
           
    }
    
}
