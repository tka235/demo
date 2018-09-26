package com.justsystems.fresher.score.model;

import java.math.BigDecimal;

/**
 * 教科毎の平均点を表すクラスです。
 */
public class AverageScore {

    /** 国語の平均点 */
    private float japanese;

    /** 理科の平均点 */
    private float science;

    /** 数学の平均点 */
    private float mathematics;

    /** 英語の平均点 */
    private float english;

    /** 社会の平均点 */
    private float socialStudies;


    /**
     * 国語の平均点を返します。
     *
     * @return 国語の平均点
     */
    public float getJapanese() {
        return new BigDecimal(japanese).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 理科の平均点を返します。
     *
     * @return 理科の平均点
     */
    public float getScience() {
        return new BigDecimal(science).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 数学の平均点を返します。
     *
     * @return 数学の平均点
     */
    public float getMathematics() {
        return new BigDecimal(mathematics).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 英語の平均点を返します。
     *
     * @return 英語の平均点
     */
    public float getEnglish() {
        return new BigDecimal(english).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 社会の平均点を返します。
     *
     * @return 社会の平均点
     */
    public float getSocialStudies() {
        return new BigDecimal(socialStudies).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 国語の平均点をセットします。
     *
     * @param japanese 国語の平均点
     */
    public void setJapanese(float japanese) {
        this.japanese = japanese;
    }

    /**
     * 理科の平均点をセットします。
     *
     * @param science 理科の平均点
     */
    public void setScience(float science) {
        this.science = science;
    }

    /**
     * 数学の平均点をセットします。
     *
     * @param mathematics 数学の平均点
     */
    public void setMathematics(float mathematics) {
        this.mathematics = mathematics;
    }

    /**
     * 英語の平均点をセットします。
     *
     * @param english 英語の平均点
     */
    public void setEnglish(float english) {
        this.english = english;
    }

    /**
     * 社会の平均点をセットします。
     *
     * @param socialStudies 社会の平均点
     */
    public void setSocialStudies(float socialStudies) {
        this.socialStudies = socialStudies;
    }

    /**
     * 平均点の合計を返します。
     *
     * @return total 平均点の合計
     */
    public float getTotal() {
        float total = this.english + this.japanese + this.mathematics + this.science + this.socialStudies;
        return new BigDecimal(total).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    @Override
    public String toString() {
        return "[japanese=" + japanese + ", science=" + science + ", math=" + mathematics
                + ", english=" + english + ", socialStudies=" + socialStudies + "]";
    }
}
