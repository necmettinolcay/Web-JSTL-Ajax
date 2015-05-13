
function getRequestObject() {
	if (window.ActiveXObject) { 
		return(new ActiveXObject("Microsoft.XMLHTTP"));
	} else if (window.XMLHttpRequest) {
	    return(new XMLHttpRequest());
	} else {
	    return(null);
	}
}

function htmlInsert(id, htmlData) {
    document.getElementById(id).innerHTML = htmlData;
}

function getValue(id) {
	return(escape(document.getElementById(id).value));
}

function ajaxPost(address, data, responseHandler) {
	var request = getRequestObject();
	request.onreadystatechange = 
	
	function() { responseHandler(request); };
	request.open("POST", address, true);
	request.setRequestHeader("Content-Type", 
	                        "application/x-www-form-urlencoded");
	request.send(data);
}

function getElementValues(element, subElementNames) {
	var values = new Array(subElementNames.length);
	for(var i=0; i<subElementNames.length; i++) {
		var name = subElementNames[i];
		var subElement = element.getElementsByTagName(name)[0]
		values[i] = getBodyContent(subElement);
	}
	return(values);
}

function getBodyContent(element) {
	element.normalize();
	return(element.childNodes[0].nodeValue);
}

function getXmlValues(xmlDocument, xmlElementName) {
	var elementArray =
		xmlDocument.getElementsByTagName(xmlElementName);	  
	var valueArray = new Array();
	for(var i=0; i<elementArray.length; i++) {
		valueArray[i] = 
	    elementArray[i].childNodes[0].nodeValue;
	}
	return(valueArray);
}

function getTable(headings, rows) {
	var table = "<table border='1'>\n" +
	         	getTableHeadings(headings) +
	            getTableBody(rows) +
	            "</table>";
	return(table);
}

function getTableHeadings(headings) {
	var firstRow = "  <tr>";
	for(var i=0; i<headings.length; i++) {
		firstRow += "<th>" + headings[i] + "</th>";
	}
	firstRow += "</tr>\n";
	return(firstRow);
}

function getTableBody(rows) {
	var body = "";
	for(var i=0; i<rows.length; i++) {
		body += "  <tr>";
	    var row = rows[i];
	    for(var j=0; j<row.length; j++) {
	      body += "<td>" + row[j] + "</td>";
	    }
	    body += "</tr>\n";
	  }
	return(body);
}

try { console.log("Loading script"); 
} catch(e) { console = { log: function() {} }; }
