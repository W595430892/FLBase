package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Dao.Dao;
import bean.Usertable;
import bean.Account;



/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	Dao dao = new Dao();
	Usertable name = new Usertable();
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		req.setCharacterEncoding("utf-8");
   		String method = req.getParameter("method");
   		System.out.println(method);
   		if ("denglu".equals(method)) {//登录
   			System.out.println("ok");
   			denglucheck(req, resp);
   		}
   		else if("load".equals(method)) {//查看账单
   			System.out.println(method);
   			listall(req,resp);
   		}
   		else if("getuserbyid".equals(method)) {
   			System.out.println(method);
   			getUserById(req,resp);
   		}
   		else if("update1".equals(method)) {//修改密码
   			System.out.println(method);
   			Update1(req,resp);
   		}
   		else if("update2".equals(method)) {//修改密码
   			System.out.println(method);
   			Update2(req,resp);
   		}
   		else if("zhuce".equals(method)) {//注册
   			System.out.println(method);
   			Adduser(req,resp);
   		}
   		else if("addaccount".equals(method))//记账
   		{
   			Addaccount(req,resp);
   		}
   		else if("time".equals(method))
   		{
   			time(req,resp);
   		}
   		else if("mtype".equals(method))
   		{
   			mtype(req,resp);
   		}
   	}
       
    private void mtype(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset=utf8");
    	request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String time="";
		String mtype = request.getParameter("mtype");
		System.out.println(mtype);
		List<Account> account = dao.search(time, mtype);
		request.setAttribute("account", account);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	private void time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf8");
    	request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String mtype="";
		String time = request.getParameter("time");
		time = "2019-" + time;
		System.out.println(time);
		List<Account> account = dao.search(time, mtype);
		request.setAttribute("account", account);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	private void Update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset=utf8");
    	request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("name");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		Usertable bean1 = new Usertable(username,pwd1);
		Usertable bean = new Usertable(username,pwd2);
		int a = 0;
		if(dao.getpwdByuser(username).equals(bean1)) {
		if(dao.update(bean)) 
		{
			a = 1;
		}
		}
		request.setAttribute("a", a);
		request.getRequestDispatcher("change_res.jsp").forward(request, response);
	}

	private void Addaccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
    	response.setContentType("text/html;charset=utf8");
    	request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String thing = request.getParameter("thing");
		int money = Integer.valueOf(request.getParameter("money"));
		String mtype = request.getParameter("mtype");
		System.out.println(thing + mtype+money );
		String time = Dao.getNowTime();
		if(mtype.equals("支出"))
			{
				money =0-money;
				mtype = "支出";
			}
		else {mtype = "收入";}
		Account acc = new Account(thing,money,mtype,time);
		Dao.addNote(acc);
		int a = 0;
		//if(Dao.addNote(acc))
		//UUser = Integer.valueOf(request.getParameter("logname"));
		
		request.setAttribute("a", a);
		request.getRequestDispatcher("addacc_res.jsp").forward(request, response);
	}

	private void Adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("logname");
		String pwd = request.getParameter("logpass1");
		String mail = request.getParameter("mail");
		Usertable bean = new Usertable(username,pwd,mail);
		int a = 0;
		if(dao.checkusername(username))
		{
			Dao.addusers(bean);
			a = 1;
		}
		//UUser = Integer.valueOf(request.getParameter("logname"));
		
		request.setAttribute("a", a);
		request.getRequestDispatcher("zhuce_res.jsp").forward(request, response);
		
	}

	private void Update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = name.getUsername();
		System.out.println(username);
		request.setAttribute("username", username);
		request.getRequestDispatcher("change.jsp").forward(request, response);
	}

	private void getUserById(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void listall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		List<Account> account = dao.list();
		req.setAttribute("account", account);
		req.getRequestDispatcher("list.jsp").forward(req,resp);
	}

	private void denglucheck(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf8");
		req.setCharacterEncoding("utf-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		String username = req.getParameter("logname");
		String pwd = req.getParameter("logpass");
		String t = Dao.getNowTime();
		Usertable bean = new Usertable(username,pwd);
		System.out.println("用户名："+username+"密码："+pwd +"时间：" + t);
		int a = 0;
		if(!dao.checkusername(username))
		{
		Usertable p=dao.getpwdByuser(username);
		if(p.getPwd().equals(pwd))
		{
			a = 1;
			name = bean;
		}
		//UUser = Integer.valueOf(request.getParameter("logname"));
		}
		req.setAttribute("a", a);
		req.setAttribute("username", username);
		req.getRequestDispatcher("panduan.jsp").forward(req, resp);
		req.getRequestDispatcher("top.jsp").forward(req, resp);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
