<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>
<table id="tableData">
    <tr class="firstLine">
        <th></th>
        <th>图片</th>
        <th>图片名称</th>
        <th>类型</th>
        <th>大小</th>
        <th>尺寸</th>
        <th>上传日期</th>
        <th>操作</th>
        <th></th>
    </tr>
    <script type="text/template">
        <tr mgid="{mgid}" mid="{mid}">
            <td>
                <input type="checkbox" mid="{mid}"></td>
            <td>
                <a href="{localfile}" data-fancybox-group="button" class="fancybox-buttons">
                    <img src="{localfile}" style="width:45px;height:45px;"></a>
            </td>
            <td>
                <input type="text" class="input-large valid" value="{medianame}" onblur="TextOnBlur(this)" onclick="TextOnFocus(this)" name="medianame" mid="{mid}" readonly="readonly"></td>
            <td>{mediatype}</td>
            <!-- 各位看官，自定义的三个属性在这里哦~~ -->
            <td>{fsize}</td>
            <td>{asize}</td>
            <td>{atime}</td>
            <td>
                <a onclick="updateMediaName(this)" href="javascript:void(0);">重命名</a>
                <a onclick="showbulkUploadTemplate(this)" name="edit" localfile="{localfile}" href="javascript:void(0);">替换</a>
                <a onclick="daleteMedia(this)" href="javascript:void(0);">删除</a>
                <a onclick="setMediaFaceImage(this);" title="设置为分组【{groupname}】的封面" groupname="{groupname}" mid="{mid}" href="javascript:void(0);">设置封面</a>
            </td>
        </tr>
    </script>

</table>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/plug_in/jquery/jquery-1.12.1.min.js"></script>
<script>

    (function () {
        var dta = {
            "total": "1",
            "page": "1",
            "records": "3",
            "rows": [{
                "groupname": "美食图片",
                "mid": 4766,
                "sid": 517,
                "medianame": "Tulips",
                "mgid": 549,
                "mediatype": "image",
                "mediaid": "",
                "timestamp": "",
                "localfile": "/UploadFile/image/201409/14/0x6dvf.jpg",
                "picurl": "",
                "thumbid": "",
                "voiceformat": "",
                "state": 1,
                "createtime": "\/Date(1410673220000+0800)\/",
                "uploadtime": "\/Date(1410673220000+0800)\/",
                "width": 480,
                "height": 360,
                "seizespace": 17.41
            }, {
                "groupname": "美食图片",
                "mid": 4765,
                "sid": 517,
                "medianame": "Penguins",
                "mgid": 549,
                "mediatype": "image",
                "mediaid": "",
                "timestamp": "",
                "localfile": "/UploadFile/image/201409/14/6iluw6.jpg",
                "picurl": "",
                "thumbid": "",
                "voiceformat": "",
                "state": 1,
                "createtime": "\/Date(1410673215000+0800)\/",
                "uploadtime": "\/Date(1410673215000+0800)\/",
                "width": 480,
                "height": 360,
                "seizespace": 15.62
            }, {
                "groupname": "美食图片",
                "mid": 4764,
                "sid": 517,
                "medianame": "Lighthouse",
                "mgid": 549,
                "mediatype": "image",
                "mediaid": "",
                "timestamp": "",
                "localfile": "/UploadFile/image/201409/14/fx0kzp.jpg",
                "picurl": "",
                "thumbid": "",
                "voiceformat": "",
                "state": 1,
                "createtime": "\/Date(1410673209000+0800)\/",
                "uploadtime": "\/Date(1410673209000+0800)\/",
                "width": 480,
                "height": 360,
                "seizespace": 14.2
            }]
        };

        if (!dta || !dta.rows || dta.rows.length <= 0) {
            return;
        }

        //获取模板上的HTML
        var html = $('script[type="text/template"]').html();
        //定义一个数组，用来接收格式化合的数据
        var arr = [];
        //对数据进行遍历
        $.each(dta.rows, function (i, o) {
            //这里取到o就是上面rows数组中的值, formatTemplate是最开始定义的方法.
            arr.push(formatTemplate(o, html));
        });
        //好了，最后把数组化成字符串，并添加到table中去。
        $('#tableData').append(arr.join(''));
    })();

    function formatTemplate(dta, tmpl) {
        var format = {
            name: function (x) {
                return x
            }
        };
        return tmpl.replace(/{(\w+)}/g, function (m1, m2) {
            if (!m2)
                return "";
            return (format && format[m2]) ? format[m2](dta[m2]) : dta[m2];
        });
    }

    function getFormatDate(xdate, format) {
        try {
            var format = format || 'yyyy-MM-dd HH:mm:ss';
            var date = (xdate instanceof Date) ? xdate : new Date(parseInt(xdate.replace('/Date(', '').replace(')/', ''), 10));
            var lang = {
                'M+': date.getMonth() + 1,
                'd+': date.getDate(),
                'H+': date.getHours(),
                'm+': date.getMinutes(),
                's+': date.getSeconds()
            };
            if (/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
            }
            for (var key in lang) {
                if (new RegExp('(' + key + ')').test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ?
                            lang[key] : ('00' + lang[key]).substr(('' + lang[key]).length));
                }
            }
            return format;
        } catch (e) {
            return '-';
        }
    }
</script>


</html>
