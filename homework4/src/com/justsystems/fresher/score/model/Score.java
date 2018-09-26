package com.justsystems.fresher.score.model;

/**
 * 一人の成績を表すクラスです。
 *
 * 【ポイント】<br>
 * データを保持するためのメンバ変数と、その入出力のためのsetter, getter からなるデータクラスです。<br>
 * 冗長にも思えるクラスですが、この形式のデータクラスを用意することで、多くのフレームワークが、<br>
 * 処理の自動化を行ってくれます。※今回は利用していません。
 */
public class Score {

    /** 出席番号 */
    private int id;

    /** 名前 */
    private String name;

    /** 国語の成績 */
    private int japanese;

    /** 理科の成績 */
    private int science;

    /** 数学の成績 */
    private int mathematics;

    /** 英語の成績 */
    private int english;

    /** 社会の成績 */
    private int socialStudies;


    /**
     * 出席番号を返します。
     *
     * @return 出席番号
     */
    public int getId() {
        return id;
    }

    /**
     * 出席番号をセットします。
     *
     * @param id
     *        出席番号
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 名前を返します
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前をセットします。
     *
     * @param name
     *        名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 国語の成績を返します。
     *
     * @return 国語の成績
     */
    public int getJapanese() {
        return japanese;
    }

    /**
     * 国語の成績をセットします。
     *
     * @param japanese
     *        国語の成績
     */
    public void setJapanese(int japanese) {
        this.japanese = japanese;
    }

    /**
     * 理科の成績を返します。
     *
     * @return 理科の成績
     */
    public int getScience() {
        return science;
    }

    /**
     * 理科の成績をセットします。
     *
     * @param science
     *        理科の成績
     */
    public void setScience(int science) {
        this.science = science;
    }

    /**
     * 数学の成績を返します
     *
     * @return 数学の成績
     */
    public int getMathematics() {
        return mathematics;
    }

    /**
     * 数学の成績をセットします。
     *
     * @param mathematics
     *        数学の成績
     */
    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    /**
     * 英語の成績を返します
     *
     * @return 英語の成績
     */
    public int getEnglish() {
        return english;
    }

    /**
     * 英語の成績をセットします。
     *
     * @param english
     *        英語の成績
     */
    public void setEnglish(int english) {
        this.english = english;
    }

    /**
     * 社会の成績を返します。
     *
     * @return 社会の成績
     */
    public int getSocialStudies() {
        return socialStudies;
    }

    /**
     * 社会の成績をセットします
     *
     * @param socialStudies
     *        社会の成績
     */
    public void setSocialStudies(int socialStudies) {
        this.socialStudies = socialStudies;
    }

    /**
     * 合計点を返します。
     *
     * @return 合計点
     */
    public int getTotal() {
        return this.english + this.japanese + this.mathematics + this.science
                + this.socialStudies;
    }

    @Override
    public String toString() {
        return "Score [id=" + id + ", name=" + name
                + ", japanese=" + japanese + ", science=" + science + ", math=" + mathematics
                + ", english=" + english + ", socialStudies=" + socialStudies + "]";
    }

}
