package bean;

public class Account {

	int id;
	String thing;
	int money;
	String mtype;
	String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	Account (){}
	public Account(String thing,int money,String mtype,String time){
		this.thing = thing;
		this.money = money;
		this.mtype = mtype;
		this.time = time;
	}
	public Account(int id, String thing, int money, String mtype, String time) {
		this.id = id;
		this.thing = thing;
		this.money = money;
		this.mtype = mtype;
		this.time = time;
	}
}
