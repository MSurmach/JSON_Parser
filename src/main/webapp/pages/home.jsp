<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSON Formatter</title>
</head>
<link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/scripts/home.js"></script>
</head>
<body>
<script>
    document.addEventListener("DOMContentLoaded", initializePage);
</script>
<div class="main">
    <div class="row centered">
        <span class="attractive-text">JSON Formatter</span>
    </div>
    <div hidden>
        <form id="hidden-form" action="/process" method="post">
            <input type="text" name="json-input" id="form-json-input">
            <input type="text" name="template" id="form-json-template">
            <input type="submit">
        </form>
    </div>
    <div class="row">
        <div class="col-3-4 centered">
            <div class="card">
                <textarea id="json-input" class="text-area" placeholder="{}"></textarea>
                <div id="json-input-control-buttons">
                    <input type="button" class="button centered" value="Clear" onclick="clearJsonInputBox()">
                    <input type="button" class="button centered" value="Process" onclick="processContent()">
                    <input type="button" class="button centered" value="Browse file..." onclick="browseFile()">
                    <input type="file" id="file-to-grab" onclick="this.value=null" onchange="fillInInputBox(this)"
                           hidden>
                </div>
            </div>
        </div>
        <div class="col-1-4">
            <div class="card">
                <label class="small-attractive-text" for="template">Template:</label>
                <select class="button" id="template" name="template">
                    <option value="COMPACT">Compacted</option>
                    <option value="SPACED">Spaced</option>
                </select>
            </div>
            <div class="card">
                <div id="help-info">
                    <span class="small-attractive-text">You can paste in JSON, select a file, or load an
                        <a href="javascript:void(0);" onclick="getExample()">example</a> to begin.</span>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${!empty listOfModels}">
        <c:forEach var="model" items="${listOfModels}">
            <div class="row result">
                <div class="col-3-4 centered">
                    <div class="output centered card">
                        <textarea id="result-output" class="text-area" readonly>${model.formattedJSONString}</textarea>
                    </div>
                </div>
                <div class="col-1-4">
                    <div class="centered card">
                        <span class="serial-number attractive-text">#${model.id}</span>
                    </div>
                    <div class="centered card">
                        <span class="date-and-time small-attractive-text">${model.dateAndTime}</span>
                    </div>
                    <div class="card centered">
                        <button>
                            <img src="https://img.icons8.com/fluency/48/000000/copy.png" alt="Copy" width="30"
                                 height="30" onclick="copyToClipboard()"/>
                        </button>
                        <button>
                            <img src="https://img.icons8.com/fluency/48/000000/download.png" alt="Download"
                                 width="30" height="30" onclick=""/>
                        </button>
                        <button>
                            <img src="https://img.icons8.com/fluency/48/000000/delete-sign.png" alt="Delete"
                                 width="30" height="30" onclick="location.href='/delete?id=${model.id}'"/>
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
</div>
</body>
</html>