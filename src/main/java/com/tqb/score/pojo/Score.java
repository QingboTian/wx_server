package com.tqb.score.pojo;

public class Score {
	private String kcmc;
	private String bj;
	private String cj;
	private String jd;
	private String jgmc;
	private String kch;
	private String kcxzmc;
	private String xm;
	private String ksxz;

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getKsxz() {
		return ksxz;
	}

	public void setKsxz(String ksxz) {
		this.ksxz = ksxz;
	}

	public String getKcmc() {
		return kcmc;
	}

	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}

	public String getBj() {
		return bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getKch() {
		return kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public String getKcxzmc() {
		return kcxzmc;
	}

	public void setKcxzmc(String kcxzmc) {
		this.kcxzmc = kcxzmc;
	}

	@Override
	public String toString() {
		return "Score [课程名称=" + kcmc + ", 班级=" + bj + ", 成绩=" + cj + ", 绩点=" + jd + ", 学院=" + jgmc + ", 课程代码=" + kch
				+ ", 课程性质=" + kcxzmc + "]";
	}

}
