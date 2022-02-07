// JavaScript Document
function showTab(tabNum) {
  var i=1;
  while (eval("document.all.tab" + i)!=null) {
    eval("document.all.tab" + i + ".style.display='none';");
    i++;
  }
  eval("document.all.tab" + tabNum + ".style.display='';");
  
}