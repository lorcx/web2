document.write('<!-- 用来产生编辑状态的ActiveX控件的JS脚本-->   ');
document.write('<!-- 因为微软的ActiveX新机制，需要一个外部引入的js-->   ');
document.write('<object id="TANGER_OCX" classid="clsid:C9BC4DFF-4248-4a3c-8A49-63A7D317F404" codebase="/jsp/module/office/OfficeControl.cab#version=5,0,1,6" width="100%" height="100%">');
document.write('<param name="MakerCaption" value="中科软科技股份有限公司">');
document.write('<param name="MakerKey" value="DD41FF5FE728D847033482AE99B85A1677988475">');
document.write('<param name="ProductCaption" value="中国华融资产管理股份有限公司业务档案管理系统"> ');
document.write('<param name="ProductKey" value="B6CCF16AE009E4819A534C482E370B30810A0A42">');
document.write('<param name="TitleBar" value="false">');
document.write('<param name="FileProperties" value="false">');
document.write('<param name="DefaultOpenDocType" value="0">');
document.write('<param name="IsUseUTF8URL" value="-1">   ');
document.write('<param name="IsUseUTF8Data" value="-1">   ');
document.write('<param name="FileNew" value="false">   ');
document.write('<param name="FileOpen" value="false">   ');
document.write('<param name="FileSave" value="false">   ');
document.write('<param name="FileProperties" value="false">   ');
document.write('<param name="FileSaveAs" value="false">   ');
document.write('<param name="FilePrint" value="false">   ');
document.write('<param name="FilePrintPreview" value="false">   ');
document.write('<param name="CustomToolBar" value="-1">    ');
 
//document.write('<param name="Menubar" value="false">   ');
document.write('<SPAN STYLE="color:red">不能装载文档控件。请在检查浏览器的选项中检查浏览器的安全设置。</SPAN>   ');
document.write('</object>');

function objinit(fileId,ext,isdown,isprint) {
	if(fileId==null){
		tips("请所查看的文件不存在");
		return false;
	}
    TANGER_OCX_OBJ = document.getElementById("TANGER_OCX");
    OpenDocument("/OfficeServlet?method=loadAffix&fileId="+fileId,ext);
    TANGER_OCX_OBJ.ToolBars = false;//屏蔽工具栏
    TANGER_OCX_OBJ.IsNoCopy = true;
    if(isdown == '1'){
    	TANGER_OCX_OBJ.FileSaveAs = true;
    }
    if(isprint == '1'){
        TANGER_OCX_OBJ.FilePrint  = true;
        TANGER_OCX_OBJ.FilePrintPreview = true;
    }    
}
function OpenDocument(a,ext) {
	 if(ext=='pdf'){
        TANGER_OCX_OBJ.AddDocTypePlugin(".pdf", "PDF.NtkoDocument", "4.0.0.1","/jsp/module/office/ntkooledocall.dll", 51, true);
	 }
     TANGER_OCX_OBJ.BeginOpenFromURL(a);
} 