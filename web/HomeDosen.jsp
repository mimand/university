<%-- 
    Document   : HomeDosen
    Created on : Jan 30, 2017, 11:58:52 PM
    Author     : iman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jstlInclude.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <li class="active"><a href="tampilDosen.do">Dosen</a></li>
                    <li><a href="tampilMataKuliah.do">Mata Kuliah</a></li>
                    <li><a href="tampilNilai.do">Nilai</a></li>
                </ul>
                <form:form class="navbar-form navbar-left" method = "GET" action="searchDosen.do" >
                    <div class="form-group">
                        <input type="text" name="ds_nama" class="form-control input-sm" placeholder="search">
                    </div>
                </form:form>                    
            </div>
        </nav>  
        <div class="container">
            <div class="table-responsive">
                <table class="table table-striped tab">
                    <tr>
                        <th>NIP</th>
                        <th>Dosen</th>
                        <th>Tanggal Lahir</th>
                        <th>Jenis kelamin</th>                                                
                        <th>Alamat</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${dosenlist}" var="dosen">
                        <tr>
                            <td>${dosen.nip}</td>
                            <td>${dosen.dosen}</td>
                            <td>${dosen.tanggalLahir}</td>
                            <td>${dosen.jenisKelamin}</td>                                                        
                            <td>${dosen.alamat}</td>
                            <td> <a href="updateDosen.do?ds_id=${dosen.nip}" class="btn btn-info">Update</a> 
                                <a href="deleteDosen.do?ds_id=${dosen.nip}" class="btn btn-danger confirmation">Delete</a> </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="inputDosen.do" class="btn btn-default center-block"><b>INPUT DOSEN</b></a>
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
