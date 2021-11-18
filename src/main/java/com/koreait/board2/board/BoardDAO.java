package com.koreait.board2.board;

import com.koreait.board2.DbUtils;
import com.koreait.board2.model.BoardVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    public static int delBoard(BoardVO param){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM t_board WHERE iboard = ? and writer =? ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            ps.setInt(2,param.getWriter());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }

    public static BoardVO detailBoard(BoardVO param){

        Connection con =null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql ="select A.iboard, A.tile, A.writer,B.nm as writerNm, A.rdt, A.ctnt from t_board A inner join t_user B on A.writer = B.iuser where A.iboard =?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();

            if(rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(param.getIboard());
                vo.setTile(rs.getString("tile"));
                vo.setRdt(rs.getString("rdt"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriterNm(rs.getString("writerNm"));
                vo.setWriter(rs.getInt("writer"));
                return vo;
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }

        return null;

    }

    public static List<BoardVO> selBoard(){

        List<BoardVO> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select A.iboard, A.tile, A.rdt, B.nm as writerNm from t_board A inner join t_user B on A.writer = B.iuser order by iboard  desc";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTile(rs.getString("tile"));
                vo.setRdt(rs.getString("rdt"));
                vo.setWriterNm(rs.getString("writerNm"));
                list.add(vo);

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }

        return list;
    }

    public static int insBoard(BoardVO param){

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into t_board (tile,ctnt,writer) values (?,?,?) ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,param.getTile());
            ps.setString(2, param.getCtnt());
            ps.setInt(3,param.getWriter());
           return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps);
        }

        return 0;

    }

}
