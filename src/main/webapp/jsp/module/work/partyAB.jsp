<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp" %>
<%@ include file="/jsp/common/plugIn.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>乙方AB角动态选择</title>
</head>
<body>
    <div style="margin: 0 auto;width: 100px;">
        <button type="button" class="btn btn-lg btn-default" onclick="selectParty();">添加</button>
    </div>
    <table id="partyTable" class="table">
        <thead>
            <th></th>
            <th>姓名</th>
            <th>电话</th>
            <th>xxx</th>
        </thead>
        <tbody>
            <tr>
                <td>乙方A角</td>
                <td>
                    <input type="hidden" name="partyBa/projectId" value="111111" no-clear="1"/>
                    <input type="hidden" name="partyBa/userId" value="A0081291"/>
                    <input type="text" name="partyBa/userName" value="章光敏" onclick="selectPartyAB(this,0)"/>
                </td>
                <td><input type="text" value="123451"/></td>
                <td>@xxa</td>
            </tr>
            <tr>
                <td>乙方B角</td>
                <td>
                    <input type="hidden" name="partyBb/projectId" value="111111" no-clear="1"/>
                    <input type="hidden" name="partyBb/userId" value="A0081294"/>
                    <input type="text" name="partyBb/userName" value="王算算" onclick="selectPartyAB(this,1)"/>
                </td>
                <td><input type="text" value="754321"/></td>
                <td>@xxx</td>
            </tr>
            <tr>
                <td>乙方人员</td>
                <td>
                    <input type="hidden" name="partyB[0]/projectId" value="111111" no-clear="1"/>
                    <input type="hidden" name="partyB[0]/userId" value="A0081290"/>
                    <input type="text" name="partyB[0]/userName" value="王欣" onclick=""/>
                </td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            <tr>
                <td>乙方人员</td>
                <td>
                    <input type="hidden" name="partyB[1]/projectId" value="111111" no-clear="1"/>
                    <input type="hidden" name="partyB[1]/userId" value="A0081290"/>
                    <input type="text" name="partyB[1]/userName" value="bbbbbb"/>
                </td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
        </tbody>
    </table>
</body>
<script type="text/javascript">
    //选择乙方人员
    function selectParty(obj){
        var oldUserId = $(obj).prev().val() || '';
//        var newUserId = 'A0081290';
        var newUserId = 'A0081294';
        //新选择人员不同
        if(newUserId && newUserId != oldUserId){
            var oldTr = $(obj).parent().parent();
            var newTr = $(obj).parent().parent().clone();
            //替换
            newTr.find(':nth-child(1)').text('乙方人员');
            var len = $('#partyTable tbody tr').length;
            $.each(newTr.find(':nth-child(2)').find('input'),function (i,o){
                $(o).prop('name','partyB['+(len+1)+']/'+$(o).prop('name'));
            });
            //清空原来的值
            oldTr.find('input[no-clear!="1"]').val('');
            $('#partyTable tbody').append(newTr);
        }
    }

    //选择乙方ab角
    function selectPartyAB(obj,location){
        var oldUserId = $(obj).prev().val() || '';
        var selUserId = 'A0081290' || '';//选择的值
        //选择的不是同一人
        if(oldUserId != selUserId){
            $('#partyTable tbody tr').each(function (i,o){
                if(i == location){
                    return true;//如果是自己就跳过
                }
                var userId = $(o).find('input[name*="userId"]').val() || '';//获取用户id
                if(userId == selUserId){
                    if(i == 1){//替换的是B角
                        var oldTr = $(o);
                        var newTr = $(o).prev();
                        $.each(oldTr.find(':nth-child(2)').find('input'),function (i,o){
                            var nameVal = $(o).prop('name');
                            $(o).prop('name',nameVal.replace('partyBb','partyBa'));
                        });
                        $.each(newTr.find(':nth-child(2)').find('input'),function (i,o){
                            var nameVal = $(o).prop('name');
                            $(o).prop('name',nameVal.replace('partyBa','partyBb'));
                        });
                        oldTr.find(':nth-child(1)').text(oldTr.find(':nth-child(1)').text().replace('B','A'));
                        newTr.find(':nth-child(1)').text(newTr.find(':nth-child(1)').text().replace('A','B'));
                        newTr.before($(o));
                    }else{//替换乙方人员
                        var oldTr = $(obj).parent().parent();
                        var newTr = $(obj).parent().parent().clone();
                        //替换
                        newTr.find(':nth-child(1)').text('乙方人员');
                        var len = $('#partyTable tbody tr').length;
                        //替换乙方人员
                        $.each(newTr.find(':nth-child(2)').find('input'),function (i,o){
                            var newName = 'partyB['+len+']/'+$(o).prop('name').split('/')[1];
                            $(o).prop('name',newName);
                        });
                        //替换ab角
                        $.each($(o).find(':nth-child(2)').find('input'),function (i,o){
                            var aOrb = location == 0 ? 'a' : 'b';
                            var newName = 'partyB'+aOrb+'/'+$(o).prop('name').split('/')[1];
                            $(o).prop('name',newName);
                        });
                        oldTr.before($(o)).remove();
                        $('#partyTable tbody').append(newTr);
                    }
                    return false;
                }
            });
        }
    }
</script>
</html>
