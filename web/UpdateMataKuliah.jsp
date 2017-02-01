<%-- 
    Document   : UpdateMataKuliah
    Created on : Jan 30, 2017, 11:35:52 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />                
              <title>Update Mata Kuliah Page</title>
    </head>
    <body>
        <div class="container">
            <h2>Update Mata Kuliah Form</h2>        
            <form:form method="POST" action="/University/addMataKuliah.do" modelAttribute="matakuliah">
                <form:input type="hidden" path="kode" id="kode"/>
                
                <div class="form-group">    
                    <label for="mata_kuliah">Nama Mata Kuliah :</label>
                    <form:input path="mata_kuliah" id="mata_kuliah"  class="form-control" />
                    <form:errors path="mata_kuliah"  class="form-control" />
                </div>
                
                <div class="form-group">    
                    <label for="sks">Jumlah SKS :</label>
                    <form:input path="sks" id="sks" class="form-control" />
                    <form:errors path="sks"  class="form-control" />
                </div>
                <input type="submit" value="Update" class="btn btn-default" />
        </div>
    </form:form>
</body>
</html>
