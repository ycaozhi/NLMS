<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="签约信息">
<@CommonQueryMacro.CommonQueryTab id="BOPForDebtAndSubSidQueryTabs" navigate="false" currentTab="BOPForDebtAndSubSidQuery">
	<@CommonQueryMacro.CommonQuery id="BOPForDebtAndSubSidQuery" init="false" submitMode="current" navigate="false" >
		<table align="left">
			<tr>
				<td >
					<@CommonQueryMacro.Interface id="interface"  label="请输入查询条件" />
				</td>
			</tr>
			<tr>
  			  	<td>
  			    	<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"   pageCache="false" showArrow="true"/>
  			  	</td>
  			</tr>
  			<tr>
		      	<td >

					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="filler2[180],brNo,brNoName,workDate[100],actiontype[80],recStatus[80],approveStatus[80],repStatus[80],exdebtcode[180],limitType[100],debtorcode[120],debtype[80],valuedate[100],contractcurr[80],floatrate[80],anninrate[80],creditorcode[80],creditorname[80],creditornamen[80],creditortype[80],spapfeboindex[80],crehqcode,opercode" readonly="true" hasFrame="true" width="1000" height="260"/>

		      	</td>
      		</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

	function initCallGetter_post(){
		var currentDate = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()}";
		BOPForDebtAndSubSidQuery_interface_dataset.setValue("qworkDate", currentDate);
		BOPForDebtAndSubSidQuery_interface_dataset.setValue("eworkDate", currentDate);
	}
	
	function datatable1_filler2_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var id = record.getValue("id");
			var filler2 = record.getValue("filler2");
			cell.innerHTML = "<a style='text-decoration:none' href=\"JavaScript:doDetail('"+id+"')\">" + filler2 + "</a>"
		} else {
			cell.innerHTML="&nbsp;";
		}
	}
	
	//详细信息
	function doDetail(id){
		showWin("境外联行及附属机构往来","${contextPath}/fpages/datacollection/ftl/BopForCorAndAffOrgContactInfo.ftl?id=" + id + "&op=detail");
	}
</script>
</@CommonQueryMacro.page>