<%--
  Created by IntelliJ IDEA.
  User: Yuki
  Date: 4/26/2020
  Time: 1:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 not found</title>
</head>
<body>
<script>
    while (true) {
        let alert = prompt("Ops,some error been happen ! Enter 'ok' to comeback homepage");
        if (alert === 'ok') {
            history.back();
            break
        }
    }
</script>
</body>
</html>
