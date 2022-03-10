<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 align="center">구매완료 되었습니다.</h1>

<div class="container-fluid" style="width: 1200px">

	<!-- Page Heading -->
	<h1 style="padding-top: 15px" class="h3 mb-2 text-gray-800">마이페이지</h1>



	<!-- DataTales Example -->
	
	
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">구매목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
			<form action="mypage.do" method="get">
			<input type="hidden" value="${buyCartList }">			
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>name</th>
							<th>price</th>
							<th>company</th>
							<th>img</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>name</th>
							<th>price</th>
							<th>Company</th>
							<th>img</th>
						</tr>
					</tfoot>
					
					<tbody>
									
							<c:forEach items="${buyCartList }" var="list2">
								<tr>
									<th>${list2.bookName }</th>
									<th>${list2.bookPrice }</th>
									<th>${list2.bookCompany }</th>
									<td><img src="upload/${list2.image}" width="150" alt=""></td>
								</tr>
							</c:forEach>						
					</tbody>					
				</table>				
				</form>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->