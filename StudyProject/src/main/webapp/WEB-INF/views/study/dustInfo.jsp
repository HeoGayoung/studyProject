<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i> 서울시 실시간 자치구별 대기환경 현황
	</h3>
	<div class="row mt">

		<div class="col-lg-12">
			<div class="form-panel">
				<h4>
					<i class="fa fa-angle-right"></i> 지역 선택
				</h4>
				<form class="form-inline" role="form" method="post">
					<select class="form-control" name="regionCode" style="width: 200px;">
						<option value="" ${regionCode == rl.regionCode ? 'selected="selected"' : '' }>전체</option>
						<c:forEach items="${regionList }" var="rl">
							<option value="${rl.regionCode }"
								${regionCode == rl.regionCode ? 'selected="selected"' : '' }>${rl.regionNm }</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-theme">선택</button>
				</form>
			</div>
		</div>
		
		<div class="col-lg-12">
			<div class="form-panel">
			<fmt:parseDate value="${dustInfoList[0].msDt}" pattern="yyyyMMddHHmm" var="d"/>
			<fmt:formatDate value="${d }" pattern="yyyy-MM-dd HH:mm" var="dt"/>
              <h6 style="text-align: right; margin: 0px;">${dt }</h6>
              <table class="table">
                <thead>
                  <tr>
                    <th style="width: 20%;">지역명</th>
                    <th style="width: 20%;">통합대기환경등급</th>
                    <th style="width: 20%;">통합대기환경지수</th>
                    <th style="width: 20%;">미세먼지</th>
                    <th style="width: 20%;">초미세먼지</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${dustInfoList }" var="dil">
                  <tr>
                    <td>${dil.regionNm}</td>
                    <td>
                    	<c:choose>
                    		<c:when test="${dil.airGrade eq '점검중'}">-</c:when>
                    		<c:otherwise>${dil.airGrade}</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${dil.airIndex eq '-99'}">-</c:when>
                    		<c:otherwise>${dil.airIndex}</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${dil.fineDust eq '점검중'}">-</c:when>
                    		<c:otherwise>${dil.fineDust}</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${dil.ultrafineDust eq '점검중'}">-</c:when>
                    		<c:otherwise>${dil.ultrafineDust}</c:otherwise>
                    	</c:choose>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
	</div>

</body>
</html>