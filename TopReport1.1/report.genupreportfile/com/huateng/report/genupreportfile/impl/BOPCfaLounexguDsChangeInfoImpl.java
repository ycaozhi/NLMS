package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaLounexguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BOPCfaLounexguDsChangeInfoImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap) throws CommonException {
		// TODO Auto-generated method stub

		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);

		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		// BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();

		StringBuffer querySql = new StringBuffer();

		querySql.append(" from BopCfaLounexguDs model ");
		querySql.append(" where model.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认
		if (fileDate != null && fileDate.trim().length() > 0) {
			querySql.append(" and model.workDate='" + fileDate + "'");
		}
		querySql.append(" and model.apptype ='" + appType + "'");
		querySql.append(" and model.currentfile ='" + fileType + "'");
		List<BopCfaLounexguDs> bopCfaLouList = new ArrayList<BopCfaLounexguDs>();// 境外担保人

		for (Iterator<BopCfaLounexguDs> it = rootDao.queryByQL(querySql.toString()); it.hasNext();) {
			BopCfaLounexguDs bopCfaLounexguDs = it.next();
			bopCfaLouList.add(bopCfaLounexguDs);

		}
		return bopCfaLouList;
	}

}
