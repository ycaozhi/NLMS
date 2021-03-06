package com.huateng.ebank.business.management.action;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.service.pub.TlrLoginLogService;
import com.huateng.service.pub.UserMgrService;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends BaseAction {

	private static final Logger logger = Logger.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = null;
		try {
			if(request.getSession(false) != null){
				//记录登录日志
				TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
				tlrLoginLogService.saveTlrLoginLog("logout", false, "退出系统");
				/*不是重新登陆才记录退出信息*/
//				if (StringUtils.isBlank(request.getParameter("relogin")))
					UserMgrService.getInstance().setLoginOutInfo(GlobalInfo.getCurrentInstance().getTlrno());
				//删除系统记录的session
				SessionFactory.getInstance().removeSession(request.getSession(false).getId());
			}
			destroySession(request);
			actionForward = mapping.findForward("success");

		} catch (Exception e) {
			logger.info(e.getMessage());
			actionForward = mapping.findForward("failure");
		}
		return (actionForward);
	}
}