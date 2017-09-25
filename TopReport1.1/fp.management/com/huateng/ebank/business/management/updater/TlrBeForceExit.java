package com.huateng.ebank.business.management.updater;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import resource.bean.pub.TlrInfo;
import resource.dao.pub.TlrInfoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TlrBeForceExit extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrInfoEx");
			String tlrno = "";
			if (updateResultBean.hasNext()) {
				tlrno = updateResultBean.next().get("tlrno").toString();
			} else {
				ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLR_INFO_SELECT);
			}
			TlrInfoDAO dao = DAOUtils.getTlrInfoDAO();
			TlrInfo tlrInfo = dao.query(tlrno);
			tlrInfo.setStatus("0");
			dao.update(tlrInfo);
			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
