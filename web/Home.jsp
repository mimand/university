<%-- 
    Document   : Home
    Created on : Jan 21, 2017, 7:29:01 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Mahasiswa</title>            
        <link  href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Universitas</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="tampilMahasiswa.do">Home</a></li>
                    <li><a href="tampilDosen.do">Dosen</a></li>
                    <li><a href="tampilMataKuliah.do">Mata Kuliah</a></li>
                    <li><a href="tampilNilai.do">Nilai</a></li>
                </ul>
                <form:form class="navbar-form navbar-left" method = "GET" action="searchMahasiswa.do" >
                    <div class="form-group">
                        <input type="text" name="mhs_nama" class="form-control input-sm" placeholder="search">
                    </div>
                </form:form>                    
            </div>
        </nav>  
        <div class="container">
            <div class="table-responsive">
                <table class="table table-striped tab">
                    <tr>
                        <th>NPM</th>
                        <th>Nama</th>
                        <th>Jenis Kelamin</th>
                        <th>Tanggal Lahir</th>
                        <th>Kelas</th>
                        <th>Jurusan</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${mahasiswalist}" var="mahasiswa">
                        <tr>
                            <td>${mahasiswa.npm}</td>
                            <td>${mahasiswa.nama}</td>
                            <td>${mahasiswa.jenis_kelamin}</td>                            
                            <td>${mahasiswa.tanggal_lahir}</td>
                            <td>${mahasiswa.kelas}</td>
                            <td>${mahasiswa.jurusan}</td>
                            <td> <a href="viewUpdate.do?mhs_id=${mahasiswa.npm}" class="btn btn-info">Update</a> 
                                <a href="deleteMahasiswa.do?mhs_id=${mahasiswa.npm}" class="btn btn-danger confirmation">Delete</a> </td>                  

                        </tr>
                    </c:forEach>
                </table>
                <a href="InputMahasiswa.do" class="btn btn-default center-block"><b>INPUT MAHASISWA</b></a>
            </div>
        </div>
    </body>
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
</html>
