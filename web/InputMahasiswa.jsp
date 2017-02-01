<%-- 
    Document   : InputMahasiswa
    Created on : Jan 22, 2017, 11:36:23 AM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Mahasiswa</title>
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />        
    </head>
    <body>
        <div class="container">
            <h2>Input Mahasiswa Form</h2>

            <form:form method="POST" action="/University/addMahasiswa.do" modelAttribute="mahasiswa">
                <div class="form-group">    
                    <label for="npm">NPM Mahasiswa :</label>
                    <form:input path="npm" class="form-control"  placeholder="Npm anda"/>
                </div>

                <div class="form-group">                        
                    <label for="nama">Nama Mahasiswa :</label>
                    <form:input path="nama" class="form-control" placeholder="Nama anda"/>
                </div>
                <div class="form-group">                                            
                    <label for="kelas">Kelas Mahasiswa :</label>
                    <form:input path="Kelas" class="form-control" placeholder="Kelas anda"/>
                </div>

                <div class="form-group">                                            
                    <label for="jurusan">Jurusan Mahasiswa :</label>
                    <form:input path="jurusan" class="form-control" placeholder="Jurusan anda"/>
                </div>                    
                <input type="submit" value="Simpan" class="btn btn-default"  />
            </div>
        </form:form>
    </body>
</html>