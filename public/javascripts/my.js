initFunds = function() {
	loadFunds('/funds', fillFunds);
}

loadFunds = function(uri, callback) {
	
    $.ajax({
        url: uri,
        success: function(data, textStatus, jqXHR) {
        	callback(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          window.alert(textStatus);
        }
    });
	
}

fillFunds = function(fundList) {
	var content = document.getElementById('fundList');
	if (!fundList || !content) {
		return;
	}
	
	for (i = 0; i < fundList.length; i++) {
		var fundElement = createFundItem(fundList[i]);
		content.appendChild(fundElement);
	}
}

createFundItem = function(fundData) {
	
	var fundElement = document.createElement('DIV');
	
	var percent = 100;
	
	createSpan(fundElement, fundData.name);
	createSpan(fundElement, fundData.investor);
	createSpan(fundElement, fundData.buyIn);
	createSpan(fundElement, fundData.fee * percent, '%');
	createSpan(fundElement, fundData.value);
	createSpan(fundElement, fundData.currency);
	createSpan(fundElement, fundData.rate * percent, '%');
	createSpan(fundElement, fundData.netRate * percent, '%');
	
	return fundElement;
}

createSpan = function (parent, data, postfix) {
	if (!postfix) {
		postfix = '';
	}
	var element = document.createElement('SPAN');
	element.innerHTML = data + postfix;
	parent.appendChild(element);
}

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