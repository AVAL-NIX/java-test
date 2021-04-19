<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    <script src="${request.contextPath}/js/jquery.min.js"></script>
</head>
<body>

<div>
    <form method="post" id="create_form" action="/upload" enctype="multipart/form-data" >
        <input type="file" name="file" id="file">
    　　<button type="button" id="submit-btn">提交</button>
    </form>
</div>

</body>
</html>
<script>
    $("#submit-btn").click(
        function(e){
            $("#create_form").submit();
        }
    )
</script>
