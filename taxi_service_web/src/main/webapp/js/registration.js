/**
 * Created by Jura on 17.04.2015.
 */
var vRegionSelect = $('<select id="vRegion"></select>');
var cRegionSelect = $('<select id="candReg"></select>');

var voterForm = $('<span></span>');
var candidateForm = $('<span></span>');
var regionForm = $('<span></span>');

voterForm.append($('<div class="label">Имя</div>'));
voterForm.append($('<input type="text" name="vFirstName" id="vFirstName">'));
voterForm.append($('<br>'));
voterForm.append($('<div class="label">Фамилия</div>'));
voterForm.append($('<input type="text" name="vLastName" id="vLastName">'));
voterForm.append($('<br>'));
voterForm.append($('<div class="label">Отчество</div>'));
voterForm.append($('<input type="text" name="vPatronymic" id="vPatronymic">'));
voterForm.append($('<br>'));
voterForm.append($('<div class="label">Населенный пункт</div>'));
voterForm.append($('<input type="text" name="vPlace" id="vPlace">'));
voterForm.append($('<br>'));
voterForm.append($('<div class="label">Серия и номер пасспорта</div>'));
voterForm.append($('<input type="text" name="vPassportId" id="vPassportId">'));
voterForm.append($('<br>'));
voterForm.append($('<div class="label">Регион</div>'));
voterForm.append(vRegionSelect);
voterForm.append($('<br>'));
voterForm.append('<button onclick="registerVoter()">Зарегистрировать</button>');

candidateForm.append($('<div class="label">Имя</div>'));
candidateForm.append($('<input type="text" name="candName" id="candName">'));
candidateForm.append($('<br>'));
candidateForm.append($('<div class="label">Фамилия</div>'));
candidateForm.append($('<input type="text" name="candSur" id="candSur">'));
candidateForm.append($('<br>'));
candidateForm.append($('<div class="label">Отчество</div>'));
candidateForm.append($('<input type="text" name="candFather" id="candFather">'));
candidateForm.append($('<br>'));
candidateForm.append($('<div class="label">Регион</div>'));
candidateForm.append(cRegionSelect);
candidateForm.append($('<br>'));
candidateForm.append('<button onclick="registerCandidate()">Зарегистрировать</button>');

regionForm.append($('<div class="label">Название региона</div>'));
regionForm.append($('<input type="text" name="regionName" id="regionName">'));
regionForm.append($('<br>'));
regionForm.append('<button onclick="registerRegion()">Добавить</button>');

function voterReg() {
    var form = $('#form');
    form.html('');
    vRegionSelect.html('');

    $.ajax({
        url: '/getRegions',
        dataType: 'json',
        type: 'GET',
        success: function(regions) {
            for (var i = 0; i < regions.length; i++) {
                var option = $('<option></option>')
                option.attr('value', regions[i].name);
                option.text(regions[i].name)
                vRegionSelect.append(option);
            }
        },
        error: function(event,xhr,options,exc) {
            console.log('Регионы не найдены');
        }
    });
    form.append(voterForm);
}

function candidateReg() {
    var form = $('#form');
    form.html('');
    cRegionSelect.html('');

    $.ajax({
        url: '/getRegions',
        dataType: 'json',
        type: 'GET',
        success: function(regions) {
            for (var i = 0; i < regions.length; i++) {
                var option = $('<option></option>')
                option.attr('value', regions[i].name);
                option.text(regions[i].name)
                cRegionSelect.append(option);
            }
        },
        error: function(event,xhr,options,exc) {
            console.log('Регионы не найдены');
        }
    });
    form.append(candidateForm);
}

function regionReg() {
    var form = $('#form');
    form.html('');
    form.append(regionForm);
}

function registerVoter() {
    var vFirstName = $('#vFirstName');
    var vLastName = $('#vLastName');
    var vPatronymic = $('#vPatronymic');
    var vPlace = $('#vPlace');
    var vPassportId = $('#vPassportId');
    var vregion = $("#vRegion");
    $.ajax({
        data:'vFirstName=' + vFirstName.val() + '&vLastName=' + vLastName.val() + '&vPatronymic=' + vPatronymic.val() +
            '&vPlace=' + vPlace.val() + '&vPassportId=' + vPassportId.val() + '&vRegion=' + vregion.val(),
        type: 'POST',
        url: '/registerVoter',
        success: function(res) {
            alert(res);
        },
        error: function(event,xhr,options,exc) {
            alert('Вы не заполнили все поля');
        }
    });
}

function registerCandidate() {
    var name = $('#candName');
    var surname = $('#candSur');
    var father = $('#candFather');
    var candReg = $("#candReg");
    $.ajax({
        data: 'cFirstName=' + name.val() + '&cLastName=' + surname.val() + '&cPatronymic=' + father.val() +
        '&cRegion=' + candReg.val(),
        type: 'POST',
        url: '/registerCandidate',
        success: function(res) {
            alert(res);
        },
        error: function(event,xhr,options,exc) {
            alert('Вы не заполнили все поля');
        }
    });
}

function registerRegion() {
    var regionName = $('#regionName');
    $.ajax({
        data:'regionName=' + regionName.val(),
        type: 'POST',
        url: '/registerRegion',
        success: function(res) {
            alert(res);
        },
        error: function(event,xhr,options,exc) {
            alert('Вы не заполнили все поля');
        }
    });
}