package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import DBUtil.DBUtil;
import bean.Account;
import bean.Usertable;


public class Dao {

	/**
	 * ����
	 * @param name
	 * @param teacher
	 * @param classroom
	 * @return
	 */
	public List<Account> search(String time, String mtype) {
		String sql = "select * from account where ";
		if (time != "") {
			sql += "time like '%" + time + "%'";
		}
		if (mtype != "") {
			sql += "mtype like '%" + mtype + "%'";
		}
		List<Account> list = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement state = null;
		ResultSet rs = null;

		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			Account bean = null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String thing = rs.getString("thing");
				int money = rs.getInt("money");
				String mtype1 = rs.getString("mtype");
				String time1= rs.getString("time");
				bean = new Account(id,thing,money,mtype1,time1);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
			DBUtil.close(state);
			DBUtil.close(rs);
		}
		
		return list;
	}
	
	/**
	 * �޸�
	 * @param name
	 * @param pass
	 */
	public boolean update(Usertable user) {
		String sql = "update usertable set pwd='" + user.getPwd() + "' where username='" + user.getUsername() + "'";
		Connection connection = DBUtil.getConnection();
		System.out.println(user.getPwd()+user.getUsername());
		Statement statement = null;
		ResultSet rs = null;
		boolean f = false;
		int a = 0;

		try {
			statement = connection.createStatement();
			a = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(statement);
			DBUtil.close(rs);	
		}
		
		if (a > 0) {
			f = true;
		}
		return f;
	}
	
	/*
	 * ����û����Ƿ���ڣ����ڷ���false�������ڷ���ture*/
		public boolean checkusername(String username){
			boolean flag = true;
			Connection connection = DBUtil.getConnection();
			System.out.println("success!");
			Statement statement = null;
			ResultSet rs = null;
			
			try {
				statement = connection.createStatement();			
				rs = statement.executeQuery("select * from usertable");
				while(rs.next()) {
					if(username.equals(rs.getString("username"))) {
						flag = false;
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(connection);
				DBUtil.close(statement);
				DBUtil.close(rs);	
			}
			return flag;
		}
		
		
		/*
		 * ������û���Ϣ*/
		public static void addusers(Usertable usertable) {
			Connection con = DBUtil.getConnection();
			ResultSet rs = null;
			Statement statement = null;
			try {
				String sql = "insert into usertable(username,pwd,mail)"
						+ " values('"+usertable.getUsername()+"','"+usertable.getPwd()+"','"+usertable.getMail()+"')";
				statement = con.prepareStatement(sql);
				statement.executeUpdate(sql);
				System.out.println("���û�ע��ɹ�");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(con);
				DBUtil.close(rs);
				DBUtil.close(statement);
			}
		}

		
		/*
		 * �����ˮ��
		 * ʱ����Ҫ��֮ǰ����*/
		public static void addNote(Account account) {
			Connection con = DBUtil.getConnection();
			ResultSet rs = null;
			Statement statement = null;
			try {
				String sql = "insert into account(thing,money,mtype,time) values('"+account.getThing()+"','"+account.getMoney()+"','"+account.getMtype()+"','"+account.getTime()+"')";
				statement = con.prepareStatement(sql);
				statement.executeUpdate(sql);
				System.out.println("��ˮ�˼�¼�ɹ�");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(con);
				DBUtil.close(rs);
				DBUtil.close(statement);
			}
		}
		
		public static String getNowTime() {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	        System.out.println("��ǰʱ�䣺"+df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	        return df.format(new Date());
		}
		
		/**
		 * ͨ��user�õ�pwd
		 * @return
		 */
		public Usertable getpwdByuser(String username) {
			String sql = "select * from usertable where username ='" + username + "'";
			Connection conn = DBUtil.getConnection();
			System.out.println(username+"����getpwdByuser���������ݿ����ӳɹ�");
			Statement state = null;
			ResultSet rs = null;
			String pwd = null;
			Usertable bean = null;
			try {
				state = conn.createStatement();
				rs = state.executeQuery(sql);
				while (rs.next())
				{
					pwd = rs.getString("pwd");
					bean = new Usertable(username,pwd);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn);
				DBUtil.close(rs);
				DBUtil.close(state);
			}
			
			return bean;
		}
		
		/**
		 * ȫ������
		 * @param name
		 * @param teacher
		 * @param classroom
		 * @return
		 */
		public List<Account> list() {
			String sql = "select * from account";
			List<Account> list = new ArrayList<>();
			Connection conn = DBUtil.getConnection();
			Statement state = null;
			ResultSet rs = null;

			try {
				state = conn.createStatement();
				rs = state.executeQuery(sql);
				Account bean = null;
				while (rs.next()) {
					int id = rs.getInt("id");
					String thing = rs.getString("thing");
					int money = rs.getInt("money");
					String mtype = rs.getString("mtype");
					String time = rs.getString("time");
					bean = new Account(id,thing,money,mtype,time);
					list.add(bean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn);
				DBUtil.close(rs);
				DBUtil.close(state);
			}
			
			return list;
		}
		
}
