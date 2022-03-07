<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<header class="header-section">
	<div class="header-top">
		<div class="container">
			<div class="ht-left">
				<div class="mail-service">
					<i class=" fa fa-envelope"></i> ${id}
				</div>
				<div class="phone-service">
					<i class=" fa fa-phone"></i> ${name}
				</div>
			</div>
			<div class="ht-right">
			<c:if test='${empty id }'>
				<a href="loginForm.do" class="login-panel">			
				<i class="fa fa-user"></i>Login</a>
			</c:if>
			<c:if test='${not empty id }'>
				<a href="logOut.do" class="login-panel">			
				<i class="fa fa-user"></i>Logout</a>
			</c:if>	
			<c:if test='${not empty id }'>
				<a href="mypage.do" class="login-panel" style="padding-right: 15px">			
				<i class="fa fa-user"></i>My Page</a>
			</c:if>	
												
				
				<div class="top-social">
					<a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
						class="ti-twitter-alt"></i></a> <a href="#"><i class="ti-linkedin"></i></a>
					<a href="#"><i class="ti-pinterest"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="inner-header">
			<div class="row">
				<div class="col-lg-2 col-md-2">
					<div class="logo">
						<a href="index.jsp"> <img src="img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-7 col-md-7">
					<div style="margin-top: 10px" class="advanced-search">
						<button type="button" class="category-btn">All Categories</button>
						<div class="input-group">
							<form action="search.do" name="pSearch" method="get"
								value="${param.pSearch}">
								<input type="text" name="psearch"
									placeholder="What do you need?">
								<button type="button">
									<i class="ti-search"></i>
							</form>
							</button>
						</div>
					</div>
				</div>
				<div class="col-lg-3 text-right col-md-3">
					<ul class="nav-right">
						<li class="heart-icon"><a href="#"> <i
								class="icon_heart_alt"></i> <span>1</span>
						</a></li>
						<li class="cart-icon"><a href="#"> <i
								class="icon_bag_alt"></i> <span>3</span>
						</a>
							<div class="cart-hover">
								<div class="select-items">
									<table>									
										<c:forEach items="${cartList }" var="list">																				
												<tbody>
													<tr>
														<td class="si-pic"><img src="upload/${list.image}"
															alt=""></td>
														<td class="si-text">
															<div class="product-selected">
																<p>${list.bookPrice }</p>
																<h6>${list.bookName }</h6>
															</div>
														</td>
														<td class="si-close"><i class="ti-close"></i></td>
													</tr>
												</tbody>											
										</c:forEach>
									</table>
								</div>
								<div class="select-total">
									<span>total:</span>
									<h5>$120.00</h5>
								</div>
								<div class="select-button">
									<a href="#" class="primary-btn view-card">VIEW CARD</a> <a
										href="#" class="primary-btn checkout-btn">CHECK OUT</a>
								</div>
							</div></li>
						<li class="cart-price">$150.00</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="nav-item">
		<div class="container">
			<div class="nav-depart">
				<div class="depart-btn">
					<i class="ti-menu"></i> <span>All departments</span>
					<ul class="depart-hover">
						<li class="active"><a href="#">Women’s Clothing</a></li>
						<li><a href="#">Men’s Clothing</a></li>
						<li><a href="#">Underwear</a></li>
						<li><a href="#">Kid's Clothing</a></li>
						<li><a href="#">Brand Fashion</a></li>
						<li><a href="#">Accessories/Shoes</a></li>
						<li><a href="#">Luxury Brands</a></li>
						<li><a href="#">Brand Outdoor Apparel</a></li>
					</ul>
				</div>
			</div>
			<nav class="nav-menu mobile-menu">
				<ul>
					<li><a href="newBook.do">화제의 신간</a></li>
					<li><a href="koreaBook.do">국내도서</a></li>
					<li><a href="foreignBook.do">해외도서</a>										
					<li><a href="queryboard.do">문의 게시판</a></li>
				</ul>
			</nav>
			<div id="mobile-menu-wrap"></div>
		</div>
	</div>
</header>
