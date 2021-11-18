package com.koreait.board2.user;

import com.koreait.board2.DbUtils;
import com.koreait.board2.model.UserVO;

import java.sql.*;
import java.util.*;

public class UserDAO {

    public static int login(UserVO param){

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql ="select iuser,upw,nm from t_user where uid =?";

        try{
            con = DbUtils.getCon();
            ps= con.prepareStatement(sql);
            ps.setString(1,param.getUid());
            rs=ps.executeQuery();

//            if(rs.next()){
//                if(rs.getString("upw").equals(param.getUpw())){
//                    return 1;
//                }else {
//                    return 3;
//                }
//            }else{
//                return 2;
//            }

            if(rs.next()){
                param.setIuser(rs.getInt("iuser"));
                param.setNm(rs.getString("nm"));
                String upd = rs.getString("upw");
                return upd.equals(param.getUpw())? 1 : 3;
            }else {
                return 2;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }

        return 0;
    }

//    public static int login(UserVO param){
//        Connection con = null;
//        PreparedStatement ps = null;
//        String sql = "insert into t_user (uid,upw) values (?,? )";
//
//        try {
//            con = DbUtils.getCon();
//            ps=con.prepareStatement(sql);
//            ps.setString(1,param.getUid());
//            ps.setString(2,param.getUpw());
//            return ps.executeUpdate();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//
//            DbUtils.close(con,ps);
//        }
//        return 0;
//
//
//    }

    public static int join(UserVO param){

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into t_user (uid,upw,nm,gender) values (?,?,?,? )";

        try {
            con = DbUtils.getCon();
            ps=con.prepareStatement(sql);
            ps.setString(1,param.getUid());
            ps.setString(2,param.getUpw());
            ps.setString(3,param.getNm());
            ps.setInt(4,param.getGender());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            DbUtils.close(con,ps);
        }
        return 0;
    }

}
