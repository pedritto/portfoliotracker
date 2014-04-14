loadStatic = function() {
	var elements = ['#menu'];
	//var playFiles = ['stylesheets/MenuItems.html'];
	var staticFiles = ['includes/menuItems.html'];	
	
	var files = staticFiles;
	
	
	for(var i = 0; i < elements.length; i++) {
		$(elements[i]).load(files[i]);
	}
    alert('loading...');
}