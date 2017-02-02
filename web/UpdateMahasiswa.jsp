<%-- 
    Document   : UpdateMahasiswa
    Created on : Jan 22, 2017, 9:21:05 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />                
        <title>Update Page</title>
    </head>
    <body>

        <div class="container">
            <h2>Input Mahasiswa Form</h2>        
            <form:form method="POST" action="/University/addMahasiswa.do" modelAttribute="mahasiswa">

                <form:input type="hidden" path="npm" id="npm"/>
                <div class="form-group">    

                    <label for="nama">Nama Mahasiswa :</label>
                    <form:input path="nama" id="nama"  class="form-control" />
                    <form:errors path="nama"  class="form-control" />
                </div>
                <div class="form-group">
                    <label for="nama">Jenis Kelamin :</label>                    
                    <label class="radio-inline"> <form:radiobutton path="jenis_kelamin" value="Pria" name="optradio"/>Pria</label>
                    <label class="radio-inline"> <form:radiobutton path="jenis_kelamin" value="Perempuan" name="optradio"/>Perempuan</label>
                    <form:errors path="jenis_kelamin"  class="form-control" />                    
                </div>                        
                <div class="form-group">                                            
                    <label for="tanggal_lahir">Tanggal Lahir Mahasiswa :</label>
                    <form:input type="date" path="tanggal_lahir" class="form-control"
                                placeholder="Tanggal Lahir anda" />
                    <fmt:formatDate value="${mahasiswa.tanggal_lahir}" pattern= "yyyy-MM-dd"/>                    
                    <form:errors path="tanggal_lahir"  class="form-control" />

                </div>
                <div class="form-group">                
                    <label for="kelas">Kelas Mahasiswa :</label>
                    <form:input path="kelas" id="kelas" class="form-control" />
                    <form:errors path="kelas"  class="form-control" />
                </div>
                <div class="form-group">    

                    <label for="jurusan">Jurusan Mahasiswa :</label>
                    <form:input path="jurusan" id="jurusan"  class="form-control" />
                    <form:errors path="jurusan"  class="form-control" />

                </div>
                <input type="submit" value="Update" class="btn btn-default" />
            </div>
        </form:form>
    </body>
</html>
