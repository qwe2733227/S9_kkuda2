<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <div id="event">
            <div class="e_link">
                <a href="#"><p>지금 가입하고 인기상품 <strong>100원</strong>에 받아가세요!</p></a>
                <button id="event_btn" type="button"><img src="https://res.kurly.com/pc/ico/1908/ico_close_fff_84x84.png" alt="e_close"></button>
            </div>
        </div>
        <div id="header">
            <div class="h_first">
                <div class="h_f_1">
                    <div>
                  	<c:choose>
                  		<c:when test="${empty loginSsInfo}">
                    		<a href="${pageContext.request.contextPath }/join">회원가입</a>
	                        <div>|</div>
	                        <a href="${pageContext.request.contextPath }/login">로그인</a>
	                        <div>|</div>
                   		</c:when>
                   		<c:otherwise>
                    		${loginSsInfo.mname }
	                        <div>|</div>
	                        <a href="${pageContext.request.contextPath }/logout">로그아웃</a>
	                        <div>|</div>
                   		</c:otherwise>
                   	</c:choose>
                        
                        
                        
                        <div>
                            <a href="${pageContext.request.contextPath }/notice">고객센터
                                <img src="https://res.kurly.com/pc/ico/1908/ico_down_16x10.png">
                            </a>
                            <div class="h_f_1_a3_hover" onclick="location.href='${pageContext.request.contextPath }/notice';">
                                <div>공지사항</div>
                                <div>자주하는 질문</div>
                                <div>1:1 문의</div>
                                <div>대량주문 문의</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="h_f_2">
                    <div id="main_logo" onclick="location.href='${pageContext.request.contextPath }/main';">
                        <img src="${pageContext.request.contextPath }/images/마켓컬리로고.svg" alt="main_logo">
                        <button type="button">마켓컬리</button>
                    </div>
                    <div id="search">
                        <input type="text" placeholder="검색어를 입력해주세요.">
                        <button type="button"><img src="${pageContext.request.contextPath }/images/search_logo.svg"></button>
                    </div>
                    <div id="buttons">
                        <button type="button"></button>
                        <button type="button"></button>
                        <button type="button" onclick="location.href='${pageContext.request.contextPath }/shopping_basket_guest.html';"></button>
                        <div class="buttons_first_hover">
                            <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHN2ZyB3aWR0aD0iMThweCIgaGVpZ2h0PSIxMXB4IiB2aWV3Qm94PSIwIDAgMTggMTEiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8dGl0bGU+ZHJvcGRvd25fdGFpbDwvdGl0bGU+CiAgICA8ZyBpZD0i67ew7Yuw7Lus66asLVBoYXNlLTEiIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIGlkPSJQQ19Ib21lX01hcmtldF/sp4TsnoXsi5wiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMTExLjAwMDAwMCwgLTEzMi4wMDAwMDApIj4KICAgICAgICAgICAgPGcgaWQ9ImRyb3Bkb3duX2JveCIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoOTc4LjAwMDAwMCwgMTMyLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPGcgaWQ9ImRyb3Bkb3duX3RhaWwiIHRyYW5zZm9ybT0idHJhbnNsYXRlKDEzMy4wMDAwMDAsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPHJlY3QgaWQ9IlJlY3RhbmdsZSIgZmlsbD0iI0ZGRkZGRiIgeD0iMCIgeT0iMCIgd2lkdGg9IjE4IiBoZWlnaHQ9IjExIj48L3JlY3Q+CiAgICAgICAgICAgICAgICAgICAgPHJlY3QgaWQ9IlJlY3RhbmdsZSIgZmlsbD0iI0RERERERCIgeD0iMCIgeT0iMTAiIHdpZHRoPSIxOCIgaGVpZ2h0PSIxIj48L3JlY3Q+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTksMCBMMTcuMjUsMTEgTDAuNzUsMTEgTDksMCBaIiBpZD0iQ29tYmluZWQtU2hhcGUiIGZpbGw9IiNEREREREQiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNOSwxLjY1IEwxNi4wMTYsMTAuOTk5IEwyLjAwOCwxMC45OTkgTDksMS42NSBaIiBpZD0iQ29tYmluZWQtU2hhcGUiIGZpbGw9IiNGRkZGRkYiPjwvcGF0aD4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+">
                            <img src="${pageContext.request.contextPath }/images/흰색 칸.png">
                            <div>
                                <p><strong>배송지를 등록</strong>하고<br>구매 가능한 상품을 확인하세요!</p>
                                <div>
                                    <button onclick="location.href='${pageContext.request.contextPath }/login.html';"><span>로그인</span></button>
                                    <button><img src="${pageContext.request.contextPath }/images/배송지search_logo.png"><span>주소검색</span></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>