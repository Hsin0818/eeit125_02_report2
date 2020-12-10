<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />
<meta charset="UTF-8">
<title>新增活動資料</title>
</head>
<body>
<p>&nbsp;</p>
<hr>
<div class='center'>
<H1>新增活動資料</H1>
<form  action='InsertActServlet'  method='POST'  >
會員帳號:<input type='text'      name='MB_ID'   value='${param.MB_ID}'> <br> 
<font color='red' size='-3'>${error.MB_ID}</font><br><br>

活動圖片:<input type='file'  name='ACT_Image' value='${param.ACT_Image}'><br>
<font color='red' size='-3'>${error.ACT_Image}</font><br><br>

活動名稱:<input type='text'  name='ACT_Name' value='${param.ACT_Name}'><br>
<font color='red' size='-3'>${error.ACT_Name}</font><br><br>

活動主題:<input type='text'  name='ACT_Theme' value='${param.ACT_Theme}'><br>
<font color='red' size='-3'>${error.ACT_Theme}</font><br><br>

活動日期:<input type="datetime-local"  name='ACT_Date' value='${param.ACT_Date}'><br>
<font color='red' size='-3'>${error.ACT_Date}</font><br><br>

活動地點:<input type='text'  name='ACT_Loc' value='${param.ACT_Loc}'><br>
<font color='red' size='-3'>${error.ACT_Loc}</font><br><br>

活動簡介:<input type='text'  name='ACT_Intro' value='${param.ACT_Intro}'><br>
<font color='red' size='-3'>${error.ACT_Intro}</font><br><br>

活動嘉賓:<input type='text'  name='ACT_Guest' value='${param.ACT_Guest}'><br>
<font color='red' size='-3'>${error.ACT_Guest}</font><br><br>

活動人數:<input type='text'  name='ACT_Pax' value='${param.ACT_Pax}'><br>
<font color='red' size='-3'>${error.ACT_Pax}</font><br><br>

活動規則:<input type='text'  name='ACT_Rule' value='${param.ACT_Rule}'><br>
<font color='red' size='-3'>${error.ACT_Rule}</font><br><br>

活動標籤:<input type='text'  name='ACT_Tag' value='${param.ACT_Tag}'><br>
<font color='red' size='-3'>${error.ACT_Tag}</font><br><br>

活動場所:<input type='text'  name='ACT_Place' value='${param.ACT_Place}'><br>
<font color='red' size='-3'>${error.ACT_Place}</font><br><br>

<input type='submit'      name='name' value='提交' >
<input type='reset'      name='name' value='還原' ><br><br>	


<a href='${pageContext.request.contextPath}/ActHomepage.jsp'>回到活動管理</a>
</form>
</div>
</body>
</html>