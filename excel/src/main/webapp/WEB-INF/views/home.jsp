<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous">
</script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<title>Home</title>
</head>
<body>
	<h1>엑셀 파일 첨부 - DB Insert</h1>
	<form id="excelUploadForm" name="excelUploadForm"
		enctype="multipart/form-data" method="post"
		action="${pageContext.request.contextPath}/excelUploadAjax">
		<div class="contents">
			<div>첨부파일은 한개만 등록 가능합니다.</div>

			<dl class="vm_name">
				<dt class="down w90">첨부 파일</dt>
				<dd>
					<input id="excelFile" type="file" name="excelFile" />
				</dd>
			</dl>
		</div>

		<div class="bottom">
			<button type="button" id="addExcelImpoartBtn" class="btn"
				onclick="check()">
				<span>추가</span>
			</button>
		</div>
	</form>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
<script>
	function checkFileType(filePath) {
		var fileFormat = filePath.split(".");
		if (fileFormat.indexOf("xlsx") > -1) {
			return true;
		}else if(fileFormat.indexOf("xls") > -1){
			return true;	
		}
		else {
			return false;
		}

	}

	function check() {
		var file = $("#excelFile").val();
		if (file == "" || file == null) {
			alert("please select excel file");
			return false;
		} else if (!checkFileType(file)) {
			alert("can use excel");
			return false;
		}

		if (confirm("업로드 하시겠습니까?")) {
			var options = {
				success : function(data) {
					alert("모든 데이터가 업로드 되었습니다.");

				},
				type : "POST"
			};
			$("#excelUploadForm").ajaxSubmit(options);

		}
	}
</script>