package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int iboard = Integer.parseInt(req.getParameter("iboard"));
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        BoardVO data = BoardDAO.detailBoard(param);
        req.setAttribute("data", data);


        MyUtils.disForword(req,res,"/board/detail");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
