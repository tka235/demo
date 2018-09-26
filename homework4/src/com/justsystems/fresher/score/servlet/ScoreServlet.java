package com.justsystems.fresher.score.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.justsystems.fresher.score.Constants;
import com.justsystems.fresher.score.model.Result;
import com.justsystems.fresher.score.reader.DataReader;
import com.justsystems.fresher.score.reader.DataReaderFactory;

/**
 * 【ポイント】<br>
 * 課題3までの独立プログラムでは、「public static void main(String[] args)」がプログラムの起点でした。<br>
 * わかりやすくするため、過去に公開してきたサンプル回答では「Main.java」クラスに上記のメソッドを配置してきています。<br>
 * <br>
 * Webサービスのサーバー側プログラムでは、「mainメソッド」はフレームワーク内（今回はTomcat内）で<br>
 * 自動的に呼び出されます。そして、「クライアントからサーバーにリクエストが送られてくるタイミング」<br>
 * を起点として、アプリケーションの独自処理を作成していきます。<br>
 * <br>
 * 「クライアントからサーバーにリクエストが送られてくるタイミング」を、プログラム上でどのように<br>
 * 取得できるかは、利用するフレームワークによります。今回使用するTomcatは、「Java Servlet」という<br>
 * Webサービス仕様を実装したもので、「HttpServlet.java」クラスが「Main.java」クラスの代わりに<br>
 * なるようになっています。<br>
 * <br>
 * クライアントからは、HTTPの仕様に沿って「Getリクエスト」や「Postリクエスト」がサーバーに送られてきます。<br>
 * Tomcatサーバーは送られてきたリクエストをJavaのオブジェクト（HttpServletRequest）に変換し、<br>
 * リクエストを受け取ったURLに対応するHttpServlet実装クラスのメソッド（doGet(..)やdoPost(..)）を呼び出します。<br>
 * <br>
 * このように、面倒な通信処理をフレームワークがカバーしてくれるため、開発者は「doGet(..)やdoPost(..)」が<br>
 * 「public static void main(String[] args)」であるかのように、アプリケーションの中核機能の実装に<br>
 * 注力することができます。<br>
 * <br>
 * 【ポイント】<br>
 * 今回の実装では、Servlet+JSP という、JavaによるWebサービスプログラムの基本形を使っています。<br>
 * <br>
 * 【ポイント】<br>
 * 間違いを承知で簡単に言うと、サーブレットとは「Javaサーバー内で .html 相当のページを構築して<br>
 * クライアントに返す仕組み」です。ユーザーがブラウザであるURLを開くと、対応するサーブレットが<br>
 * サーバー内で .html を構築して返してくれる、というのが、一番理解しやすい形ではないかと思います。<br>
 * <br>
 * もちろん、実際に .html というファイルを造るわけではなく、それ相当のバイト列を返すだけですし、<br>
 * .html 全体を構築することもまれで、Web画面の一部分だけを造って返すことがほとんどです。<br>
 * 最近では、サーブレットはデータを返すだけでHTMLの構築はクライアント側でJavascriptで行う、<br>
 * ということも多いでしょう。HTML向けのデータ構築などは一切行わず、既存のページにリダイレクト<br>
 * するだけ、という使い方も多いです。<br>
 * <br>
 * 正式な定義に悩まされるぐらいなら、ひとまず、上記のように「クライアントからの要求を受けて<br>
 * サーバーで何か処理をするための仕組み」ぐらいに考えておくと良いかと。<br>
 * <br>
 * 【ポイント】<br>
 * JSPとは、サーブレットの亜種です。通常のサーブレットでは、「Javaプログラム内でHTMLのタグまで全部書く」<br>
 * のですが、JSPでは、「HTMLタグで造ったページの一部に、Javaプログラムの結果を埋め込む」という書き方ができます。<br>
 * JSPファイルはHTMLファイルに近いものになるため、「Javaプログラムを知らないデザイナーでも、ページの構造を
 * 簡単に理解できる」というメリットがあります。<br>
 * ・・・が、ぶっちゃけ、これは建前です。JSPの理解しやすさには天と地の差があり、カオスなJSPは誰も読み解けなく<br>
 * なります。「上記の建前を意識して読みやすいJSPを書く」ことが大切です。<br>
 * <br>
 * 【ポイント】<br>
 * 最近のWebサービスでは、JSPを使わず、JavascriptからServlet等を呼び出す（Get/Postリクエストを送る）ことも多いです。<br>
 * ブラウザ外からの利用であれば、C#で造ったネイティブアプリ、iPhoneやAndroidアプリなどから<br>
 * 呼び出すこともあります。サーバー側の実装も、RubyやPHPなどを利用することも多いでしょう。<br>
 * 今回のサンプル回答は、数あるWebサービスの代表的な一形態、と捉えてください。<br>
 * <br>
 * 【ポイント】<br>
 * サーブレットプログラムでは、「あるURLに対するリクエストを、どのサーブレットに処理させるべきか」を、<br>
 * サーブレットコンテナ（Tomcat）に教えておく必要があります。Tomcatでは、WEB-INF フォルダ内の、web.xml が<br>
 * この役割を担っています。<br>
 * <br>
 * <br>
 * 成績データを取得して返すservletです。
 */

@WebServlet(name = "score", urlPatterns = {"/score"})
public class ScoreServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 【ポイント】<br>
     * サーブレットにおいて、「static void main(...) 」に相当する、プログラムの起点メソッドです。<br>
     * 「doGet, doPost, doPut など、HTTPのリクエスト仕様と対応したメソッドが用意されています。<br>
     * <br>
     * ここでは単純に結果を返す処理をしていますが、通常は、リクエストのURLやパラメタに従って<br>
     * 処理を切り替えていきます。<br>
     * <br>
     * 【ポイント】<br>
     * このサーブレットでは、HTMLの構築は行っていません。ファイルからスコアデータを読み込む<br>
     * ところだけを行い、あとの処理はJSPに任せています。このように、表示データの構築は<br>
     * サーブレットで行い、最後の表示はJSP（やJavascript）に任せると、コードがスッキリします。<br>
     * <br>
     * データをJSPに渡すために、HttpServletRequest の Attribute として積んでいます。<br>
     * 良く利用する手段です。<br>
     * <br>
     * 【ポイント】<br>
     * このサンプルプログラムでは、全般的に例外処理を怠けています。<br>
     * 通常は、ここの catch で取得後、ログファイルへの出力などを行う必要があります。<br>
     * また、各クラスでの例外処理も、throw Exception ではなく、それぞれ適した例外を<br>
     * 投げる必要があります。
     *
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            DataReaderFactory factory = DataReaderFactory.getInstance();
            DataReader reader = factory.createDataReader(this.getServletContext());
            Result result = reader.read();

            req.setAttribute(Constants.ATTR_SCORES, result.getScores());
            req.setAttribute(Constants.ATTR_AVERAGE_SCORE, result.getAverageScore());
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher(Constants.JSP_SCORE);
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
