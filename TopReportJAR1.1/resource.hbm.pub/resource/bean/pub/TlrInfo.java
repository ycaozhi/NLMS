package resource.bean.pub;

import java.util.Date;
import java.util.List;

import resource.bean.pub.base.BaseTlrInfo;

public class TlrInfo extends BaseTlrInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public TlrInfo() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TlrInfo(java.lang.String tlrno) {
		super(tlrno);
	}

	/* [CONSTRUCTOR MARKER END] */
	private String brno;

	public String getBrno() {
		return brno;
	}

	public void setBrno(String brno) {
		this.brno = brno;
	}

	/** add by zhaozhiguo 2011-6-20 BMS-3153 begin */
	private java.util.Date lastPwdUpdTime;
	private Date lastfailedtm;
	private String lockReason;
	private List roleList;
	private String newFlag;
	private String RestFlg;

	private String reset;

	public String getReset() {
		return reset;
	}

	public void setReset(String reset) {
		this.reset = reset;
	}

	public Date getLastfailedtm() {
		return lastfailedtm;
	}

	public void setLastfailedtm(Date lastfailedtm) {
		this.lastfailedtm = lastfailedtm;
	}

	public String getLockReason() {
		return lockReason;
	}

	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}

	public java.util.Date getLastPwdUpdTime() {
		return lastPwdUpdTime;
	}

	public void setLastPwdUpdTime(java.util.Date lastPwdUpdTime) {
		this.lastPwdUpdTime = lastPwdUpdTime;
	}

	/** add by zhaozhiguo 2011-6-20 BMS-3153 end */

	// 操作员审批阀值
	private long maxWl;

	public long getMaxWl() {
		return maxWl;
	}

	public void setMaxWl(long maxWl) {
		this.maxWl = maxWl;
	}

	public List getRoleList() {
		return roleList;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}

	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	public String getRestFlg() {
		return RestFlg;
	}

	public void setRestFlg(String restFlg) {
		RestFlg = restFlg;
	}

}