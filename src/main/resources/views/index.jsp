<!DOCTYPE html PUBLIC "-//W3C//DTD JTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title</title>
</head>

<body>
    <script type="text/javascript" src="assets/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                type: "GET",
                url: 'ceshi',
                dataType:"json",
                success: function(datas){
                    console.log("请求成功！");
                }
            });
        })
    </script>
    <pre>
        welcome to spring MVC world
    </pre>
</body>
</html>
