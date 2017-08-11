<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="���к���������">
<@CommonQueryMacro.CommonQuery id="BankBlackList" init="false" submitMode="current">
<table width="90%">
	<tr valign="center">
		<td valign="top" colspan="2">
			<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=6 />
		</td>
	</tr>
  	<tr>
  		<td valign="top">
			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
		</td>
	
	 </tr>
	 <tr>
		 <td colspan="2">
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="-,btAdd,-,btStatus" 
			fieldStr="partyId" 
			readonly="true" width="100%" hasFrame="true" height="580" />
		 </td>
	 </tr>
	 <tr align="center">
		<td>
			<div style="display:none">
				<@CommonQueryMacro.Button id= "btDel" />
				<@CommonQueryMacro.Button id= "btModify"/>
			 </div>
		</td>
	</tr>
</table>

</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var currentTlrno = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}";
	//��λһ����¼
	function locate(id) {
		var record = operMngEntry_dataset.find(["tlrno"],[id]);
		if (record) {
			operMngEntry_dataset.setRecord(record);
		}
	}

	function datatable1_opr_onRefresh(cell, value, record)
	{
		if(record&&record!=null){

			var id = record.getValue("tlrno");
			var branchId = record.getValue("tlrno");
			var st = record.getValue("st");
			var innerStr = "<PRE>";
			if (st == "1" || st == "2" || st == "3") {
				innerStr = innerStr + "<a style=\"color:#666666\" title=\"��¼�����������ܲ���\">�޸�</a> " +
		    		" <a style=\"color:#666666\" title=\"��¼�����������ܲ���\">��������</a>" +"</PRE>";
		    } else {
		    	innerStr = innerStr + " <a href=\"JavaScript:btModifyShow('"+id+"')\">�޸�</a>"  +
			    " <a href=\"JavaScript:resetPwd('"+id+"')\">��������</a>" +"</PRE>";
		    }
		    cell.innerHTML = innerStr;
		}else{
			cell.innerHTML = "";
		}
	}

	function btStatus_onClickCheck(button) {
		var status = operMngEntry_dataset.getValue("flag");
		if(status == '0'){
			if(confirm("ȷ�Ͻ��ò���Ա����Ϊ��Ч?")){
			    operMngEntry_dataset.setParameter("statu", "1");
				return true;
			}else{
				return false;
			}
		} else {
			if(confirm("ȷ�Ͻ��ò���Ա����Ϊ��Ч?")){
				operMngEntry_dataset.setParameter("statu", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	
	function btStatus_postSubmit(button) {
		alert("���óɹ�");
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function operMngEntry_dataset_dataset_afterScroll(dataset){
		unLock.disable(dataset.getValue("isLock") != '1' || dataset.getValue("tlrno") == currentTlrno);
	}

	//����
	function btAdd_onClick(){
		window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=new";
	}

	//ˢ������
	function flushPage(){
		bopAccDsRecordAD_dataset.flushData();
	}

	function winZone_onCloseCheck(){
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
		return true;
	}

	function btModifyShow(tlrno){
	  	window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=modify&tlrno=" + tlrno;
	}

	function btAuthShow(tlrno){
		var paramMap = new Map();
		var op = "auth";
	  	paramMap.put("tlrno",tlrno);
	  	paramMap.put("op",op);
	  	loadPageWindows("userWin", "��ɫ�趨", "/fpages/regonization/ftl/OperMngRoleInfo.ftl", paramMap, "winZone");
	}

	function btResetPwd_postSubmit(button){
		var retParam = button.returnParam;

		alert("�������óɹ�,��ʼ��Ϊ"+retParam.DefaultPWD);
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function unLock_onClickCheck(button) {
		operMngEntry_dataset.setParameter("tlrno",operMngEntry_dataset.getValue("tlrno"));
	}
	
	function unLock_postSubmit(button) {
		alert("�����ɹ���");
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

	function operMngEntry_dataset_afterScroll(dataset){
		unLock.disable(dataset.getValue("isLock") != '1');
		btLoginStatus.disable(dataset.getValue("status") != '1');
		btStatus.disable(false);
		if(dataset.getValue("tlrno") == currentTlrno){
			btStatus.disable(true);
			unLock.disable(true);
			btLoginStatus.disable(true);
		}
		var st = dataset.getValue("st");
		if (st == "1" || st == "2" || st == "3") {
			btStatus.disable(true);
			unLock.disable(true);
			btLoginStatus.disable(true);
		}
	}

	//չʾ�Աȹ��ܵ�js
	function datatable1_tlrno_onRefresh(cell, value, record){
		if(record!=null){
			var sta = record.getValue("st");
			var tlrno=record.getValue("tlrno");
			cell.innerHTML = "<a href=\"Javascript:showDetail('"+tlrno+"','"+sta+"')\">"+tlrno+"</a>";
		} else {
			cell.innerHTML = ""
		}
	}

	function showDetail(tlrno,sta){
		showWin("�û���ϸ��Ϣ","${contextPath}/fpages/regonization/ftl/OperMngRoleCompare.ftl?id=" + tlrno + "&st=" + sta + "&flag=0","","",window);
	}
</script>
</@CommonQueryMacro.page>