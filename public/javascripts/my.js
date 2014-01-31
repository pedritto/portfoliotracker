funding = function(funds) {

    //var content = document.getElementById('fundi');
    //var table = document.createElement('TABLE');

    var table = document.getElementById('funds_table');



    if (!!funds && !!funds.length) {
        for (var i = 0 ; i < funds.length ; i++) {
            var row = document.createElement('TR');

            var link = document.createElement('A');
            var linkText = document.createTextNode(funds[i].name);
            link.appendChild(linkText);
            link.href = funds[i].id;
            var t1 = document.createElement('TD');
            t1.appendChild(link);
            row.appendChild(t1);

            var t2 = document.createElement('TD');
            var quantityText = document.createTextNode(funds[i].code);
            t2.appendChild(quantityText);
            row.appendChild(t2);

            var t3 = document.createElement('TD');
            var valueText = document.createTextNode(funds[i].currency);
            t3.appendChild(valueText);
            row.appendChild(t3);




            table.appendChild(row);
        }
    }
}


loadFunds = function(fill) {
	
    $.ajax({
        url: '/funds',
        success: function(data, textStatus, jqXHR) {
        	fill(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          window.alert(textStatus);
        }
    });
	
}