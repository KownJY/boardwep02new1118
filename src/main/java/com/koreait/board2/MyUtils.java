package com.koreait.board2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyUtils {

    public static void disForword(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {


        String str = "/WEB-INF/view/" + jsp + ".jsp";

        req.getRequestDispatcher(str).forward(req, res);
    }

    public static int parseStringToInt(String str) {
        return parseStringToInt(str, 0);
    }

    public static int parseStringToInt(String str, int defVal) {

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {

        }

        return defVal;
    }

    public static int getParameterInt(HttpServletRequest req, String gender) {

//        String str = req.getParameter(gender);
//        int intval = parseStringToInt(str);
//        return intval;

        return parseStringToInt(req.getParameter(gender));

    }
}


