<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input onchange="change();">
	<button onclick="dochange();">click</button>
	<div></div>
	<script type="text/javascript">
		function dochange() {
			var input = document.getElementsByTagName("input")[0];
			var div = document.getElementsByTagName("div")[0];

			var str = "";
			input.setAttribute("value", "bbb");
			for ( var i in window) {
				str += i + "=" + window[i] + "<BR>";
			}
			div.innerHTML = str;
		}

		function change() {
			alert(this);
		}
	</script>

</body>
</html>