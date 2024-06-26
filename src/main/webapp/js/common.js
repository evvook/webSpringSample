function ajaxRequest(url,inputs,callback){
	
	var reqJson = inputs;
	/* 통신에 사용 될 XMLHttpRequest 객체 정의 */
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		/* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 처리*/
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			  if (httpRequest.status === 200) {
				var result = httpRequest.response;
				callback(result);
			  } else {
				alert('request에 뭔가 문제가 있어요.');
			  }
		}
	};
	
	/* Post 방식으로 요청 */
	httpRequest.open('POST', url, true);//경로 잡아줌
	/* Response Type을 Json으로 사전 정의 */
	httpRequest.responseType = "json";
	/* 요청 Header에 컨텐츠 타입은 Json으로 사전 정의 */
	httpRequest.setRequestHeader('Content-Type', 'application/json');
	/* 정의된 서버에 Json 형식의 요청 Data를 포함하여 요청을 전송 */
	httpRequest.send(JSON.stringify(reqJson));
}