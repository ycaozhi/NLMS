package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 *
 * @author shishu.zhang
 *
 *         2012-8-31下午4:25:42
 */
@SuppressWarnings("unchecked")
public class BopForDebtYinTuanCreditorGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-银团贷款信息补录-债权人信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(),
					pageQueryResult.getQueryResult(), getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws CommonException {
		Map map = getCommQueryServletRequest().getParameterMap();
		List<BopCfaCreditorDs> list = new ArrayList<BopCfaCreditorDs>();
		PageQueryResult queryResult = new PageQueryResult();
		String id = (String) map.get("id");
		String op = (String) map.get("op");
		if (DataFormat.isEmpty(id)) {
		} else {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String hql = "from BopCfaCreditorDs model where model.recId = '" + id + "'";
			list = rootdao.queryByQL2List(hql);
		}
		queryResult.setQueryResult(list);
		// 页面接收判断
		getCommQueryServletRequest().setParameter("op", op);
		return queryResult;
	}
}
