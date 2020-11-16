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
	<div class="row mt">
		<div class="col-md-12">
			<div class="form-panel">
				<h4 class="mb">
					<i class="fa fa-angle-right"></i> 상영시간표 조회
				</h4>
				<form class="form-horizontal style-form" method="post" name="form">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"> 영화 선택</label>
						<div class="col-sm-10">
							<select name="movie_name" class="btn btn-theme dropdown-toggle"
								style="display: block; width: 500px;" required="required">
								<c:forEach items="${movieList }" var="movie">
									<option value="${movie }"
										${movie == movie_name ? 'selected="selected"' : '' }>${movie }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"> 영화관 선택</label>
						<div class="col-sm-10">
							<select name="theater_code" class="btn btn-theme dropdown-toggle"
								style="display: block; width: 500px;" id="theater"
								required="required">
								<c:forEach items="${theaterList }" var="tl">
									<option value="${tl.theater_code }"
										${tl.theater_code == theater_code ? 'selected="selected"' : '' }>${tl.theater_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group"
						style="padding-bottom: 0px; border-bottom: none;">
						<div class="pull-right">
							<button type="submit" class="btn btn-theme"
								style="margin-right: 30px">
								<i class="fa fa-check"></i> 조회
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<c:choose>
		<c:when test="${empty theater_code }">
		</c:when>
		<c:when test="${empty movie }">
			<div class="col-md-12">
			<div class="form-panel">
			데이터가 없습니다.
			</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-lg-12">
				<c:forEach items="${movie.roomlist }" var="room" end="2">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<div class="custom-box">
							<div class="servicetitle">
								<h4>${room.room_name }${room.room_type }</h4>
								<hr style="width: 80%;">
							</div>
							<ul class="pricing">
								<c:forEach items="${room.timelist }" var="time">
									<li>${time.timeinfo }:${time.seatinfo } <a
										class="btn btn-theme btn-xs"
										href="http://www.cgv.co.kr/${time.reserveurl }"
										target="_blank">예매하기</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-lg-12">
				<c:forEach items="${movie.roomlist }" var="room" begin="3" end="5">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<div class="custom-box">
							<div class="servicetitle">
								<h4>${room.room_name }${room.room_type }</h4>
								<hr style="width: 80%;">
							</div>
							<ul class="pricing">
								<c:forEach items="${room.timelist }" var="time">
									<li>${time.timeinfo }:${time.seatinfo } <a
										class="btn btn-theme btn-xs"
										href="http://www.cgv.co.kr/${time.reserveurl }"
										target="_blank">예매하기</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-lg-12">
				<c:forEach items="${movie.roomlist }" var="room" begin="6" end="8">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<div class="custom-box">
							<div class="servicetitle">
								<h4>${room.room_name }${room.room_type }</h4>
								<hr style="width: 80%;">
							</div>
							<ul class="pricing">
								<c:forEach items="${room.timelist }" var="time">
									<li>${time.timeinfo }:${time.seatinfo } <a
										class="btn btn-theme btn-xs"
										href="http://www.cgv.co.kr/${time.reserveurl }"
										target="_blank">예매하기</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:otherwise>
		</c:choose>
	</div>
</body>
</html>