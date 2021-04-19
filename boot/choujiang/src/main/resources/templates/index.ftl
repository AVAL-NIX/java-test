<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>抽奖</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/animate.css">

    <script src="${request.contextPath}/js/jquery.min.js"></script>
    <script src="${request.contextPath}/js/lib/common.js"></script>
    <script src="${request.contextPath}/js/index.js"></script>

</head>
<body>

<div>

    <header>
        <div></div>
    </header>
    <section>
        <div class="hide" id="luckyDrawing"><input id="showName" readonly type="text"></div>
        <div class="hide" id="result">
            <div></div>
        </div>
    </section>
    <footer>
        <div>
            <input type="number" id="txtNum" value="" placeholder="请输入中奖人数">
            <button id="btnStart">开始</button>
            <button id="btnReset">&nbsp;</button>
        </div>
    </footer>

</div>

<div id="bgLuckyDrawEnd"></div>

<div id="iconDiv" class="animated fadeIn">
    <span><img src="css/img/icon/01.png"> </span>
    <span><img src="css/img/icon/02.png"> </span>
    <span><img src="css/img/icon/03.png"> </span>
    <span><img src="css/img/icon/04.png"> </span>
    <span><img src="css/img/icon/05.png"> </span>
    <span><img src="css/img/icon/06.png"> </span>
</div>

</body>
</html>
