<%-- 
    Document   : UpdateNilai]
    Created on : Feb 1, 2017, 1:04:52 PM
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
            <h2>Input Nilai Form</h2>
            <form:form method="POST" action="addNilai.do" modelAttribute="nilai">
                <form:input type="hidden" path="id_nilai" id="id_nilai"/>
                <div class="form-group">                                            
                    <label for="mataKuliah">Kode Mata Kuliah :</label>
                    <form:input path="mataKuliah.kode" class="form-control" placeholder="Kode Mata Kuliah"/>
                    <form:errors path="mataKuliah.kode"  class="form-control" />
                </div>
                <div class="form-group">                        
                    <label for="dosen">NIP Dosen :</label>
                    <form:input path="dosen.nip" class="form-control" placeholder="NIP Dosen"/>
                    <form:errors path="dosen.nip"  class="form-control" />
                </div>

                <div class="form-group">                                            
                    <label for="mahasiswa">NPM Mahasiswa :</label>
                    <form:input path="mahasiswa.npm" class="form-control" placeholder="NPM Mahasiswa"/>
                    <form:errors path="mahasiswa.npm"  class="form-control" />
                </div>
                <div class="form-group">                                            
                    <label for="nilai">Nilai Mahasiswa :</label>
                    <form:input path="nilai" class="form-control" placeholder="Nilai Mahasiswa"/>
                    <form:errors path="nilai"  class="form-control" />
                </div> 
                <input type="submit" value="Simpan" class="btn btn-default"  />
        </div>
    </form:form>    </body>
</html>
