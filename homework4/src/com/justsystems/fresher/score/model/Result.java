package com.justsystems.fresher.score.model;

import java.util.List;

/**
 * データの読み込み結果を表すクラスです。<br>
 * <br>
 * 全生徒毎の成績と教科毎の平均点を保持します。
 */
public class Result {

    /** 全生徒の成績 */
    private List<Score> scores;

    /** 教科毎の平均点 */
    private AverageScore averageScore;


    /**
     * コンストラクタ
     *
     * @param scores 全生徒の成績
     * @param averageScore 教科毎の平均点
     */
    public Result(List<Score> scores, AverageScore averageScore) {
        this.scores = scores;
        this.averageScore = averageScore;
    }


    /**
     * 生徒毎の成績を返します。
     *
     * @return scores 生徒毎の成績
     */
    public List<Score> getScores() {
        return scores;
    }

    /**
     * 教科毎の平均点を返します。
     *
     * @return averageScore 教科毎の平均点
     */
    public AverageScore getAverageScore() {
        return averageScore;
    }
}
