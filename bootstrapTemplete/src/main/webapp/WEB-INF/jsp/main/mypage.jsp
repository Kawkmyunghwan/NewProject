<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid" style="width: 1200px">

	<!-- Page Heading -->
	<h1 style="padding-top: 15px" class="h3 mb-2 text-gray-800">마이페이지</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원정보</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>주소</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>주소</th>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">장바구니</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
			<form action="checkoutcart.do" method="get">
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
									
							<c:forEach items="${cartList }" var="list">
								<tr>
									<th>${list.bookName }</th>
									<th>${list.bookPrice }</th>
									<th>${list.bookCompany }</th>
									<td><img src="upload/${list.image}" width="150" alt=""></td>
								</tr>
							</c:forEach>
							
					</tbody>
				</table>
				<button style="float: right">구매하기</button>
				</form>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

            
