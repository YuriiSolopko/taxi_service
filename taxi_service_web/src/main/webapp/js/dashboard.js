/**
 * Created by Jura on 17.05.2015.
 */
function getRegions() {
    var regionList = $('#region-list');
    regionList.html('');
    regionList.append($('<thead><tr><th>#</th><th>Region ID</th><th>Region name</th><th></th></tr></thead>'));
    var tBody = $('<tbody></tbody>');
    regionList.append(tBody);
    $.ajax({
        url: '/getRegions',
        dataType: 'json',
        type: 'GET',
        success: function (res) {
            var btnGroup = '<div class="btn-group">' +
            '<button type="button" class="btn btn-warning edit-region"><i class="fa fa-edit"></i></button>' +
            '<button type="button" class="btn btn-danger delete-region" data-toggle="modal" data-target="#region-delete"><i class="fa fa-close"></i></button></div>';
            for (var i = 0; i < res.length; i++) {
                tBody.append($('<tr><td><b>' + (i + 1)  + '</b></td><td>' + res[i].regionId + '</td>' +
                '<td>' + res[i].regionName + '</td><td>' + btnGroup + '</td></tr>'));
            }
            $('.edit-region').click(function(){
                var row =  $(this).closest('tr');
                var column = row.children().eq(2);
                var button = row.children().eq(3);
                button.html('<button class="btn btn-default done-edit-region">Done</button>');
                $('.edit-region').attr('disabled', true);
                var oldRegName = column.text();
                column.html('<input type="text" class="form-control" value="' + oldRegName + '">');
                $('.done-edit-region').click(function() {
                    var tr = $(this).closest('tr');
                    var regionName = tr.children().eq(2).children().eq(0).val();
                    if (oldRegName != regionName) {
                        var regionId = tr.children().eq(1).text();
                        $.ajax({
                            url: '/editRegion',
                            type: 'GET',
                            data: 'regionName=' + regionName + '&regionId=' + regionId,
                            success: function(res) {
                                getRegions();
                            }
                        });
                    } else {
                        getRegions();
                    }
                });
            });
            $('.delete-region').click(function(){
                var row =  $(this).closest('tr').children().eq(2).text();
                var modal = $('#region-delete-body');
                modal.append($('<p>' + row + '</p>'));
            })
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
                regionName.val('');
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
        alert('Region name should not be empty');
    }
}