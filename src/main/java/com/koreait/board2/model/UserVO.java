package com.koreait.board2.model;

public class UserVO {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private int gender;
    private String rdt;

    public int getIuser() {
        return iuser;
    }

    public void setIuser(int iuser) {
        this.iuser = iuser;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpw() {
        return upw;
    }

    public void setUpw(String upw) {
        this.upw = upw;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRdt() {
        return rdt;
    }

    public void setRdt(String rdt) {
        this.rdt = rdt;
    }
}
//    DROP TABLE t_user;
//        DROP TABLE t_board;
//
//        CREATE TABLE t_user(
//
//        iuser INT unsigned PRIMARY KEY AUTO_INCREMENT,
//        uid VARCHAR(20) unique NOT NULL,
//        upw VARCHAR(50) NOT NULL,
//        nm VARCHAR(10) NOT NULL,
//        gender INT unsigned CHECK(gender IN(0,1)),
//        rdt datetime DEFAULT NOW()
//
//        );
//
//
//        CREATE TABLE t_board(
//
//        iboard INT PRIMARY KEY AUTO_INCREMENT,
//        tile VARCHAR(100) NOT NULL,
//        ctnt VARCHAR(2000) NOT NULL,
//        writer INT UNSIGNED NOT NULL,
//        FOREIGN KEY (writer) REFERENCES t_user(iuser),
//        rdt DATETIME DEFAULT NOW(),
//        mdt DATETIME DEFAULT NOW()
//
//        );