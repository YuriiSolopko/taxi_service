/**
 * Created by Jura on 09.04.2015.
 */

function registerClient() {
    window.location = "/registerClient.html";
}

function createOrder() {
    window.location = "/order.html";
}

function showGtSum() {
    var sum = document.getElementById('totalSum').value;
    window.location = "/dashboard.html/showGtSum?clientSum=" + sum;
}

function showLastMonth() {
    window.location = "/dashboard.html/showLastMonth";
}

function showAll() {
    window.location = "/dashboard.html/showAll?firstResult=0";
    /*
    var divTable = document.getElementById('table');
    divTable.innerHTML = '';
    var table = document.createElement('TABLE');
    var row;
    var col;
    var txt;
    for (var i = 0; i < 5; i++) {
        row = document.createElement('TR');
        for (var j = 0; j < 6; j++) {
            col = document.createElement('TD');
            if (j%2 == 0) {
                col.setAttribute("class", 'first');
            }
            txt = document.createTextNode(j);
            col.appendChild(txt);
            row.appendChild(col);
        }
        table.appendChild(row);
    }
    divTable.appendChild(table);
    */
}

