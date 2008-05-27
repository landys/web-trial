<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/includes/taglibs.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content=""/>
<meta name="keywords" content="" />
<title>火种电话本</title>
<link rel="stylesheet" href="themes/public.css" type="text/css" media="screen" />
<link rel="stylesheet" href="themes/seal.css" type="text/css" media="screen" />
<script src="scripts/library/jquery.js"></script>
<script src="scripts/seal.js"></script>
</head>

<body id="itsIndex">

<div id="header">
	<div id="logo"><a href=""><img src="images/logo.jpg" alt="火种LOGO，最专业/安全的电话本服务" /></a></div>
	<div id="what">
		<a href="">什么是火种？</a> 世界上最好的电话本
	</div>
</div>

<div id="menu">
	<div>
		<ul>
			<li class="curr"><a href="">主页</a></li>
			<li><a href="">我的火种</a></li>
			<li><a href="">下载</a></li>
			<li><a href="">怎样用</a></li>
			<li><a href="">关于</a></li>
		</ul>
	</div>
</div>

<div id="package"><div id="main">
	<div id="sign">
		<h2>火种封闭测试报名</h2>
		<div id="applyErrorMessage" class="errorMessage">
			<span>&nbsp;</span>
			<a href="#" onclick="hideErrorMessage('applyErrorMessage');">Close Error Box</a>
		</div>
		<form id="applyForm">
			<dl>
				<dt>邮箱：</dt>
				<dd><input id="email" type="text" class="text" /></dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd><input id="fullName" type="text" class="text" /></dd>
			</dl>
			<dl>
				<dt>手机：</dt>
				<dd><input id="mobilephone" type="text" class="text" /></dd>
			</dl>
			<div class="submit"><button type="button" onclick="doApply();" class="btn">报名</button></div>
		</form>
	</div>
	<div id="entry">
		<div id="tryErrorMessage" class="errorMessage">
			<span>&nbsp;</span>
			<a href="#" onclick="hideErrorMessage('tryErrorMessage');">Close Error Box</a>
		</div>
		<form id="tryForm">
		<label>输入手机号进入封闭测试：</label>
		<input id="tryMobilephone" type="text" class="text" />
		<div class="submit"><button type="button" onclick="doTry();" class="btn">立即体验火种！</button></div>
		</form>
	</div>
	<div id="message">
		<div id="message-m">
			<p class="tip"></p>
			<button class="btn" onclick="hideMessage();">确定</button>
		</div>
		<b id="message-fix"></b>
		<p class="close"><a href="#" title="关闭" onclick="hideMessage();">关闭</a></p>
	</div>

	<div id="ing"></div>
	<div id="flash">
		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="383" height="316">
			<param name="movie" value="media/tour.swf" />
			<param name="quality" value="high" />
			<param name="bgcolor" value="#ffffff" />
			<param name="wmode" value="opaque" />
		<embed src="media/tour.swf" wmode="opaque" quality="high" width="383" height="316" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
		</object>
	</div>
</div></div>

<div id="footer">
	<p>Copyright &copy; 2007-2008 ww.<b>ho</b><span>zom</span>.com. All Rights Reserved.</p>
</div>
<div class="ad">
<script type="text/JavaScript"> 
alimama_pid="mm_10002137_1042378_2281341"; 
alimama_titlecolor="0000FF"; 
alimama_descolor ="000000"; 
alimama_bgcolor="FFFFFF"; 
alimama_bordercolor="E6E6E6"; 
alimama_linkcolor="008000"; 
alimama_bottomcolor="FFFFFF"; 
alimama_anglesize="0"; 
alimama_bgpic="0"; 
alimama_icon="0"; 
alimama_sizecode="12"; 
alimama_width=468; 
alimama_height=60; 
alimama_type=2; 
</script> 
<script src="http://a.alimama.cn/inf.js" type=text/javascript></script>
</div>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
var pageTracker = _gat._getTracker("UA-xxxxxx-x");
pageTracker._initData();
pageTracker._trackPageview();
</script>
</body>
</html>