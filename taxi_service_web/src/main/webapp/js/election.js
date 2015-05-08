/**
 * Created by Jura on 15.04.2015.
 */
function auth() {
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var patronymic = $('#patronymic').val();
    var place = $('#place').val();
    var passportId = $('#passportId').val();

    var firstNameErr = $('#firstNameErr');
    var lastNameErr = $('#lastNameErr');
    var patronymicErr = $('#patronymicErr');
    var placeErr = $('#placeErr');
    var passportIdErr = $('#passportIdErr');

    firstNameErr.text('');
    lastNameErr.text('');
    patronymicErr.text('');
    placeErr.text('');
    passportIdErr.text('');

    if (firstName == '') {
        firstNameErr.text('Поле не может быть пустым');
    } else if (lastName == '') {
        lastNameErr.text('Поле не может быть пустым');
    } else if (patronymic == '') {
        patronymicErr.text('Поле не может быть пустым');
    } else if (place == '') {
        placeErr.text('Поле не может быть пустым');
    } else if (passportId == '') {
        passportIdErr.text('Поле не может быть пустым');
    } else {

        $.ajax({
            url: '/auth',
            data: 'firstName=' + firstName + '&lastName=' + lastName
                + '&patronymic=' + patronymic + '&place=' + place + '&passportId=' + passportId,
            type: 'POST',
            success: function(res) {
                if (res == '0') {
                    alert('Авторизация не пройдена');
                }  else if (res == '1') {
                    $('#form').css('display', 'none');
                    getCandidates(false);
                } else if (res == '2') {
                    $('#form').css('display', 'none');
                    getCandidates(true);
                } else if (res == '3') {
                    alert('Выборы уже закончились');
                }
            },
            error: function(event,xhr,options,exc) {
                alert(event + ' ' + xhr + ' ' + options + ' ' + exc);
            }
        });
    }
}


function getCandidates(disabled) {
    var form = $('#election');
    $.ajax({
        url: '/getCandidates',
        data: '',
        dataType: 'json',
        type: 'GET',
        success: function(data) {

            for (var i = 0; i < data.length; i++) {
                var input = $('<input type="radio" name="candidateId">');
                input.attr('disabled', disabled);
                input.attr('value', data[i].id)
                var candidate = $('<div> </div>');
                candidate.text(data[i].lastName + ' ' + data[i].firstName + ' ' + data[i].patronymic);
                form.append(input);
                form.append(candidate);
                form.append($('<br>'));
            }
            var button = $('<button class="button" onclick="vote()">Проголосовать</button>');
            button.attr('disabled', disabled);
            form.append(button);
        },
        error: function(event,xhr,options,exc) {
            alert(xhr + ' ' + options);
        }
    });
}

function vote() {
    var buttons = $(':checked');
    console.log('vote candidateId = ' + buttons.val());
    if (buttons.length == 0) {
        alert('Кандидат не выбран');
    } else {
        $.ajax({
            url: '/vote',
            data: 'candidateId=' + buttons.val(),
            type: 'POST',
            success: function (res) {
                if (res == 'true') {
                    alert('Ваш голос учтён')
                    window.location.href = '/';
                } else {
                    alert('Ошибка! Возможно вы уже проголосовали или время голосования прошло');
                }
            },
            error: function(event,xhr,options,exc) {
                alert(xhr + ' ' + options);
            }
        });
    }
}
