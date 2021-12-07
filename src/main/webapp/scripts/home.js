let grabbedFile;
let jsonInputBox;
let templateSelector;

function initializePage() {
    grabbedFile = document.getElementById("file-to-grab");
    jsonInputBox = document.getElementById("json-input");
    templateSelector = document.getElementById("template");
}

function fillInInputBox(fileInput) {
    let fileReader = new FileReader();
    fileReader.onload = function () {
        jsonInputBox.value = fileReader.result;
    }
    fileReader.readAsText(fileInput.files[0]);
}

function clearJsonInputBox() {
    jsonInputBox.value = "";
}

function getExample() {
    let xhr = new XMLHttpRequest();
    let url = "/example";
    xhr.onload = function () {
        if (xhr.status !== 200) {
            alert("Wrong response")
        } else {
            let serverResponse = xhr.responseText;
            jsonInputBox.value = serverResponse;
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
    jsonInputBox.value = "example is loaded";
}

function processContent() {
    let json_input = document.getElementById("form-json-input");
    let template = document.getElementById("form-json-template");
    json_input.value = jsonInputBox.value;
    template.value = templateSelector.value;
    document.getElementById("hidden-form").submit();
}

function copyToClipboard() {
    let content = document.getElementById("result-output").value;
    navigator.clipboard.writeText(content).then(function () {
        alert("Copying to clipboard was successful!");
    }, function () {
        alert("Could not copy text!")
    });
}

function browseFile() {
    grabbedFile.click();
}