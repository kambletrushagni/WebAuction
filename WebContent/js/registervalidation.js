
    var userid=document.forms["vform"]["userp"];
    var pwd=document.forms["vform"]["passp"];
    var email=document.forms["vform"]["email"];
    
    var userid_error=document.getElementId("userid_error");
    var pwd_error=document.getElementId("pwd_error");
    var email_error=document.getElementId("email_error");
    
    userid.addEventListener("blur", idVerify, true);
    pwd.addEventListener("blur", pwdVerify, true);
    email.addEventListener("blur", emailVerify, true);
    
    function Validate(){
        if (userid.value == "" ){
            userid.style.border = "1px solid red";
            userid_error.textcontent= "UserId is required";
            userid.focus();
            return false;
        }
         if (pwd.value == "" ){
            pwd.style.border = "1px solid red";
            pwd_error.textcontent= "Password is required";
            pwd.focus();
            return false;
        }
        if (email.value == "" ){
            email.style.border = "1px solid red";
            email_error.textcontent= "Email is required";
            email.focus();
            return false;
        }
    }
    function idVerify(){
        if(userid.value !="") {
            useid.style.border = "1px solid #5E6E66";
            userid_error.innerHtml = "";
            return true;
        }
    }
    function pwdVerify(){
        if(pwd.value !="") {
            pwd.style.border = "1px solid #5E6E66";
            pwd_error.innerHtml = "";
            return true;
        }
    }
    function emailVerify(){
        if(email.value !="") {
            email.style.border = "1px solid #5E6E66";
            email_error.innerHtml = "";
            return true;
        }
    }
   