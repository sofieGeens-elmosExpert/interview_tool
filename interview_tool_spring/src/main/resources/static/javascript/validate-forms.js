(function(){
    "use strict"

    let errorList = [];
    const alerts = document.getElementsByClassName("alerts")[0];

    function checkRequiredFields() {
        const requiredFields = document.querySelectorAll("[required]");
        for (let i = requiredFields.length - 1; i >= 0; i--) {
            if (isFieldEmpty(requiredFields[i])) {
                errorList.push("please fill in " + requiredFields[i].name);
                requiredFields[i].classList.add("highlight");
            }
            else{
                requiredFields[i].classList.remove("highlight");
            }
        }
    }

    function checkEmail() {
        const email = document.getElementById("email");
        if (!isEmail(email)) {
            errorList.push("please fill in a valid email");
            email.classList.add("highlight");
        }
        else{
            email.classList.remove("highlight");
        }
    }

    function checkRole() {
        let radios = document.getElementsByClassName("role");
        // verify if radio is checked
        let found_check = checkRadio(radios);
        // show error if no checked
        if (!found_check) errorList.push("please check one role");
    }

    function checkQType() {
        let radios = document.getElementsByClassName("qType");
        // verify if element is present on current page
        if (radios.length > 0) {
            // verify if radio is checked
            let found_check = checkRadio(radios);
            // show error if no checked
            if (!found_check) errorList.push("please check when the question should be asked");
        }
    }

    function checkCategory() {
        let radios = document.getElementsByClassName("category");
        // verify if element is present on current page
        if (radios.length > 0) {
            // verify if radio is checked
            let found_check = checkRadio(radios);
            // show error if no checked
            if (!found_check) errorList.push("please check who should ask the question");
        }
    }

    function checkRadio(radios) {
        // verify page has radios
        if (radios.length > 0) {
            // verify every radio button
            for (let i = 0; i < radios.length; i++) {
                if (radios[i].checked) {
                    return true;
                }
            }
            return false;
        }
    }

    function isFieldEmpty(field) {
        return field.value === "";
    }

    function isEmail(field) {
        const validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
        return field.value.match(validRegex);
    }

    function checkPassword(){
        const password = document.getElementById("password");
        if (password.value.length < 8) {
            errorList.push("Password must be at least 8 characters");
            password.classList.add("highlight");
        }
        else {
            password.classList.remove("highlight");
        }
    }

    function checkConfirmPassword() {
        const confPassword = document.getElementById("password_conf");
        const password = document.getElementById("password");
        console.log(confPassword.value)
        console.log(password.value)
        if (confPassword.value !== password.value) {
            errorList.push("Password and confirm password do not match");
            console.log("passwords do not match");
            password.classList.add("highlight");
            confPassword.classList.add("highlight");
        }
        else {
            password.classList.remove("highlight");
            confPassword.classList.remove("highlight");
        }
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
        errorList =[];
        checkRequiredFields();
        checkEmail();
        checkRole();
        checkCategory();
        checkQType();
        checkPassword();
        checkConfirmPassword();
        if (errorList.length > 0) {
            console.log("errors");
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