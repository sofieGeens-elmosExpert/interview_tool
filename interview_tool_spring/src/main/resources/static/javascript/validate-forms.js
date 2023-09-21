(function(){
    "use strict"

    let errorList = [];
    const alerts = document.getElementById("alerts")

    function checkRequiredFields() {
        const requiredFields = document.querySelectorAll("[required]");
        for (let i = requiredFields.length - 1; i >= 0; i--) {
            if (isFieldEmpty(requiredFields[i])) {
                errorList.push("please fill in " + requiredFields[i].name)
            }
        }
    }

    function checkEmail() {
        const emailFields = document.getElementsByClassName("email");
        for (let i = emailFields.length - 1; i >= 0; i--) {
            if (isFieldEmpty(emailFields[i])) {
                continue;
            }
            if (!isEmail(emailFields[i])) {
                errorList.push("please fill in a valid email in field" + emailFields[i].name)
            }
        }
    }

    function isFieldEmpty(field) {
        return field.value === "";
    }

    function isEmail(field) {
        const validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
        return field.value.match(validRegex);
    }

    function showAlerts() {
        let errors = "";
        for (let i = errorList.length -1; i >= 0; i--) {
            errors += "<p>" + errorList[i] + "</p>";
        }
        return errors;
    }

    let submit = document.getElementById("submit");

    submit.addEventListener("click",function(event) {
        errorList = [];
        checkRequiredFields();
        checkEmail();
        if (errorList.length > 0) {
            alerts.innerHTML = showAlerts();
            alerts.classList.remove("is-hidden");
            event.preventDefault();
        }
        else {
            alerts.classList.add("is-hidden");
            alerts.innerHTML = "";
            event.target.submit();
        }
    });
})()