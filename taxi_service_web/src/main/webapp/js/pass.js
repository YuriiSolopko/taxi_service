/**
 * Created by Jura on 08.04.2015.
 */

function newPassCheck(operatorPass) {
    var oldPass = document.getElementById('oldpass').value;
    var newPass = document.getElementById('newpass').value;
    var confNewPass = document.getElementById('confnewpass').value;
    var oldPassSpan = document.getElementById('oldPassSpan');
    var newPassSpan = document.getElementById('newPassSpan');
    var confNewPassSpan = document.getElementById('confNewPassSpan');
    oldPassSpan.innerHTML = '';
    newPassSpan.innerHTML = '';
    confNewPassSpan.innerHTML = '';
    if (operatorPass != oldPass) {
        oldPassSpan.innerHTML = 'Old password is incorrect';
        return false;
    }
    if (newPass == oldPass) {
        newPassSpan.innerHTML = 'New password cannot be the same';
        return false;
    }
    if (newPass != confNewPass) {
        confNewPassSpan.innerHTML = 'Password confirm failed';
        return false;
    }
    if (newPass.length < 8) {
        newPassSpan.innerHTML = 'Password must be 8 symbols length at least';
        return false;
    }
    var re = /[0-9]/;
    if (!re.test(newPass)) {
        newPassSpan.innerHTML = 'New password must contain numbers';
        return false;
    }
    re = /[a-z]/;
    if (!re.test(newPass)) {
        newPassSpan.innerHTML = 'New password must contain small letters';
        return false;
    }
    re = /[A-Z]/;
    if (!re.test(newPass)) {
        newPassSpan.innerHTML = 'New password must contain capital letters';
        return false;
    }
    return true;
}

function registerCheck() {
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    var confirmPass = document.getElementById('confirmPass').value;
    var id = document.getElementById('id').value;
    var loginSpan = document.getElementById('loginSpan');
    var passwordSpan = document.getElementById('passwordSpan');
    var confirmPassSpan = document.getElementById('confirmPassSpan');
    var idSpan = document.getElementById('idSpan');
    loginSpan.innerHTML = '';
    passwordSpan.innerHTML = '';
    confirmPassSpan.innerHTML = '';
    idSpan.innerHTML = '';

    if (login.length < 4) {
        loginSpan.innerHTML = 'Login must be at least 4 symbols length';
        return false;
    }
    var re = /\s/;
    if (re.test(login)) {
        loginSpan.innerHTML = 'Login should not contain spacing';
        return false;
    }
    re = /[0-9]{10}/;
    if (id.length != 10 || !re.test(id)) {
        idSpan.innerHTML = 'ID must contain 10 figures';
        return false;
    }
    if(password.length < 8) {
        passwordSpan.innerHTML = 'Password must be at least 8 symbols length';
        return false;
    }
    re = /[0-9]/;
    if(!re.test(password)) {
        passwordSpan.innerHTML = 'Password must contain figures';
        return false;
    }
    re = /[A-Z]/;
    if(!re.test(password)) {
        passwordSpan.innerHTML = 'Password must contain capital letters';
        return false;
    }
    re = /[a-z]/;
    if(!re.test(password)) {
        passwordSpan.innerHTML = 'Password must contain small letters';
        return false;
    }
    re = /\s/;
    if(re.test(password)) {
        passwordSpan.innerHTML = 'Password should not contain spacing';
        return false;
    }
    if(password != confirmPass) {
        confirmPassSpan.innerHTML = 'Password confirm failed';
        return false;
    }
    return true;
}