package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���������ַ�����������
		request.setCharacterEncoding("utf-8");
		User u = new User();
		//���ձ��ύ��Ϣ
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		u.setUserName(userName);
		u.setPassWord(passWord);
		if(u.getUserName().equals("admin")&&u.getPassWord().equals("admin")){
			//����session�������ڲ�ͬwebҳ��֮�䴫�ݱ���
			request.getSession().setAttribute("loginUser",u);
			//վ��ҳ����ת
			request.getRequestDispatcher("../login_success.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("../login_failure.jsp").forward(request, response);
		}
	}

}
