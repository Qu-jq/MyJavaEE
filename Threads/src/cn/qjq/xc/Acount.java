package cn.qjq.xc;
class Acount{
	private int monenyTotal;//账户总钱数
	private String name;//账户名
	public Acount(int monenyTotal, String name) {
		this.monenyTotal = monenyTotal;
		this.name = name;
	}
	public int getMonenyTotal() {
		return monenyTotal;
	}
	public void setMonenyTotal(int monenyTotal) {
		this.monenyTotal = monenyTotal;
	}
	
}