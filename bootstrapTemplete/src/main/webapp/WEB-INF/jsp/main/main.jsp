<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="product-shop spad">
	<div class="container">
		<div class="row">
			<div
				class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
			</div>
		</div>
		<div class="col-lg-9 order-1 order-lg-2">
			<div class="product-show-option">
				<div class="row">
					<div class="col-lg-7 col-md-7">
						<div class="select-option">
							<select class="sorting">
								<option value="">Default Sorting</option>
							</select> <select class="p-show">
								<option value="">Show:</option>
							</select>
						</div>
					</div>
					<div class="col-lg-5 col-md-5 text-right">
						<p>Show 01- 09 Of 36 Product</p>
					</div>
				</div>
			</div>
			<form action="quickbuy.do" method="get" name="quickFrm">
				<input type="hidden" name="bookId">
			</form>
			
			<form action="detailproduct.do" method="get" name="quickFrm1">
				<input type="hidden" name="bookId">
			</form>
			
			<form action="quickcart.do" method="get" name="quickFrm2">
				<input type="hidden" name="bookId">
			</form>
			
			<div class="product-list">
				<div class="row">				
					<c:forEach items="${bookList}" var="list">
						<div class="col-lg-4 col-sm-6">
							<div class="product-item">
								<div class="pi-pic">
									<img src="upload/${list.image}" onclick='formFnc1(${list.bookId})' alt="">
									<div class="sale pp-sale">Sale</div>
									<div class="icon">
										<i class="icon_heart_alt"></i>
									</div>
									<ul>
										<li class="w-icon active"><a href="" onclick='formFnc2(${list.bookId})'> <i
												class="icon_bag_alt"></i></a></li>
										<li class="quick-view">
											<button onclick='formFnc(${list.bookId})'>바로 구매</button>
										</li>
										<li class="w-icon"><a href="#"><i
												class="fa fa-random"></i></a></li>
									</ul>
								</div>
								<div class="pi-text">
									<div class="catagory-name">${list.bookCompany }</div>
									<a href="#">
										<h5>${list.bookName }</h5>
									</a>
									<div class="product-price">
										₩ ${list.bookPrice } <span></span>
									</div>
									<input type="hidden" id="bookId" name="bookId" value="${list.bookId}">
								</div>
							</div>
						</div>					
					</c:forEach>				
				</div>
			</div>
			<div>
		<div class="paginate" align="center">
			<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a>
			<a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a>
			<span>
				<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
					<c:choose>
						<c:when test="${i eq paging.pageNo}">
							<a href="javascript:goPage(${i})" class="choice">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:goPage(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</span>
			<a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a>
			<a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
		</div>
	</div>
		</div>
	</div>
</section>

<script>
function formFnc(book_id) {
	event.preventDefault();
	console.log(book_id)
	quickFrm.bookId.value=book_id;
	quickFrm.submit();
}

function formFnc1(book_id) {
	if(${id != null}){
		event.preventDefault();
		console.log(book_id)
		quickFrm1.bookId.value=book_id;
		quickFrm1.submit();
	}else{
		alert("로그인 하세요.")
		location.href = "loginForm.do";
	}
}
function formFnc2(book_id) {
	if(${id != null}){
		event.preventDefault();
		console.log(book_id)
		quickFrm2.bookId.value=book_id;
		quickFrm2.submit();
	}else{
		alert("로그인 하세요.")
		location.href = "loginForm.do";
	}
}




function goPage(page) {
	location.href = "mainListPaging.do?page=" + page;
}

</script>