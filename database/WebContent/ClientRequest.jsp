<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
</head>
<body>
<h1>New Request</h1> <br>
	<form action="newRequest">
	<center>
	  <table border="1" cellpadding="5">
				<tr>
					<th>Request ID </th>
					<td align="center" colspan="3">
						<p>${requestID}</p>
					<input type="hidden" name = "requestID" value="${requestID}">
					<input type="hidden" name = "status" value="P">			
					</td>
				</tr>
				
				<tr>
					<th>Note </th>
					<td align="center" colspan="3">
						<input type="text" name="note" size="100" value="Any notes" onfocus="this.value=''">
					</td>
				</tr>
				</table>
				
				<div id="tree_data"></div>
				<button type="button" onclick="addTreeInfo()">Add New Tree</button>
				<input type="hidden" id="addTreeCounterValue" name="addTreeCounter" value="0"> <!-- Hidden input field -->
				
				<br>
				<button type="submit">Submit</button>
				
        		
       </center> 	
       </form>	
        <script>
        let fieldCounter = 1;
        let counter = 0;

        function addTreeInfo() {
            addField('TreeDistance');
            addField('TrunkSize');
            addField('TreeHeight');
            addField('TreeLocation');
            fieldCounter++;
            counter++;
            updateCounter();
        }
        
        function updateCounter(){
        	const counterElement = document.getElementById('addTreeCounterValue');
        	if(counterElement){
        		counterElement.value = counter;
        	}
        }

        function addField(fieldType) {
        	const inputFieldsDiv = document.getElementById("tree_data");
            
            const paragraph = document.createElement("p"); // Create a paragraph element

            const label = document.createElement("label");
            label.textContent = fieldCounter + '.'+ fieldType+': ';
            
            const input = document.createElement("input");
            input.type = "number";
            input.name = fieldType+fieldCounter;
            
            const lineBreak = document.createElement("br");
            

            
            paragraph.appendChild(label); // Append label to the paragraph
            paragraph.appendChild(input); // Append input to the paragraph

            inputFieldsDiv.appendChild(paragraph); // Append the paragraph to the tree_data div
            inputFieldsDiv.appendChild(lineBreak); // Append line break after the paragraph
        

            
        }
        
    </script>  
</body>
</html>
