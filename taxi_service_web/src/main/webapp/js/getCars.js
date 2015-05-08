/**
 * Created by Wolf on 27.04.2015.
 */
$(function(){
    $('#cars').keyup(function(){
        document.getElementById('carlist').innerHTML = ' ';
        var adresID = document.getElementById('street').value;
        var carType = document.getElementById('cars').value;
        console.log('adresID='+carType);
        console.log('carType='+carType);
        if(carType.length>=2){
            $.ajax({
                type: "GET",
                url: "/getcarlist.html",
                data: "addresID="+adresID+"&carType="+carType,
                success: function(result){
                    console.log(result);
                    var carSelect = '';
                    var carElem = result.split(',');
                    for(var i = 0; i < carElem.length-1; i++){
                        var currentCar = carElem[i].split('|');
                        console.log('<span onclick="setCar('+currentCar[0]+')">'+currentCar[1]+'</span>');
                        carSelect+='<span onclick="setCar('+currentCar[0]+',\''+currentCar[1]+'\')">'+currentCar[1]+'</span>';
                    }
                    document.getElementById('carlist').innerHTML = carSelect;
                }
            });
        }
        return false;
    });
});