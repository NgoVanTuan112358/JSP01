var check1 = 0;
var check2 = 0;
var check3 = 0;
var city;

//CHECK PERSON
function checkRadio1(){
	check1 = 1;
}

//CHECK HCM CITY
function checkHcm(){
	check2 = 1;
	city = "hcm";
}

//CHECK OTHER CITY
function checkOther(){
	check2 = 1;
	city = "other";
}

//CHECK GENNER
function checkGenner(){
	check3 = 1;
}

//SHOW PASSWORD
function showP(){
	var type = document.getElementById("password").type;
	
	if(type == "password"){
	
	document.getElementById("password").type = "text";
	document.getElementById("repassword").type = "text";
	
	}else if(type == "text"){
	
	document.getElementById("password").type = "password";
	document.getElementById("repassword").type = "password";
	
	}
	
}

//CHECK STRONG PASSWORD
function checkPass(){
	var pass = document.getElementById("password").value;
	var test = 0;
	var note = "";
	
	var len = pass.length;
	var pattNum = /[0-9]/;
	var pattLower = /[a-z]/;
	var pattUpper = /[A-Z]/;
	var pattSpecial = /[!@#$%^&*()<>]/;
	
	document.getElementById("notePass").innerHTML = "Mật khẩu yếu";
	
	if(len >= 8){
		if((pattLower.test(pass)) && (pattUpper.test(pass)) && (pattSpecial.test(pass)) && (pattNum.test(pass))){
			document.getElementById("notePass").innerHTML = "Mật khẩu rất mạnh";
		}else {
			document.getElementById("notePass").innerHTML = "Mật khẩu mạnh";
	}
	}	
}

//VALIDATE AFTER SUBMIT
function validate(){
	var checkPerson = true;
	var checkName = true;
	var checkPhone = true;
	var checkDate = true;
	var checkAddress = true;
	var checkCity = true;
	var checkGenner = true;
	var checkEmail = true;
	var checkPassword = true;
	
	//VALIDATE PERSON
	if(check1 == 0){
		document.getElementById("valPerson").innerHTML = "Vui lòng chọn cá nhân hoặc công ty(tổ chức)";
		checkPerson = false;
	}
	
	var name = document.getElementById("name").value;
	
	//VALIDATE NAME
	if(name == "" || name == null){
		document.getElementById("nameError").innerHTML = "Vui lòng nhập tên của bạn";
		checkName = false;
	}
	
	//VALIDATE PHONE
	var phone = document.getElementById("phone").value;
	
	if(phone == "" || phone == null){
		document.getElementById("phoneError").innerHTML = "Vui lòng nhập số điện thoại của bạn";
		checkPhone = false;
	}else{
	var len = phone.length;
	
	for( var i = 0; i<len; i++){
		var phoneNum = Number(phone[i]);
		
		if(isNaN(phoneNum)){
			document.getElementById("phoneError").innerHTML = "Số điện thoại không hợp lệ";
			checkPhone = false;
			break;
		}
	}
	}
	
	//VALIDATE BIRTHDATE
	var birth = document.getElementById("birthdate").value;
	
	if(birth == "" || birth == null){
		document.getElementById("dateError").innerHTML = "Vui lòng nhập ngày sinh của bạn";
		checkDate = false;
	}else{
		var patt = /[0-3][0-9]-(0|1)[0-9]-(1|2)[0-9][0-9][0-9]/;
		if(patt.test(birth)){
			
			var arr = birth.split("-");
			
			var date = Number(arr[0]);
			var month = Number(arr[1]);
			var year = Number(arr[2]);
				
			var d = new Date();
			var yearNow = d.getFullYear();
				
				
			if(date > 31 || month > 12 || year > yearNow){
				document.getElementById("dateError").innerHTML = "Ngày sinh không hợp lệ";
				checkDate = false;
			}else if(month == 2){
				if(date > 29){
					document.getElementById("dateError").innerHTML = "Tháng 2 không có ngày"+date;
					checkDate = false;
			}
			
		}else{
			document.getElementById("dateError").innerHTML = "Ngày sinh không hợp lệ, phải có dạng dd/mm/yyyy";
			checkDate = false;
		}
}
	}
	
	
	//VALIDATE ADDRESS
	var address = document.getElementById("address").value;
	
	if(address == "" || address == null){
		document.getElementById("cityError").innerHTML = "Vui lòng nhập địa chỉ của bạn";
		checkAddress = false;
	}
	
	//VALIDATE CITY
	if(check2 == 0){
		document.getElementById("cityError").innerHTML = "Vui lòng chọn thành phố";
		checkCity = false;
	}else if(city == "hcm"){
		var district = document.getElementById("district").value;
		
		if(district == ""){
			document.getElementById("nameError").innerHTML = "Vui lòng chọn quận của bạn";
			checkCity = false;
		}
	}else if(city == "other"){
		var otherCity = document.getElementById("cityOther").value;
		
		if(otherCity == ""){
			document.getElementById("nameError").innerHTML = "Vui lòng chọn tên thành phố của bạn";
			checkCity = false;
		}
	}
	
	//VALIDATE GENNER
	if(check3 == 0){
		document.getElementById("gennerError").innerHTML = "Vui lòng chọn giới tính của bạn";
		checkGenner = false;
	}
	
	//VALIDATE EMAIL
	var pattEmail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	var email = document.getElementById("email").value;
	
	if(!pattEmail.test(email)){
		document.getElementById("emailError").innerHTML = "Email không hợp lệ, vui lòng nhập lại";
		checkEmail = false;
	}
	
	//VALIDATE PASSWORD
	var myPass = document.getElementById("password").value;
	var rePass = document.getElementById("repassword").value;
	
	if(myPass !== rePass){
		document.getElementById("passError").innerHTML = "Mật khẩu không trùng khớp, vui lòng nhập lại";
		checkPassword = false;
	}
	
	if(checkPerson && checkName && checkPhone && checkDate && checkAddress && checkCity && checkGenner && checkEmail && checkPassword){
		return true;
	}else{
		return false;
	}
}