<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<!DOCTYPE HTML>
<html>
<head>
    <title>文件上传demo</title>
    <style type="text/css">
          *{margin: 0;padding: 0;}
          .entire{width: 900px;width: 100%;}
          .div_center {margin : 0 auto;width:300px;}
          .title{text-align: center;
                 font-size: 30px;
                 font-weight: bold;
                 font-family: arial,"Hiragino Sans GB","Microsoft Yahei",sans-serif;
          }
          #selected{margin: 0 auto;}
          #area {
              margin-top: 7px;
              width: 300px;
              height:400px;
              border: 1px solid #e5ace6;
              overflow: scroll;
          }
    </style>
</head>
<body>
  <div class="entire">
      <div class ="title">文件上传</div>
      <div id="container" class="div_center">
          <input type="file" id="selected" name="selected"/>
          <div id = "area"></div>
      </div>
      <div id="buttons" class="div_center">
          <button type="button" class="button black side" id="uploadFile" name="uploadFile" >上&nbsp;&nbsp;传</button>
          <button type="button" class="button black side" id="uploadCancel" name="uploadCancel" >取&nbsp;&nbsp;消</button>
      </div>
  </div>
</body>
<link rel="stylesheet" type="text/css" href="../css/button/buttons.css">
<link rel="stylesheet" type="text/css" href="../plug_in/uploadify/uploadify.css"/>
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/swfobject.js"></script>
<script type="text/javascript" src="/plug_in/uploadify/jquery.uploadify.js"></script>
<script type="text/javascript">
    $(function(){
        //初始化
        uploadInit();

        $('#uploadFile').click(function (){
            uploadCommit();
        });

        $('#uploadCancel').click(function (){
            uploadCancel();
        });
    });

    //上传初始化
    function uploadInit(){
      $('#selected').uploadify({
        'height'        : 30,
        'swf'           : '<%=request.getContextPath()%>/plug_in/uploadify/uploadify.swf',
        'uploader'      : '<%=request.getContextPath()%>/servlet/uploadFile',  ///util/fileUpload!upload.action     struts2  /servlet/uploadFile servlet
        'width'         : 120,
        'fileTypeExts': '*.jpg;*.jpge;*.gif;*.png;*.txt;*.doc',//允许上传的文件后缀
        'fileSizeLimit':'200MB',//上传文件的大小限制
        //'scriptData'    : {'id':1,'xx':'a'},//提交的参数?xxx=xx
        'multi'         : true,//是否可以多个上传
        'auto'          : false,//选中后是否自动上传
        'buttonText'    : '请选择',//按钮名称
        'queueID'       : 'area',//用于显示文件队列的位置
        //选择上传文件后调用
        'onSelect' : function(file) {

        },
        //返回一个错误，选择文件的时候触发
        'onSelectError':function(file, errorCode, errorMsg){
          switch(errorCode) {
            case -100:
              alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
              break;
            case -110:
              alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
              break;
            case -120:
              alert("文件 ["+file.name+"] 大小异常！");
              break;
            case -130:
              alert("文件 ["+file.name+"] 类型不正确！");
              break;
          }
        },
        //检测FLASH失败调用
        'onFallback':function(){
          alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
        },
        //上传到服务器，服务器返回相应信息到data里
        'onUploadSuccess' : function(fileObj, serverData, data) {
              if(fileObj.size == 0){
                  return;
              }
             alert("上传成功！");
         }
      });
    }

    /**
     *上传提交
     */
    function uploadCommit(){
        $('#selected').uploadify('upload');
    }

    /**
     *取消文件上传
     */
    function uploadCancel(){
        $('#selected').uploadify('cancel');
    }
</script>
</html>
