package module.entity;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private String tid;
	private String tname;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** minimal constructor */
	public Test(String tid) {
		this.tid = tid;
	}

	/** full constructor */
	public Test(String tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}