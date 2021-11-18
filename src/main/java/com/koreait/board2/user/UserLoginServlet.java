package com.koreait.board2.user;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//로그인 창 띄우는곳

        String jsp = "/WEB-INF/view/user/login.jsp";
        req.getRequestDispatcher(jsp).forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//로그인 처리 담당

        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO param = new UserVO();
        param.setUid(uid);
        param.setUpw(upw);

       int result = UserDAO.login(param);

       if(result == 1){
           param.setUpw(null); //비밀번호는 쓸 일이 없으니까
           HttpSession session = req.getSession();
           session.setAttribute("loginUser",param);
           res.sendRedirect("/board/list");
           return;
       }
       String err = null;

       switch (result){
           case 0: err = "로그인에 실패했습니다."; break;
           case 2: err = "아이디를 확인해주세요"; break;
           case 3: err = "비번을 확인해주세요"; break;
       }
       req.setAttribute("err",err);
       doGet(req,res);
    }
}
