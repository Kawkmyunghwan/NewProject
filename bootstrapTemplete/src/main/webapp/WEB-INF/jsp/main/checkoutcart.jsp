<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Shopping Cart Section Begin -->
<section class="checkout-section spad">
	<div class="container">
	<form action="mainListPaging.do" class="checkout-form" name="frm1" method="get">
	</form>
		<form class="checkout-form" >
			<input type="hidden" name="cartListBookId">
			<div class="row">
				<div class="col-lg-6">
					<div class="checkout-content">
						<a href="#" class="content-btn">Click Here To Login</a>
					</div>
					<h4>Biiling Details</h4>
					<div class="row">
						<div class="col-lg-6">
							<label for="fir">First Name<span>*</span></label> <input
								type="text" id="fir">
						</div>
						<div class="col-lg-6">
							<label for="last">Last Name<span>*</span></label> <input
								type="text" id="last">
						</div>
						<div class="col-lg-12">
							<label for="cun-name">Company Name</label> <input type="text"
								id="cun-name">
						</div>
						<div class="col-lg-12">
							<label for="cun">Country<span>*</span></label> <input type="text"
								id="cun">
						</div>
						<div class="col-lg-12">
							<label for="street">Street Address<span>*</span></label> <input
								type="text" id="street" class="street-first"> <input
								type="text">
						</div>
						<div class="col-lg-12">
							<label for="zip">Postcode / ZIP (optional)</label> <input
								type="text" id="zip">
						</div>
						<div class="col-lg-12">
							<label for="town">Town / City<span>*</span></label> <input
								type="text" id="town">
						</div>
						<div class="col-lg-6">
							<label for="email">Email Address<span>*</span></label> <input
								type="text" id="email">
						</div>
						<div class="col-lg-6">
							<label for="phone">Phone<span>*</span></label> <input type="text"
								id="phone">
						</div>
						<div class="col-lg-12">
							<div class="create-item">
								<label for="acc-create"> Create an account? <input
									type="checkbox" id="acc-create"> <span
									class="checkmark"></span>
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="checkout-content">
						<input type="text" placeholder="Enter Your Coupon Code">
					</div>
					<div class="place-order">
						<h4>Your Order</h4>
						<div class="order-total">
							<ul class="order-table">
								<li>Product <span>Total</span></li>
								<c:forEach items="${cartList }" var="list">
									<li class="fw-normal">Combination x 1 <span>${list.bookName}</span></li>
									<li class="fw-normal">Subtotal <span>${list.bookPrice}</span></li>
								</c:forEach>
								<li class="total-price">Total <span>??</span></li>
							</ul>
							</form>
							<div class="payment-check">
								<div class="pc-item">
									<label for="pc-check"> Cheque Payment <input
										type="checkbox" id="pc-check"> <span class="checkmark"></span>
									</label>
								</div>
								<div class="pc-item">
									<label for="pc-paypal"> Paypal <input type="checkbox"
										id="pc-paypal"> <span class="checkmark"></span>
									</label>
								</div>
							</div>
						<form action="end.do" name="frm" id="frm" method="get">													
							<div class="order-btn">							
								<button type="submit" onclick="requestPay()" id="btn"
									class="site-btn place-btn">Place Order</button>																																																	
							</div>
								<c:forEach items="${cartList }" var="list">	
									<input type="hidden" name="bookId" value="${list.bookId}">
								</c:forEach>
						</form>
						</div>
					</div>
				</div>
			</div>			
	</div>
</section>
<!-- Shopping Cart Section End -->

<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	
    var IMP = window.IMP;
    IMP.init("imp66037800"); // "iamport
    
    //function requestPay() {
    	//event.preventDefault();
       // IMP.request_pay(param, callback) 결제창 호출
        IMP.request_pay({
			pg: 'kakaopay',
            pay_method: 'kakaopay',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: "노르웨이 회전 의자",
            amount: 64900,
            buyer_email: "gildong@gmail.com",
            buyer_name: "홍길동",
            buyer_tel: "010-4242-4242",
            buyer_addr: "서울특별시 강남구 신사동",
            buyer_postcode: "01181"
        }, function (rsp) { // callback
            if (rsp.success) {
            	alert('결제성공')
                frm.submit();              
            } else {              	
                alert('결제실패')
                frm1.submit();
            }
        });
        
        //document.getElementById("btn").addEventListener('click', requestPay);
             	       
    </script>    