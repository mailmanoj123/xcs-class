//*****************************************************
//Round off values to required precision and
//call comma formatting if required
//STH 29/12/2003
//*****************************************************
function roundOff(value,precision,CommaFormat){

value = " " + value;
precision = parseInt(precision);

var whole = " " + Math.round(value * Math.pow(10, precision));

//If the passed value is zero then return blank string
//as per formatting request but only if precision is to 2dp - Otherwise return 0.00.
if (whole == 0) {
  if (precision == 2) {
    result = "";
  }
  else {
    result = "0.0000"
  }
  return result;
}
var decPoint = whole.length - precision;

if(decPoint != 0)
{
  //Check if comma formatting is required
  //and allow for -ve sign on number
  if (CommaFormat == 'y'){
    if (whole.substring(2,1) == '-'){
      result = '-' + InsertCommas(whole.substring(2, decPoint));
      }
    else {
      result = InsertCommas(whole.substring(1, decPoint));
      }
  }
  else{
    result = whole.substring(1, decPoint);
    }
  result += ".";
  result += whole.substring(decPoint, whole.length);
  }
else
{
  result = ".0" + whole.substring(1);
  }

  return result;
}
//************************************************************
//Function to insert commas into a number for formatting
//STH 29/12/2003
//************************************************************
function InsertCommas(IntegerNo) {
IntegerNo = '' + IntegerNo;
var IntegerLen = IntegerNo.length;

if (IntegerLen > 3) {
  var mod = IntegerLen % 3;
  var output = (mod > 0 ? (IntegerNo.substring(0,mod)) : '');

  for (i=0 ; i < Math.floor(IntegerLen / 3); i++) {
    if ((mod == 0) && (i == 0))
      output += IntegerNo.substring(mod+ 3 * i, mod + 3 * i + 3);
    else
      output+= ',' + IntegerNo.substring(mod + 3 * i, mod + 3 * i + 3);
    }
    return (output);
}
else return IntegerNo;
}