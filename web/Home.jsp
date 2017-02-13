<%-- 
    Document   : Home
    Created on : Jan 21, 2017, 7:29:01 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>
<%@taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Mahasiswa</title>            
        <link  href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <nav class="navbar navbar-default ">
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
                <form:form class="navbar-form navbar-left " method = "GET" action="searchMahasiswa.do" >
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
                        <th>No</th>
                        <th>NPM</th>
                        <th>Nama</th>
                        <th>Jenis Kelamin</th>
                        <th>Tanggal Lahir</th>
                        <th>Kelas</th>
                        <th>Jurusan</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach items="${mahasiswalist}" var="mahasiswa" varStatus="itr">
                        <tr>
                            <td>${offset + itr.index +1 }</td>
                            <td>${mahasiswa.npm}</td>
                            <td>${mahasiswa.nama}</td>
                            <td>${mahasiswa.jenisKelamin}</td>                            
                            <td>${mahasiswa.tanggalLahir}</td>
                            <td>${mahasiswa.kelas}</td>
                            <td>${mahasiswa.jurusan}</td>
                        <img src="data::;base64,${mahasiswa.byte64Encode}"/>
                        <td> <a href="viewUpdate.do?mhs_id=${mahasiswa.npm}" class="btn btn-info">Update</a> 
                            <a href="deleteMahasiswa.do?mhs_id=${mahasiswa.npm}" class="btn btn-danger confirmation">Delete</a> </td>                  
                        </tr>
                    </c:forEach>
                </table>
                <ul class="pagination">
                    <tag:paginate max="7" offset="${offset}" count="${count}"
                                  uri="/University/tampilMahasiswa.do" next="&raquo;" previous="&laquo;"/>
                </ul>
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
