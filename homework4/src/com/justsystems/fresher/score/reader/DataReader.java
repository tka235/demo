package com.justsystems.fresher.score.reader;

import com.justsystems.fresher.score.model.Result;


/**
 * データを読み込むクラスが実装すべき処理を定義したインターフェイスです。
 */
public interface DataReader {

    /**
     * データソースから、データの読み込み結果を生成して返します。
     *
     * @return result データの読み込み結果
     * @throws Exception データの読み込みに失敗した場合にスローされる。
     */
    public Result read() throws Exception;

}
