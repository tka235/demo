<%@page import="com.justsystems.fresher.score.model.AverageScore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.justsystems.fresher.score.model.Score"%>
<%@page import="com.justsystems.fresher.score.Constants"%>
<%@page import="java.util.List"%>

<%--
【ポイント】
	画面描画の本体を担うJSPです。
	見ての通り、ほとんどは普通のHTMLで、データの表示部のみ、Javaコードが入っています。
	このように、「JSP内ではJavaコードは少しだけ＝表示処理のみJSPに書き、ロジック部は
	Javaクラスに書く」という書き方を守ると良いです。

	例えば、このJSP中に「for文が2重に入り、その中でif文で処理の切替があり、try-catch で例外処理が・・」
	などとなっていると、あっという間にHTMLなのかJavaなのか分からない、読めないコードができあがります。
	ご注意を。
--%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="content-language" content="ja">
        <link rel="stylesheet" href="css/score.css" />
        <title>成績表</title>
    </head>
    <body>
        <h1>成績表</h1>
        <table>
            <tr>
                <th>番号</th>
                <th>氏名</th>
                <th>国語</th>
                <th>数学</th>
                <th>理科</th>
                <th>社会</th>
                <th>英語</th>
                <th>合計</th>
            </tr>
            <%
                for(Score score : (List<Score>)request.getAttribute(Constants.ATTR_SCORES)) {
            %>
                <tr>
                    <td><%= score.getId() %></td>
                    <td><%= score.getName() %></td>
                    <td class="right <%= score.getJapanese() < Constants.RED_SCORE ? "redScore" : "" %>"><%= score.getJapanese() %></td>
                    <td class="right <%= score.getMathematics()     < Constants.RED_SCORE ? "redScore" : "" %>"><%= score.getMathematics() %></td>
                    <td class="right <%= score.getScience()  < Constants.RED_SCORE ? "redScore" : "" %>"><%= score.getScience() %></td>
                    <td class="right <%= score.getSocialStudies()  < Constants.RED_SCORE ? "redScore" : "" %>"><%= score.getSocialStudies() %></td>
                    <td class="right <%= score.getEnglish()  < Constants.RED_SCORE ? "redScore" : "" %>"><%= score.getEnglish() %></td>
                    <td class="right"><%= score.getTotal() %></td>
                </tr>
            <%
                }
            %>
            <tr>
                <%
                    AverageScore average = (AverageScore)request.getAttribute(Constants.ATTR_AVERAGE_SCORE);
                %>
                <td colspan=2 class="center">平均</td>
                <td class="right"><%= average.getJapanese() %></td>
                <td class="right"><%= average.getMathematics() %></td>
                <td class="right"><%= average.getScience() %></td>
                <td class="right"><%= average.getSocialStudies() %></td>
                <td class="right"><%= average.getEnglish() %></td>
                <td class="right"><%= average.getTotal() %></td>
            </tr>
        </table>

    </body>
</html>