package com.huateng.report.system.service;

import resource.bean.report.SysTaskInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class UndoConfirmService {
	/**
	 * @author jianxue.zhang service层for待审批和已审批数据获取
	 */
	public static synchronized UndoConfirmService getInstance() {
		return (UndoConfirmService) ApplicationContextUtils.getBean("UndoConfirmService");
	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return rootDao.pageQueryByQL(queryCondition);
	}

	public SysTaskInfo load(String id) {
		return (SysTaskInfo) ROOTDAOUtils.getROOTDAO().getHibernateTemplate().get(SysTaskInfo.class, id);

	}

}
