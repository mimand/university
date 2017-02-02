<%-- 
    Document   : UpdateDosen
    Created on : Jan 31, 2017, 12:16:21 AM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />                
        <title>Update Dosen Page</title>
    </head>
    <body>
        <div class="container">
            <h2>Update Mata Kuliah Form</h2>        
            <form:form method="POST" action="/University/addDosen.do" modelAttribute="dosen">
                <form:input type="hidden" path="nip" id="nip"/>

                <div class="form-group">    
                    <label for="dosen">Nama Dosen :</label>
                    <form:input path="dosen" id="dosen"  class="form-control" />
                    <form:errors path="dosen"  class="form-control" />
                </div>
                <div class="form-group">
                    <label for="nama">Jenis Kelamin :</label>                    
                    <label class="radio-inline"> <form:radiobutton path="jenis_kelamin" value="Pria" name="optradio"/>Pria</label>
                    <label class="radio-inline"> <form:radiobutton path="jenis_kelamin" value="Perempuan" name="optradio"/>Perempuan</label>
                    <form:errors path="jenis_kelamin"  class="form-control" />                    
                </div>                  
                <div class="form-group">                                            
                    <label for="tanggal_lahir">Tanggal Lahir Dosen :</label>
                    <form:input type="date" path="TanggalLahir" class="form-control"
                                placeholder="Tanggal Lahir anda" />
                    <fmt:formatDate value="${dosen.tanggalLahir}" pattern= "yyyy-MM-dd"/>                    
                    <form:errors path="TanggalLahir"  class="form-control" />

                </div>
                <div class="form-group">    
                    <label for="alamat">Alamat Dosen :</label>
                    <form:input path="alamat" id="alamat" class="form-control" />
                    <form:errors path="alamat"  class="form-control" />
                </div>
                <input type="submit" value="Update" class="btn btn-default" />
        </div>
        </form:form>
    </body>
</html>
