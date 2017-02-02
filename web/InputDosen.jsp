<%-- 
    Document   : InputDosen
    Created on : Jan 31, 2017, 12:05:00 AM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />        

    </head>
    <body>
        <div class="container">
            <h2>Input Dosen Form</h2>

            <form:form method="POST" action="/University/addDosen.do" modelAttribute="dosen">
                <div class="form-group">    
                    <label for="nip">NIP Dosen :</label>
                    <form:input path="nip" class="form-control"  placeholder="NIP Dosen"/>
                </div>

                <div class="form-group">                        
                    <label for="dosen">Nama Dosen :</label>
                    <form:input path="dosen" class="form-control" placeholder="Nama Dosen"/>
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
                </div>
                <div class="form-group">                                            
                    <label for="alamat">Alamat Dosen :</label>
                    <form:input path="alamat" class="form-control" placeholder="Alamat Dosen"/>
                </div>
                <input type="submit" value="Simpan" class="btn btn-default"  />

            </form:form>
        </div>
    </body>
</html>
