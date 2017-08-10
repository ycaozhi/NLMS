package com.cibfintech.report.blacklist.getter;

import com.cibfintech.report.blacklist.service.BankBlackListService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class BankBlackListGetter extends BaseGetter {
	/*
	 * 获取商行黑名单
	 * 
	 * @author huangcheng
	 */
	@Override
	public Result call() throws AppException {
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "商行黑名单管理查询");
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String partyId = getCommQueryServletRequest().getParameter("qPartyId");
		String zjzl = getCommQueryServletRequest().getParameter("qZjzl");
		String zjhm = getCommQueryServletRequest().getParameter("qZjhm");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		PageQueryResult pqr = BankBlackListService.getInstance().pageQueryByHql(pageIndex, pageSize, partyId, zjzl,
				zjhm);
		return pqr;
	}
}