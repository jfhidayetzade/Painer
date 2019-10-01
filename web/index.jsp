<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2019
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Painer</title>
<link rel="stylesheet" type="text/css" href="web/main.css">

  </head>
  <body>
      <div id="wrapper">
            <div id="main">
              <h1 id="logo">Painer.com</h1>
                <div id="uploadId">
                    <form action="uploadServelet" method="post" enctype="multipart/form-data">
                      <% if(request.getParameter("key")!=null) {%>

                      <table>

<tr>

<td>Faylı yükləmək üçün linki klikləyin zəhmət olmazsa</td>
</tr>

                        <tr>
                         <td> <a href="localhost:8088/painer/downloadServlet?key=<%=request.getParameter("key")%>">localhost:8088/painer/downloadServlet?key=<%=request.getParameter("key")%></a></td>
                        </tr>
                      </table>
                      <% } else { %>

                        <table>
                            <tr>
                                <td><input type="file" name="fl"></td>
                            </tr>
                            <tr>
                                <td><input type="submit" name="submit" value="upload"></td>
                            </tr>
                        </table>

                      <%}%>


                    </form>
                </div>
            </div>

      </div>

  </body>
</html>
