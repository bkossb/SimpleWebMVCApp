<!DOCTYPE html>
<html>
<head>
    <title>Content from JSP</title>
</head>
<body>
<form action="/login.do" method="post">

    Name: <input type="text" name="name"> Password: <input type="password" name="password"><input type="submit"
                                                                                                  value="SEND">

</form>
<p>${errorMessage}</p>
</body>
</html>
