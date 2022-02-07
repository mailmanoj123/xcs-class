function includeClicked(number) {
  var ucrText="";
  if ( eval("document.all.item" + number + ".checked") ) {
          eval("document.all.ucrlink" + number + ".style.textDecoration='underline'");
          eval("document.all.ucrlink" + number + ".style.cursor='auto'");
          eval("document.all.ucrlink" + number + ".onclick=function() {}");
  } else {
          eval("document.all.ucrlink" + number + ".style.textDecoration='none'");
          eval("document.all.ucrlink" + number + ".style.cursor='default'");
          eval("document.all.ucrlink" + number + ".onclick=function() {event.returnValue=false;}");
  }
}

function includeAllClicked(rows) {
  for (i=1; i<rows; i++) {
    includeClicked(i);
  }
}