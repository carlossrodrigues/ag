package ag.entity;

import res.dh.DH;
import res.dp.DP;


public class Celula{
	private DP dp;
	private DH dh;
	public Celula(DP dp, DH dh) {
		super();
		this.dp = dp;
		this.dh = dh;
	}
	public DH getDH() {
		return dh;
	}
	public void setDH(DH dh) {
		this.dh = dh;
	}
	public DP getDP() {
		return dp;
	}
}
