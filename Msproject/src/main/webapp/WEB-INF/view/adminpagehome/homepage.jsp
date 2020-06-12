<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
欢迎商家：${msmerchant.merchantaccount}
<a href="/Msproject/msmerchantReloginAction/toregiter">商家注册</a></br>
<a href="/Msproject/msmerchantReloginAction/tologin">商家登录</a>
<a href="/Msproject/msmerchantReloginAction/exit">商家退出登录</a>
<a href="/Msproject/orderAction/queryorderbyMsmerchanid">订单查询</a>
</body>
</html>