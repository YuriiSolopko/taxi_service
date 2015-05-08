/**
 * Created by Jura on 09.04.2015.
 */

function auth() {
    var ajax = new XMLHttpRequest();
    var login = document.getElementById('login');
    var password = document.getElementById('password');
    var error = document.getElementById('errorMessage');
    error.innerHTML = '';
    var tries = document.getElementById('tries');
    tries.innerHTML = '';
    var params = 'login=' + login.value + '&password=' + password.value;
    ajax.open('POST', '/auth', 'false');
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.setRequestHeader("Content-length", params.length);
    ajax.setRequestHeader("Connection", "close");
    ajax.send(params);
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var array = ajax.responseText.split('?');
            login.setAttribute("value", '');
            password.setAttribute("value", '');
            if (array[0] != '/') {
                window.location.href = array[0];
            }
            if (array[1] != undefined) {
                error.innerHTML = array[1];
            }
            if (array[2] > 0) {
                tries.innerHTML = 'You have ' + array[2] + ' more tries';
            }
        }
    };



}