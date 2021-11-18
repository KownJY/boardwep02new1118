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

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");

        if(loginUser == null){
            res.sendRedirect("/board/list");
            return;
        }
            MyUtils.disForword(req,res,"board/write");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String tile = req.getParameter("tile");
        String ctnt =req.getParameter("ctnt");


        HttpSession session =req.getSession();
        UserVO loginUser =(UserVO)session.getAttribute("loginUser");

        BoardVO param = new BoardVO();
        param.setTile(tile);
        param.setCtnt(ctnt);
        param.setWriter(loginUser.getIuser());


        int result = BoardDAO.insBoard(param);
       // res.sendRedirect("/board/list");

        switch (result){
            case 1 : res.sendRedirect("/board/list"); break;
            default: req.setAttribute("err","글 등록 실패.");doGet(req,res); break;
        }


    }
}
