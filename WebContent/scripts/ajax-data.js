
function xmlStudentTable(inputField, resultRegion) {
	var address = "ShowDetails";
	var data = "ogrenciID=" + getValue(inputField) +
				"&format=xml";	
	ajaxPost(address, data,
			function(request) {
			  showXmlStudentInfo(request, resultRegion);
	});
}

function showXmlStudentInfo(request, resultRegion) {
    if ((request.readyState == 4) &&
			(request.status == 200)) {
    	var xmlDocument = request.responseXML;
		var headings = getXmlValues(xmlDocument, "heading");
		var students = xmlDocument.getElementsByTagName("student");
		var rows = new Array(students.length);
		var subElementNames = ["id", "name", "lesson"];
		for (var i=0; i<students.length; i++) {
			rows[i] =
			getElementValues(students[i], subElementNames);
		}
		var table = getTable(headings, rows);
		htmlInsert(resultRegion,table);	
	}
}
