<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th class="p-name">Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th><i class="ti-close"></i></th>
                                </tr>
                            </thead>

						<c:forEach items="${cartList }" var="list">
							<c:if test="${list.id == id}">
								<tbody>
									<tr>
										<td class="cart-pic first-row"><img src="upload/${list.image}" alt=""></td>
										<td class="cart-title first-row">
											<h5>${list.bookName}</h5>
										</td>
										<td class="p-price first-row">${list.bookPrice}</td>
										<td class="qua-col first-row">
											<div class="quantity">
												<div class="pro-qty">
													<input type="text" value="1">
												</div>
											</div>
										</td>
										<td class="total-price first-row">${list.bookPrice}</td>
										<td class="close-td first-row"><i class="ti-close"></i></td>
									</tr>
								</tbody>
							</c:if>
						</c:forEach>

					</table>     
					${cartList }                                         
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="#" class="primary-btn continue-shop">Continue shopping</a>
                                <a href="#" class="primary-btn up-cart">Update cart</a>
                            </div>
                            <div class="discount-coupon">
                                <h6>Discount Codes</h6>
                                <form action="#" class="coupon-form">
                                    <input type="text" placeholder="Enter your codes">
                                    <button type="submit" class="site-btn coupon-btn">Apply</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <li class="subtotal">Subtotal <span>$240.00</span></li>
                                    <li class="cart-total">Total <span>$240.00</span></li>
                                </ul>
                               		<a href="javascript:goPage()" class="proceed-btn">PROCEED TO CHECK OUT</a>
                               		<c:forEach items="${cartList }" var="list">
                               			<input type="hidden" id="list" name="list" value="${list.bookId }">                             			
                              		</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
<script>
	function goPage(page) {
		location.href = "checkout.do?bookId=" + page;
	}
</script>
<!-- Shopping Cart Section End -->