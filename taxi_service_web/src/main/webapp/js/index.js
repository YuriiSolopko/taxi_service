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
        return;
    }
    re = /[0-9]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain figures');
        return;
    }
    re = /[A-Z]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain capital letters');
        return;
    }
    re = /[a-z]/;
    if(!re.test(password.val())) {
        passErr.html('Password must contain small letters');
        return;
    }
    re = /\s/;
    if(re.test(password.val())) {
        passErr.html('Password should not contain spacing');
        return;
    }
    if(password.val() != passconf.val()) {
        passconfErr.html('Password confirm failed');
        return;
    }
    regMessage.html('Success');
}