<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web Font字体 使用</title>
    <%--在css里面，如果想使用某个字体，但是又担心用户电脑上没有，就可以使用font-face属性从服务器上引用这组字体。--%>
    <%--引入在线css--%>
    <%--
        一：引入在线的css
            <link rel="stylesheet" href="https://i.icomoon.io/public/temp/ad6bdb49bd/UntitledProject/style.css">
         直接使用 css伪元素
          .icon-chrome:after {
            content: "\e901";
          }

         二：在线生成 svg等文件 并引入
            在css中@font-face自定义 font-family
            根据svg等文件中定义的值使用
            .icon-chrome:after {
            content: "\e901";
          }
    --%>
</head>
<%--<body style="font-family: icomoon">--%>
<body>

<span class="icon-home2"></span>

<span class="icon-spinner4"></span>


<div style="font-family: icomoon;">
    <span class="icon-spinner4"></span>
    <input type="text" class="icon_before icon_text1"/>
    <input type="text" class="icon_after icon_text1"/>
    <hr/>

    <span class="sp"><input type="text" class="icon_text2 "/></span>



</div>



</body>
<style>

  /*:before在之前插入*/

 /* .icon-home2:before {
    content: "\e900";
  }*/

/*  .icon-chrome:after {
    content: "\e901";
  }*/

  @font-face {
      font-family: 'icomoon';
      src:    url('../../../font/myFont/icomoon.eot?f3qif');
      src:    url('../../../font/myFont/icomoon.eot?f3qif#iefix') format('embedded-opentype'),
      url('../../../font/myFont/icomoon.ttf?f3qif') format('truetype'),
      url('../../../font/myFont/icomoon.woff?f3qif') format('woff'),
      url('../../../font/myFont/icomoon.svg?f3qif#icomoon') format('svg');
      font-weight: normal;
      font-style: normal;
  }

  .icon-spinner4:after {
      content: "spinner4";
  }

  /**input 内有图片 begin*/

  .icon_before{
      background: url("../../../img/icon/FLD313.ICO") center left no-repeat ;
      background-size: 15px 15px;
  }

  .icon_after{
      background: url("../../../img/icon/FLD313.ICO") center right no-repeat ;
      background-size: 15px 15px;
  }

  .icon_text1{
        padding-left: 20px;
        line-height: 20px;
        border:1px solid #0CF;
  }
  /*块级元素 设置宽度 他就占多宽
    行级元素设置宽度但里面没有内容他依然没有宽度
  */

  .sp:after{
      width: 200px;
      height: 30px;
      border:1px solid #0cf;
      content: "spinner4";
  }

  .icon_text2{
      line-height: 20px;
      border:1px solid #0CF;
  }

  /**input 内有图片 end*/

</style>
</html>
