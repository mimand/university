<%-- 
    Document   : HomeMataKuliah
    Created on : Jan 30, 2017, 10:28:40 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Mata Kuliah</title>
        <link  href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />        
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Universitas</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="tampilMahasiswa.do">Home</a></li>
                    <li><a href="tampilDosen.do">Dosen</a></li>
                    <li class="active"><a href="tampilMataKuliah.do">Mata Kuliah</a></li>
                    <li ><a href="tampilNilai.do">Nilai</a></li>
                </ul>
                <form:form class="navbar-form navbar-left" method = "GET" action="searchMataKuliah.do" >
                    <div class="form-group">
                        <input type="text" name="mk_nama" class="form-control input-sm" placeholder="search">
                    </div>
                </form:form>                    
            </div>
        </nav>  
        </div>
        <div class="container">
            <div class="table-responsive">
                <table class="table table-striped tab">
                    <tr>
                        <th>Kode</th>
                        <th>Mata Kuliah</th>
                        <th>SKS</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${matakuliahlist}" var="matakuliah">
                        <tr>
                            <td>${matakuliah.kode}</td>
                            <td>${matakuliah.mataKuliah}</td>
                            <td>${matakuliah.sks}</td>
                            <td> <a href="updateMataKuliah.do?mk_id=${matakuliah.kode}" class="btn btn-info">Update</a> 
                                <a href="deleteMataKuliah.do?mk_id=${matakuliah.kode}" class="btn btn-danger confirmation">Delete</a> </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="InputMataKuliah.do" class="btn btn-default center-block"><b>INPUT MATA KULIAH</b></a>
            </div>
        </div>
    </div>        
    <script type="text/javascript">
        var elems = document.getElementsByClassName('confirmation');
        var confirmIt = function (e) {
            if (!confirm('Are you sure?'))
                e.preventDefault();
        };
        for (var i = 0, l = elems.length; i < l; i++) {
            elems[i].addEventListener('click', confirmIt, false);
        }
    </script> 
</body>
</html>
