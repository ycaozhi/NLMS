package com.huateng.report.dataquery.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BOPForDebtBilLoanService;

/**
 *
 * 补录查询Getter
 * 
 * @author wenhao.chen
 * @version 1.0
 * @date 2012-09-08
 *
 */

@SuppressWarnings("unchecked")
public class BOPForDebtOverseaLendingQueryGetter extends BaseGetter {

	public Result call() throws AppException {
		try {

			PageQueryResult queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债境外同业拆借补录数据查询页面查询");

			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		BOPForDebtBilLoanService bopDebtService = BOPForDebtBilLoanService.getInstance();

		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		String qFiller2 = getCommQueryServletRequest().getParameter("qFiller2");

		String qBrNo = getCommQueryServletRequest().getParameter("qBrNo");
		String qWorkDateStart = getCommQueryServletRequest().getParameter("qWorkDateStart");

		String qWorkDateEnd = getCommQueryServletRequest().getParameter("qWorkDateEnd");
		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");

		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");

		return bopDebtService.queryRecordAD(pageIndex, pageSize, qWorkDateStart, qWorkDateEnd, qActiontype, qBrNo,
				qFiller2, qApproveStatus, qRecStatus, qRepStatus, TopReportConstants.REPORT_APP_TYPE_CFA,
				TopReportConstants.REPORT_FILE_TYPE_CFA_AC, "");

	}

}
