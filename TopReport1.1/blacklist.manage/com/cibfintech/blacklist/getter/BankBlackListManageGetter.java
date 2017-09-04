package com.cibfintech.blacklist.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.blacklist.BankBlackList;

import com.cibfintech.blacklist.service.BankBlackListService;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class BankBlackListManageGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		String id = getCommQueryServletRequest().getParameter("id");

		if (id == null || id.equals("")) {
			id = "0";
		}

		BankBlackList bankBlackList = (BankBlackList) BankBlackListService.getInstance().selectById(id);

		ResultMng.fillResultByObject(this.commonQueryBean, getCommQueryServletRequest(), bankBlackList, getResult());

		List content = new ArrayList();
		getResult().setContent(content);
		getResult().init();

		return getResult();
	}

}