// user
var user_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;
var cid_Boolean = false;
var Mobile_Boolean = false;
var name_Boolean = false;
//uname
$('.reg_user').blur(function(){
  if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())){
    $('.user_hint').html("完成").css("color","green");
    user_Boolean = true;
  }else {
    $('.user_hint').html("无效").css("color","red");
    user_Boolean = false;
  }
});
// password
$('.reg_password').blur(function(){
  if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())){
    $('.password_hint').html("完成").css("color","green");
    password_Boolean = true;
  }else {
    $('.password_hint').html("无效").css("color","red");
    password_Boolean = false;
  }
});


// password_confirm
$('.reg_confirm').blur(function(){
  if (($(".reg_password").val())==($(".reg_confirm").val())){
    $('.confirm_hint').html("完成").css("color","green");
    varconfirm_Boolean = true;
  }else {
    $('.confirm_hint').html("无效").css("color","red");
    varconfirm_Boolean = false;
  }
});
//name
$('.reg_name').blur(function(){
    if ((/^[\u4E00-\u9FA5]{2,4}$/).test($(".reg_name").val())){
        $('.name_hint').html("完成").css("color","green");
        name_Boolean = true;
    }else {
        $('.name_hint').html("无效").css("color","red");
        name_Boolean = false;
    }
});

// Mobile
$('.reg_mobile').blur(function(){
  if ((/^1[34578]\d{9}$/).test($(".reg_mobile").val())){
    $('.mobile_hint').html("完成").css("color","green");
    Mobile_Boolean = true;
  }else {
    $('.mobile_hint').html("无效").css("color","red");
    Mobile_Boolean = false;
  }
});
//cid
$('.reg_cid').blur(function(){
    if ((/^[0-9]{18}$/).test($(".reg_cid").val())){
        $('.cid_hint').html("完成").css("color","green");
        cid_Boolean = true;
    }else {
        $('.cid_hint').html("无效").css("color","red");
       cid_Boolean = false;
    }
});
