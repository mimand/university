<%-- 
    Document   : InputMataKuliah
    Created on : Jan 30, 2017, 10:40:43 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Mata Kuliah</title>
        <link href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />                
    </head>
    <body>
        <div class="container">
            <h2>Input Mata Kuliah Form</h2>

            <form:form method="POST" action="/University/addMataKuliah.do" modelAttribute="matakuliah">
                <div class="form-group">    
                    <label for="kode">Kode Mata Kuliah :</label>
                    <form:input path="kode" class="form-control"  placeholder="Kode Mata Kuliah"/>
                </div>

                <div class="form-group">                        
                    <label for="mata_kuliah">Nama Mata Kuliah :</label>
                    <form:input path="mata_kuliah" class="form-control" placeholder="Nama Mata Kuliah"/>
                </div>
                <div class="form-group">                                            
                    <label for="sks">Jumlah SKS :</label>
                    <form:input path="sks" class="form-control" placeholder="Jumlah SKS"/>
                </div>
                <input type="submit" value="Simpan" class="btn btn-default"  />

            </form:form>
        </div>
    </body>
</html>
