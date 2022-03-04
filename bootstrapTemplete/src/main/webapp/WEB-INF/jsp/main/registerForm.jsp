<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                        <h2>Register</h2>
                        <form class="user" id="frm" action="register.do" onsubmit="return formCheck()" method="post">
                            <div class="group-input">
                                <label for="username">Username or email address *</label>
                                <input type="text" id="id" name="id">
                                <button type="button" class="btn btn-sm btn-primary" onclick="idCheckCall()" id="idCheck" value="No">중복체크</button>
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
                            <button type="submit" class="site-btn register-btn">REGISTER</button>
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
    <script type="text/javascript">
	 function formCheck() {
	      if(frm.idCheck.value != 'Yes') {
	         alert("아이디 중복체크를 하세요.");
	         return false;
	      }
	      
	      if(frm.password.value == ""){
	    	  alert("패스워드를 입력해주세요.")
	    	  frm.password.focus();
	    	  return false;
	      }
	      
	      if(frm.name.value == ""){
		    	  alert("이름을 입력해주세요..")
		    	  frm.name.focus();
		    	  return false;
		      }
	      
	      if(frm.password.value != frm.password1.value) {  //패스워드 일치확인 함수
	         alert("패스워드가 일치 하지 않습니다.");
	         frm.password.value="";
	         frm.password1.value="";
	         frm.password.focus();
	         return false;
	      }
	      return true;
	   }

   
   function idCheckCall() {  //ajax로 아이디를 중복체크 하는함수
      const xhttp = new XMLHttpRequest();  //ajax 객체를 생성
      const id = frm.id.value;
      xhttp.onreadystatechange = function() {  //ajax가 동작될 때 실행하는 메소드
         if(xhttp.readyState==4){  //통신이 연결되서 데이터가 다 전달되었다면
            if(xhttp.status==200){  // 정상적으로 수행되고 결과가 왔을때
               var b = xhttp.responseText;
               if(b == '1' ) {
                  alert(id + "는 사용가능한 아이디 입니다.");
                  frm.idCheck.value="Yes";
                  frm.idCheck.style.display="none";
                  frm.password.focus();
               } else {
                  alert(id + "는 이미 존재하는 아이디 입니다.");
                  frm.id.value="";
                  frm.focus();
               }
            }
         }
      }
      xhttp.open("GET","ajaxIdCheck.do?id=" +id);  // 호줄해야할 방법과 주소
      xhttp.send();  // 호출하는 부분
   }
   
</script>