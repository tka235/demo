package com.justsystems.fresher.score;

/**
 * 定数値を定義したクラスです。
 */
public class Constants {

    private Constants() {};

    /** 赤点のしきい値 */
    public static final int RED_SCORE = 30;

    /**
     * スコアーを表すキー値です。
     */
    public static final String ATTR_SCORES = "scores";

    /**
     * 平均点を表すキー値です。
     */
    public static final String ATTR_AVERAGE_SCORE = "average_score";


    /** スコアーを表示する */
    public static final String JSP_SCORE = "/WEB-INF/jsp/score.jsp";

}
