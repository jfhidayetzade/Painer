package web;

import az.painer.dao.FiliesDaoImple;
import az.painer.dao.FiliesInterface;
import az.painer.db.FileDataManager;
import az.painer.model.Filies;
import az.painer.util.KeyUtil;

import java.io.*;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name="uploadServelet", urlPatterns="/uploadServelet")
@MultipartConfig
public class UploadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            processRequest(request,response);
    }
    protected void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       /*String action=null;
        if(request.getParameter("action")!=null){
            action=request.getParameter("action");
        }
        try{
            if(action.equalsIgnoreCase("getPatientList")){
                FiliesInterface filiesInterface=new FiliesDaoImple();
                    List<Filies> patientList=filiesInterface.filiesList();
                    PrintWriter writer=response.getWriter();
                    writer.println(patientList);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
*/
        response.setContentType("text/html;charset=UTF-8");
        Part part=request.getPart("fl");
        String key= KeyUtil.generateKey();
        File file=new File("C:/Users/User/Desktop/upload/"+key+"-"+part.getSubmittedFileName());
        file.createNewFile();

        InputStream inputStream=part.getInputStream();
        FileOutputStream outputStream=new FileOutputStream(file);

        byte [] buffer=new byte[1024];
        int length;
        while((length=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,length);
        }
        outputStream.close();
        try {
            FiliesInterface fileDataManager=new FiliesDaoImple();
            fileDataManager.addFile(key,file.getAbsolutePath());
        }catch (Exception e){

        }
        response.sendRedirect("index.jsp?key="+key);

    }
}
