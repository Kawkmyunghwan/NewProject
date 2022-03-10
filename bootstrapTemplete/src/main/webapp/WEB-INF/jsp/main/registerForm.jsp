<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Register Section Begin -->

<script>
	$(function () {
		$('#id').change(function () {
			$('#idCheck').val('unChecked');
		});

		//idCheck 버튼을 클릭했을 때 
		$("#idCheck").click(function () {
			var userid = $("#id").val();

			$.ajax({
				type: 'POST',
				data: {
					id: userid
				},
				url: "ajaxIdCheck", //별도 서블릿으로 만들었다. *.do에서 제외(컨트롤러 안탐)
				success: function (data) {
					if (data > 0) {
						alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
						$("#id").val("");
						$("#id").focus();
					} else {
						alert("사용가능한 아이디입니다.");
						$("#idCheck").val("checked");
						$("#password").focus();
					}
				},
				error: function (error) {
					alert("error : " + error);
				}
			});
		});
	});
</script>

<script type="text/javascript">
	function formCheck() {
		if (frm.id.value == "") {
			alert("아이디를 입력하세요.");
			frm.id.focus();
			return false;
		}

		if (frm.idCheck.value == "unChecked") {
			alert("아이디 중복체크를 하세요.");
			return false;
		}

		if (frm.password.value == "") {
			alert("패스워드를 입력하세요.");
			frm.password.focus();
			return false;
		}

		frm.submit();
	}

	function idCheckDo() {
		var id = frm.id.value;
		window.open("/DbTest/idCheck.do?id=" + id, "childForm", "width=570, height=350, resizable = no, scrollbars = no");

	}
</script>

    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                        <h2>Register</h2>
                        <form class="user" id="frm" name="frm" action="register.do" method="post">
                            <div class="group-input">
                                <label for="username">Username or email address *</label>
                                <input type="text" id="id" name="id">
                                <button type="button" class="btn btn-sm btn-primary" id="idCheck" name="idCheck" value="unChecked">중복체크</button>
                            </div>
                            <input type="hidden" id="author" name="author" value="USER">
                            <div class="group-input">
                                <label for="pass">Password *</label>
                                <input type="password" id="passwordd" name="password">
                            </div>
                            <div class="group-input">
                                <label for="con-pass">Confirm Password *</label>
                                <input type="text" id="password1" name="password1">
                            </div>
                            <div class="group-input">
                                <label for="con-pass">name *</label>
                                <input type="text" id="name" name="name">
                            </div>
                            <div class="group-input">
                                <label for="con-pass">Tel</label>
                                <input type="text" id="tel" name="tel">
                            </div>
                            <div class="group-input">
                                <label for="con-pass">Address</label>
                                <input type="text" id="address" name="address">
                            </div>
                            <button type="submit" onclick="formCheck()" class="site-btn register-btn">REGISTER</button>
                        </form>
                        <div class="switch-login">
                            <a href="loginForm.do" class="or-login">Or Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->
    