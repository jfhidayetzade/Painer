package web;

import az.painer.dao.FiliesDaoImple;
import az.painer.dao.FiliesInterface;
import az.painer.db.FileDataManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

@WebServlet(name = "downloadServlet", urlPatterns = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            functtion(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            functtion(request,response);
    }

    protected void functtion (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/force-download");
            response.setHeader("Content-Transfer-Encoding","binary");
            String key=request.getParameter("key");
            String path = null;
            try{
                FiliesInterface dataManager=new FiliesDaoImple();
                path=dataManager.findAllPath(key);
            }catch (Exception e){
                e.printStackTrace();
            }
            File file=new File(path);
        response.setHeader("Content-Disposition","attachment; filename=\""+file.getName());
            FileInputStream inputStream=new FileInputStream(path);
            OutputStream outputStream=response.getOutputStream();

            byte [] buffer=new byte[1024];
            int length;
            while ((length=inputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,length);
            }
                        inputStream.close();

    }

}
