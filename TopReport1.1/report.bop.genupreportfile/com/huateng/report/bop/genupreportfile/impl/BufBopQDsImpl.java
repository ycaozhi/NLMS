package com.huateng.report.bop.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopEqDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufBopQDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap) throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();

		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);

		hqlBuff.append(" from MtsBopEqDs model ").append(" where model.apptype = '" + appType).append("'")
				.append(" and model.currentfile = '" + fileType + "'");
		if (fileDate != null && fileDate.trim().length() > 0) {
			hqlBuff.append(" and model.workDate = '" + fileDate + "'");
		}
		hqlBuff.append(" and model.recStatus = '" + TopReportConstants.REPORT_RECSTATUS_05 + "'");
		List<MtsBopEqDs> reportList = dao.queryByQL2List(hqlBuff.toString());

		for (MtsBopEqDs ds : reportList) {
			// mod by huangcheng 2012-11-19
			String hqlMtsBopCustom = " from MtsBopCustom mbc  where mbc.recId = '" + ds.getId() + "'";
			List customs = dao.queryByQL2List(hqlMtsBopCustom);
			ds.setCustoms(customs);
		}
		return reportList;

	}

}
