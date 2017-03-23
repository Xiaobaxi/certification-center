<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>登录</title>
</head>
<body>
<div class="loginBox">
    <div class="header">
        <div class="birdIcon fl"></div>
        <span>认证中心</span>
    </div>
    <div class="container">
        <form action="${rs.contextPath}/login.html" method="post">
        <p>用户名：</p>
        <div class="userName common">
            <i class="nameIcon iconCommon"></i>
            <input type="text" name="principalId" id="username" autocomplete="off" placeholder="请输入用户名" tabindex="1"/>
        </div>
        <p>密码：</p>
        <div class="userPassword common">
            <i class="passwdIcon iconCommon"></i>
            <input type="password" name="certificates['up']" id="password" autocomplete="off" placeholder="请输入密码" tabindex="2"/>
        </div>
        <div class="rememberName" style="visibility: hidden;">
            <input type="checkbox" >
            <span>记住用户名</span>
        </div>
        <div class="loginButton common">
            <span>登录</span>
            <input type="submit" value="submit" />
        </div>
        </form>
    </div>
</div>
</body>
</html>