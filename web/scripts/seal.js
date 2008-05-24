var doApply = function() {
	if (apply_validate()) {
		$.ajax({type: 'POST', 
			url: 'apply.rmt',
			data: {email:$('#email').val(), 
				fullName:$('#fullName').val(), 
				mobilephone:$('#mobilephone').val()},
			dataType: "text",
			success: function(message) {
				if ($.trim(message) != "") {
					if (message == "Y") {
						$('#message').attr("class", "message-ok");
						$('#message-m p').html('感谢您的报名，我们会尽快审核并<br />邀请您的参与！');
					} else {
						$('#message').attr("class", "message-sorry");
						$('#message-m p').html(message);
					}
				} else {
					$('#message').attr("class", "message-sorry");
					$('#message-m p').html("连接出错，请检查网络。");
				}
				$('#flash').css('display', 'none');
				$('#message').css("display", "block");
			}});
		clearForm();
	}
};

var doTry = function() {
	if (try_validate()) {
		$.ajax({type: 'POST', 
			url: 'trial.rmt',
			data: {tryMobilephone:$('#tryMobilephone').val()},
			dataType: "text",
			success: function(message) {
				if ($.trim(message) != "") {
					if (message == "Y") {
						$('#message-m p').html('抱歉，测试名单中没有您的手机号，<br />请报名参加封闭测试!');
					} else {
						$('#message-m p').html(message);
					}
				} else {
					$('#message-m p').html("连接出错，请检查网络。");
				}
				$('#flash').css('display', 'none');
				$('#message').attr("class", "message-sorry");
				$('#message').css("display", "block");
			}});
		clearForm();
	}
};

var clearForm = function() {
	hideErrorMessage('applyErrorMessage');
	hideErrorMessage('tryErrorMessage');
	$('#email').val('');
	$('#fullName').val('');
	$('#mobilephone').val('');
	$('#tryMobilephone').val('');
};

var hideMessage = function() {
	$('#message').css('display', 'none');
	$('#flash').css('display', 'block');
}

var validate_require = function(data) {
    return ($.trim(data).length > 0);
};

var phone_pattern = /^1[35]\d{9}$/;
var validate_phonenumber = function(data) {
    var v = $.trim(data);
    return (v != '' && phone_pattern.test(v));
};

var email_pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var validate_email = function(data) {
    var v = $.trim(data);
    return (v != '' && email_pattern.test(v));
};

var showErrorMessage = function(divId, message) {
	var div = $('#'+divId);
	var span = $('#'+divId+' span');
	span.text(message);
	div.css('visibility', 'visible');
};

var hideErrorMessage = function(divId) {
	var div = $('#'+divId);
	var span = $('#'+divId+' span');
	span.text('&nbsp;');
	div.css('visibility', 'hidden');
};

var apply_validate = function() {
	return email_validate() && fullName_validate() && mobilephone_validate();
};

var email_validate = function() {
	var re = false;
	var divId = 'applyErrorMessage';
	if (!validate_email($('#email').val())) {
		showErrorMessage(divId, 'Email格式错误，如i@g.com');
	} else {
		hideErrorMessage(divId);
		re = true;
	}
	return re;
};

var fullName_validate = function() {
	var re = false;
	var divId = 'applyErrorMessage';
	if (!validate_require($('#fullName').val())) {
		showErrorMessage(divId, '必须填写姓名信息');
	} else {
		hideErrorMessage(divId);
		re = true;
	}
	return re;
};

var mobilephone_validate = function () {
	var re = false;
	var divId = 'applyErrorMessage';
	if (!validate_phonenumber($('#mobilephone').val())) {
		showErrorMessage(divId, '手机格式错误，如13777345678');
	} else {
		hideErrorMessage(divId);
		re = true;
	}
	return re;
};

var try_validate = function() {
	var divId = 'tryErrorMessage';
	var re = false;
	if (!validate_phonenumber($('#tryMobilephone').val())) {
		showErrorMessage(divId, '手机格式错误，如13777345678');
	} else {
		hideErrorMessage(divId);
		re = true;
	}
	return re;
};

$(function() {
	clearForm();
	//$('#email').blur(email_validate);
	//$('#fullName').blur(fullName_validate);
	//$('#mobilephone').blur(mobilephone_validate);
	//$('#tryMobilephone').blur(try_validate);
});