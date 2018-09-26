package com.justsystems.fresher.score.reader;

import javax.servlet.ServletContext;

/**
 * データをロードするReaderのFactoryクラスです。
 */
public class DataReaderFactory {

    private static final DataReaderFactory factory = new DataReaderFactory();


    /**
     * コンストラクタ。インスタンス化の必要無し
     */
    private DataReaderFactory() {};

    /**
     * このクラスのインスタンスを返します。
     *
     * @return DataReaderFactory
     */
    public static DataReaderFactory getInstance() {
        return factory;
    }

    /**
     * DataReaderのインスタンスを生成して返します。
     *
     * @param context サーブレットコンテキスト
     * @return dataReader dataReaderのインスタンス
     */
    public DataReader createDataReader(ServletContext context) {
        // TODO DataReaderのインスタンス生成をおこなう。
        return null;
    }

}
