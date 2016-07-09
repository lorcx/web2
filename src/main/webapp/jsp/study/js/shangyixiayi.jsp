<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>表格数据上下行互换位置</title>
    <script type="text/javascript">
        $(document).ready(function () {
//上移
            $("input.upbtn").each(function () {
                $(this).click(function () {
                    var $tr = $(this).parents("tr");
                    if ($tr.index() != 0) {
                        $tr.prev().before($tr);
                    }
                });
            });
//下移
            var trLength = $("input.downbtn").length;
            $("input.downbtn").each(function () {
                $(this).click(function () {
                    var $tr = $(this).parents("tr");
                    if ($tr.index() != trLength - 1) {
                        $tr.next().after($tr);
                    }
                });
            });
        });

    </script>
</head>
<body>
<table border="1" cellpadding=0 cellspacing=0>
    <tr>
        <td>4</td>
        <td>xxx44xxxx</td>
        <td>2013-5-24</td>
        <td><input type="button" value="上移" class="upbtn"/><input type="button" value="下移" class="downbtn"/></td>
    </tr>
    <tr>
        <td>5</td>
        <td>xxxx55xxx</td>
        <td>2013-5-25</td>
        <td><input type="button" value="上移" class="upbtn"/><input type="button" value="下移" class="downbtn"/></td>
    </tr>
    <tr>
        <td>6</td>
        <td>xxxx66xxx</td>
        <td>2013-5-26</td>
        <td><input type="button" value="上移" class="upbtn"/><input type="button" value="下移" class="downbtn"/></td>
    </tr>
    <tr>
        <td>7</td>
        <td>xxxx77xxx</td>
        <td>2013-5-27</td>
        <td><input type="button" value="上移" class="upbtn"/><input type="button" value="下移" class="downbtn"/></td>
    </tr>
    <tr>
        <td>8</td>
        <td>xxx88xxxx</td>
        <td>2013-5-28</td>
        <td><input type="button" value="上移" class="upbtn"/><input type="button" value="下移" class="downbtn"/></td>
    </tr>
</table>
</body>
</html>