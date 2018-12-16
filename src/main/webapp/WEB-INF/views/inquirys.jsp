<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
.tg .tg-xldj{border-color:inherit;text-align:left}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 < <c:forEach var="inquiry" items="${inquirys}">

   
		<p>
			<c:out value="${inquiry}"></c:out>

		</p>
		
	</c:forEach> 
	 

<table class="tg">
  <tr>
    <th class="tg-xldj">년도</th>
    <th class="tg-xldj">학기</th>
    <th class="tg-xldj">이수학점</th>
    <th class="tg-xldj">상세보기</th>
  </tr>
  <tr>
    <td class="tg-xldj">2018</td>
    <td class="tg-xldj">1</td>
    <td class="tg-xldj">${inquiry}</td>
    <td class="tg-xldj"><a href="${pageContext.request.contextPath}/2018_1">링크</a></td>
  </tr>
  <tr>
    <td class="tg-xldj">2017</td>
    <td class="tg-xldj">2</td>
    <td class="tg-xldj"></td>
    <td class="tg-xldj"></td>
  </tr>
  <tr>
    <td class="tg-xldj">2017</td>
    <td class="tg-xldj">1</td>
    <td class="tg-xldj"></td>
    <td class="tg-xldj"></td>
  </tr>
  <tr>
    <td class="tg-0pky">2014</td>
    <td class="tg-0pky">2</td>
    <td class="tg-0pky">${inquriy2 }</td>
    <td class="tg-0pky"></td>
  </tr>
  <tr>
    <td class="tg-0pky">2014</td>
    <td class="tg-0pky">1</td>
    <td class="tg-0pky"></td>
    <td class="tg-0pky"></td>
  </tr>
</table>




	<a href="${pageContext.request.contextPath}/">메뉴로 돌아가기</a>
</body>
</html>