package resource.bean.pub.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the TLR_BCTL_REL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="TLR_BCTL_REL"
 */

public abstract class BaseTlrBctlRel implements Serializable {

	public static String REF = "TlrBctlRel";
	public static String PROP_TLR_NO = "tlrno";
	public static String PROP_ID = "id";
	public static String PROP_BR_NO = "brcode";

	// constructors
	public BaseTlrBctlRel() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrBctlRel(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tlrno;
	private java.lang.String brcode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="sequence" column="ID"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: TLR_NO
	 */
	public java.lang.String getTlrno() {
		return tlrno;
	}

	/**
	 * Set the value related to the column: TLR_NO
	 * 
	 * @param tlrNo
	 *            the TLR_NO value
	 */
	public void setTlrno(java.lang.String tlrNo) {
		this.tlrno = tlrNo;
	}

	/**
	 * Return the value associated with the column: BRCODE
	 */
	public java.lang.String getBrcode() {
		return brcode;
	}

	/**
	 * Set the value related to the column: BRCODE
	 * 
	 * @param brNo
	 *            the BR_NO value
	 */
	public void setBrcode(java.lang.String brcode) {
		this.brcode = brcode;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof resource.bean.pub.TlrBctlRel))
			return false;
		else {
			resource.bean.pub.TlrBctlRel tlrBctlRel = (resource.bean.pub.TlrBctlRel) obj;
			if (null == this.getId() || null == tlrBctlRel.getId())
				return false;
			else
				return (this.getId().equals(tlrBctlRel.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}