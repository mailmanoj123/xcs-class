// JavaScript Document called from body onload - arguments should be a list of tables to be striped by id
var rowCol = "#9DD7EB" // specifies the row color.

function altColumnRows(table,freq){
  var tableObj = document.all[table]
  var m = (tableObj.rows.length-1) / freq;
  for(j=0; j<m; j++){
    for (i=0; i<freq; i++)
      if(j%2){tableObj.rows[j*freq+i+1].style.backgroundColor = rowCol}
  }
}
