/**
 * Created by Jura on 17.05.2015.
 */
function getRegions() {
    var regionList = $('#region-list');
    regionList.html('');
    regionList.append($('<thead><tr><th>#</th><th>Region ID</th><th>Region name</th></tr></thead>'));
    var tBody = $('<tbody></tbody>');
    regionList.append(tBody);
    $.ajax({
        url: '/getRegions',
        dataType: 'json',
        type: 'GET',
        success: function (res) {
            for (var i = 0; i < res.length; i++) {
                tBody.append($('<tr><td><b>' + (i + 1)  + '</b></td><td>' + res[i].regionId + '</td><td>' + res[i].regionName + '</td></tr>'));
            }
        },
        error: function (event, xhr, options, exc) {
            alert(event + ' ' + xhr + ' ' + options + ' ' + exc);
        }
    });
}

function addRegion() {
    var regionName = $('#region-name');
    if(regionName.val().length != 0) {
        $.ajax({
            url: '/addRegion',
            data: 'regionName=' + regionName.val(),
            type: 'GET',
            success: function (res) {
                if(res) {
                    alert('Region added');
                } else {
                    alert('Error');
                }
            },
            error: function (event, xhr, options, exc) {
                alert(event + ' ' + xhr + ' ' + options + ' ' + exc);
            }
        });
    } else {
        alert('atata');
    }
}