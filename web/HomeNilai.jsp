<%-- 
    Document   : HomeNilai
    Created on : Jan 31, 2017, 12:22:54 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tampil Nilai Page</title>
        <link  href="<c:url value="/template/styles/bootstrap.min.css" />" rel="stylesheet" type="text/css" />        

    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Universitas</a>
                </div>
                <ul class="nav navbar-nav">
                    <li ><a href="tampilMahasiswa.do">Home</a></li>
                    <li><a href="tampilDosen.do">Dosen</a></li>
                    <li><a href="tampilMataKuliah.do">Mata Kuliah</a></li>
                    <li class="active"><a href="tampilNilai.do">Nilai</a></li>
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
                        <th>Nilai Id</th>
                        <th>Dosen</th>
                        <th>Mahasiswa</th>
                        <th>Mata Kuliah</th>
                        <th>Nilai </th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${nilailist}" var="nilai">
                        <tr>
                            <td>${nilai.id_nilai}</td>
                            <td>${nilai.dosen.dosen}</td>
                            <td>${nilai.mahasiswa.nama}</td>
                            <td>${nilai.mataKuliah.mata_kuliah}</td>
                            <td>${nilai.nilai}</td>
                            <td> <a href="updateNilai.do?n_id=${nilai.id_nilai}" class="btn btn-info">Update</a> 
                                <a href="deleteNilai.do?n_id=${nilai.id_nilai}" class="btn btn-danger confirmation">Delete</a> </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="InputNilai.do" class="btn btn-default center-block"><b>INPUT Nilai</b></a>
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
