<html>
<head>
    <title>JSON Formatter</title>
</head>
<link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/scripts/home.js"></script>
</head>
<body>
<div class="main">
    <div class="row centered">
        <span class="attractive-text">JSON Formatter</span>
    </div>
    <div class="row">
        <div class="col-3-4 centered">
            <div class="card">
                <textarea id="json-input" class="text-area" placeholder="{}"></textarea>
                <div id="json-input-control-buttons">
                    <input class="button centered" value="Clear" onclick="">
                    <input class="button centered" value="Process" onclick="">
                    <input class="button centered" value="Browse file..." onclick="">
                </div>
            </div>
        </div>
        <div class="col-1-4">
            <div class="card">
                <label class="small-attractive-text" for="template">Template:</label>
                <select class="button" id="template" name="template">
                    <option value="compact">Compact</option>
                    <option value="space-tab">Space Tab</option>
                </select>
            </div>
            <div class="card">
                <div id="help-info">
                    <span class="small-attractive-text">You can paste in JSON, select a file, or load an <a
                            id="example-link" href="/home">example</a> to begin.</span>
                </div>
            </div>
        </div>
    </div>
    <div class="row result">
        <div class="col-3-4 centered">
            <div class="output centered card">
                <textarea id="result-output" class="text-area"></textarea>
            </div>
        </div>
        <div class="col-1-4">
            <div class="centered card">
                <span class="serial-number attractive-text">#1</span>
            </div>
            <div class="centered card">
                <span class="date-and-time small-attractive-text">date and time</span>
            </div>
            <div class="card centered">
                <button><img src="https://img.icons8.com/fluency/48/000000/copy.png" alt="Copy" width="30"
                             height="30"/></button>
                <button><img src="https://img.icons8.com/fluency/48/000000/download.png" alt="Download" width="30"
                             height="30"/></button>
                <button><img src="https://img.icons8.com/fluency/48/000000/delete-sign.png" alt="Delete" width="30"
                             height="30"/></button>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>