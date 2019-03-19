<%--
  Created by IntelliJ IDEA.
  User: nitin
  Date: 19/3/19
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To The New</title>
</head>
<body>
    <div>
        <h2>Ques 1: Implement AbstractController in StudentController. create a mapping index.html for it and render index.jsp view from it which displays messages "Hello from index.gsp"
        </h2>
        <a href="/index.html"><input type="submit" value="Render index.jsp using Abstract Controller"></a>
    </div>

    <div>
        <h2>Ques 2: Now remove AbstractController and useMultiActionController for StudentController which contains 2 actions
            one action renders a jsp view and another action uses HttpServletResponse to show the output on the Web browser.</h2>
        <a href="/showHomepage"><input type="submit" value="Render a JSP View using MultiActionController"></a>
        <a href="/showResponse"><input type="submit" value="Show Http Response"></a>
    </div>

    <div>
        <h2>Ques 3: Use annotation in StudentController to define a default action index which renders a jsp page.</h2>
        <a href="/index.html"><input type="submit" value="Render index.jsp using Annotations"></a>
    </div>
</body>
</html>
