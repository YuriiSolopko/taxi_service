/**
 * Created by Jura on 15.05.2015.
 */
function registerOperator() {
    var login = $('#login');
    var password = $('#password');
    var passconf = $('#passconf');
    var loginErr = $('#login-err');
    var passErr = $('#pass-err');
    var passconfErr = $('#passconf-err');
    var regMessage = $('#regMessage');

    loginErr.html('');
    passErr.html('');
    passconfErr.html('');

    if (login.val().length < 4) {
        loginErr.html('Login must be at least 4 symbols length');
        return;
    }
    var re = /\s/;
    if (re.test(login.val())) {
        loginErr.html('Login should not contain spacing');
        return;
    }
    re = /[0-9]{10}/;
    if(password.val().length < 8) {
        passErr.html('Password must be at least 8 symbols length');
        password.val('');
        passconf.val('');
        return;
    }
    re = /[0-9]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain figures');
        password.val('');
        passconf.val('');
        return;
    }
    re = /[A-Z]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain capital letters');
        password.val('');
        passconf.val('');
        return;
    }
    re = /[a-z]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain small letters');
        password.val('');
        passconf.val('');
        return;
    }
    re = /\s/;
    if(re.test(password.val())) {
        passErr.html('Password should not contain spacing');
        password.val('');
        passconf.val('');
        return;
    }
    if(password.val() != passconf.val()) {
        passconfErr.html('Password confirm failed');
        passconf.val('');
        return;
    }
    var loginCheck = true;
    $.ajax({
        url: '/operatorLoginCheck',
        data: 'login=' + login.val(),
        type: 'GET',
        async: false,
        success: function(res) {
            if (!res) {
                loginErr.html('Login is already in use');
                loginCheck = false;
            }
        },
        error: function(event,xhr,options,exc) {
            loginCheck = false;
        }
    });
    if (loginCheck) {
        $.ajax({
            url: '/registerOperator',
            data: 'login=' + login.val() + '&password=' + password.val(),
            type: 'POST',
            success: function(res) {
                if (res) {
                    regMessage.html('Registration successful');
                    login.val('');
                    password.val('');
                    passconf.val('');
                } else {
                    regMessage.html('Error');
                    password.val('');
                    passconf.val('');
                }
            },
            error: function(event,xhr,options,exc) {
                alert(event + ' ' + xhr + ' ' + options + ' ' + exc);
            }
        });
    }
}