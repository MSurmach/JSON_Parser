<html>
<head>
    <title>JSON Formatter</title>
</head>
<link href="${pageContext.request.contextPath}/styles/styles.css" rel="stylesheet" type="text/css">
<script src="../scripts/home.js"></script>
</head>
<body>
<div class="main">
    <div class="row centered">
        <span class="attractive-text">JSON Formatter</span>
    </div>
    <div class="row">
        <div class="col-3-4 centered">
            <div id="main-input">
                <textarea id="paste-json-area" class="json-text-area" placeholder="{}"></textarea>
                <br>
                <input class="button centered" value="Clear" onclick="">
                <input class="button centered" value="Process" onclick="">
                <input class="button centered" value="Browse file..." onclick="">
            </div>
        </div>
        <div class="col-1-4">
            <label class="small-attractive-text" for="template">Formatting template:</label>
            <br>
            <select class="button" id="template" name="template">
                <option value="compact">Compact</option>
                <option value="space-tab">Space Tab</option>
            </select>
        </div>
    </div>
    <div class="row result-card">
        <div class="row">
            <div class="col-3-4">
                <span class="serial-number">#1</span>
                <span class="date-and-time">date and time</span>
            </div>
            <div class="col-1-4">
                <div class="control-buttons">
                    <button><img src="https://img.icons8.com/fluency/48/000000/copy.png" alt="Copy" width="30"
                                 height="30"/></button>
                    <button><img src="https://img.icons8.com/fluency/48/000000/download.png" alt="Download" width="30"
                                 height="30"/></button>
                    <button><img src="https://img.icons8.com/fluency/48/000000/delete-sign.png" alt="Delete" width="30"
                                 height="30"/></button>
                </div>
            </div>
        </div>
        <div class="row centered">
            <textarea id="result-json" class="json-text-area"></textarea>
        </div>
    </div>
</div>
</body>
</html>