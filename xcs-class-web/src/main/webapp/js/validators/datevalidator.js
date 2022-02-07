// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  CLASS MaskDetails
// ~
// ~  functions included:
// ~    single constructor:
// ~
// ~  This has the simple task of holding the breakdown of the datemask details.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  MaskDetails Constructor.MaskDetails ([string],[string],[string])
// ~
// ~  Simply assigns the passed values.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function MaskDetails(charGrouping, startString, endString)
{
  var sFunctionName= "MaskDetails Constructor";
  debugMessage("Entering " + sFunctionName,1) ;

  try {
		this.charGrouping = charGrouping;
		this.startString  = startString;
		this.endString    = endString;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }

  debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  CLASS MaskArray
// ~
// ~  functions included:
// ~    single constructor:
// ~    add
// ~    rtnArray
// ~    breakDownMask
// ~
// ~  This class has the task of breaking down the mask into its constituent parts
// ~  and also noting where in the date mask string each part exists.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  MaskArray Constructor.DateCheck ()
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function MaskArray()
{
  var sFunctionName= "MaskArray Constructor";
  debugMessage("Entering " + sFunctionName,1) ;

	try {
		this.iNextEmptyIndex = 0;
		this.aMaskArray = new Array();
	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}

  debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  MaskArray.add ([MaskDetails object])
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
MaskArray.prototype.add = function(uoMaskObject)
{
	this.aMaskArray[this.iNextEmptyIndex] = uoMaskObject;
	this.iNextEmptyIndex++;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  MaskArray.rtnArray ([MaskDetails object]) rtn [MaskDetails[] ]
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
MaskArray.prototype.rtnArray = function()
{
	return this.aMaskArray
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  MaskArray.breakDownMask ([string])
// ~
// ~  This  function will split the mask down and store it into the aMaskArray.
// ~  It will break the mask into its constituent parts noting down also the exact position
// ~  that they occupy in the mask string. This will be used as the central key to
// ~  check that any future date will adhere to the passed in mask.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
MaskArray.prototype.breakDownMask = function(mask)
{
  var sFunctionName= "MaskArray breakDownMask";
  debugMessage("Entering " + sFunctionName,1) ;

  try{
		for (x=0; x < mask.length; x++)
		{
			switch (true)
			{
				case (mask.substring(x,x+4) == "ccyy"):
					this.add(new MaskDetails("ccyy", x, x+4));
					x=x+3;
					break;
				case (mask.substring(x,x+2) == "yy"):
					this.add(new MaskDetails("yy", x, x+2));
					x=x+1;
					break;
				case (mask.substring(x,x+2) == "mm"):
					this.add(new MaskDetails("mm", x, x+2));
					x=x+1;
					break;
				case (mask.substring(x,x+2) == "dd"):
					this.add(new MaskDetails("dd", x, x+2));
					x=x+1;
					break;
				default:
					this.add(new MaskDetails(mask.substring(x,x+1), x, x+1));
			}
		}
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }

  debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  CLASS DateValidator
// ~
// ~  "Public" functions are listed as:
// ~
// ~    single constructor:
// ~    compare
// ~    isValid
// ~    getHelpText
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  DateValidator Constructor.DateValidator ([string],[string])
// ~
// ~  Takes in an date mask which will be used to validate whether or not the
// ~  date passed in (within the isValid routine) is indeed valid.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function DateValidator(sMask)
{
  var sFunctionName= "DateValidator Constructor";
  debugMessage("Entering " + sFunctionName, 1) ;

  try {
		this.sDate    = "";

		// Create arrays to hold all the mask details
		this.sMask				= new Array() ;
		this.uoMaskArray 	= new Array();
		this.uoMask 			= new Array();

		// Count of the number of masks defined
		this.iMaskCount = 0 ;

		// The mask which matched a date, as a string and the index of it in the mask array
		this.sMaskMatched = "" ;
		this.iMaskMatched = -1 ;

		this.intDay   = 0;
		this.intMonth = 0;
		this.intYear  = 0;

		this.addMask(sMask) ;

		// This variable(object) will be used to hold all the error messages.
		this.Errors = new MessageList();

  } catch(e) {
    e.description += "\n" + sFunctionName + "(sMask=" + sMask + ")" ;
    throw e ;
  }
  debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  DateValidator.addMask ([String object])
// ~
// ~  Add an additional mask to a date validator.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.addMask = function(sMask)
{
  var sFunctionName= "DateValidator.addMask";
  debugMessage("Entering " + sFunctionName, 1) ;

	try{
      this.sMask[this.iMaskCount] = sMask;

      this.uoMaskArray[this.iMaskCount] = new MaskArray();
      // Now breakdown the mask
      this.uoMaskArray[this.iMaskCount].breakDownMask(this.sMask[this.iMaskCount]);

      // Although we can get a handle to the array within the uoMaskArray object
      // it is a little easier to place the array in this object uoMask.
			this.uoMask[this.iMaskCount] = new Array() ;

			// Increment the number of masks defined
			this.iMaskCount++ ;

	} catch(e) {
		e.description += "\n" + sFunctionName + "(sMask=" + sMask + ")" ;
		throw e ;
	}
	debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  DateValidator.getHelpText ([String object])
// ~
// ~  This will simply return the help text assigned within this function. The help text
// ~  is hard coded.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.getHelpText = function()
{
	var sFunctionName= "DateValidator.getHelpText";
  debugMessage("Entering " + sFunctionName, 1) ;

	try {
		if (this.iMaskCount==1) {
			var sHelp = "The date must be in the following format: " +  this.sMask[0] + "." ;
		} else {
			var sHelp = "The date must be in one of the following formats: " ;
			for (var i=0; i<this.iMaskCount; i++) {
				sHelp += (i==0)?"":", ";
				sHelp += this.sMask[i] ;
			}
			sHelp += ".<br>" ;
		}
		return sHelp;
	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
	debugMessage("Leaving " + sFunctionName,-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  DateValidator.compare ([String object]) rtn Number
// ~
// ~  return values are as follows:
// ~    -1  means that the value being passed in is greater than the instance value
// ~     0  means that both values are the same
// ~     1  means that the value being passed in is less than the instance value
// ~
// ~  To compare dates we need to put them in the following format:  ccyymmdd
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.compare = function(passedParam) {
	var sFunctionName= "DateValidator.compare";
	debugMessage("Entering " + sFunctionName + "(passedParam=" + passedParam + ")", 1) ;

	try	{
		var firstDate;
		var secondDate;

		// Get the first date
		firstDate = this.getDateSegment() ;
		debugMessage("firstDate: " + firstDate) ;

		// This will tell us the type of the parameter passed in.
		constructorSwitch: switch (passedParam.constructor)
		{
			case DateValidator:
				if (this.sMaskMatched != passedParam.sMaskMatched) {
					eWarning = new ErrorObject("A date of type "+ this.sMaskMatched + " cannot be compared to a date of type " + passedParam.sMaskMatched) ;
					eWarning.bSevereError = false ;
					throw eWarning ;
				}
				secondDate= passedParam.getDateSegment() ;
				break constructorSwitch ;
			case String:
				if (passedParam == "today") {
					var aa = new Date();
					secondDate = ("" + aa.getYear() + ((aa.getMonth() + 1) < "10" ? "0" + (aa.getMonth() + 1) : (aa.getMonth() + 1))  + (aa.getDate() < "10" ? "0" + aa.getDate() : aa.getDate()));
				} else {
					secondDate =  passedParam;
				}
				break constructorSwitch ;
			default :
				debugMessage("An invalid parameter was passed to the DateValidator.compare function");
				throw new ErrorObject("An invalid parameter was passed to the DateValidator.compare function");
		}
		debugMessage(" passedParam into compare = " + passedParam + "firstDate = " + firstDate + " secondDate = " + secondDate);

		// Now having derived both the dates we do a simple compare of the two values.
		var bReturnValue = 0 ;
		if (firstDate < secondDate) bReturnValue= -1;
		if (firstDate == secondDate) bReturnValue= 0;
		if (firstDate > secondDate) bReturnValue= 1;

	} catch(e) {
		if (e.bSevereError) {
			e.description += "\n" + sFunctionName ;
		}
		throw e ;
	}
	debugMessage("Leaving " + sFunctionName + ", returning: " + bReturnValue, -1) ;
	return bReturnValue;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  CLASS DateValidator.getDateSegment () rtn [Number object]
// ~
// ~  This is used soley by the DateValidator.compare function and will return a
// ~  date defined as a DateValidator into the following format  ccyymmdd.
// ~  This will then enable us to compare two dates.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.getDateSegment = function()
{
	var sFunctionName= "DateValidator.getDateSegment";
	debugMessage("Entering DateValidator.getDateSegment",1) ;

	try{
		var DateBreakdown = new Array("ccyy","yy","mm","dd");
		var fullnumber = "";

		if (this.iMaskMatched == -1) throw new ErrorObject("Date does not match any mask.") ;

		for (var w=0; w < DateBreakdown.length; w++)
		{
			for (var z=0; z< this.uoMask[this.iMaskMatched].length; z++)
			{
				if (this.uoMask[this.iMaskMatched][z].charGrouping == DateBreakdown[w])
				{
					debugMessage(DateBreakdown[w] + " ooo " + this.uoMask[this.iMaskMatched][z].charGrouping);
					fullnumber += this.sDate.substring(this.uoMask[this.iMaskMatched][z].startString, this.uoMask[this.iMaskMatched][z].endString);
					z = this.uoMask[this.iMaskMatched].length;
				}
			}
		}

	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
	debugMessage("Leaving " + sFunctionName + ", returning: " + fullnumber, -1) ;
	return fullnumber;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  DateValidator.isValid ([String object]) rtn [boolean]
// ~
// ~  This will check that the string passed in (which will be the date that the user
// ~  has typed in) is valid. If the date passed in is invalid a false boolean will
// ~  be returned.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.isValid = function(sFields)
{
	var sFunctionName= "DateValidator.isValid";
	debugMessage("Entering " + sFunctionName, 1) ;

	try	{
		// This is the value which needs to be validated against the mask passed into the constructor.

                if (sFields[0]!=null) {
                  if ((sFields.length==3) && (sFields[0].uoUIObject.value!="") && (sFields[1].uoUIObject.value=="") && (sFields[2].uoUIObject.value!="")) {
                    this.Errors.add("Date format not valid.");
                    return false;
                  }

                  this.sDate = "";

                  for(var x=0; x < sFields.length; x++)
                  {
                    this.sDate += sFields[x].uoUIObject.value ;
                  }
                } else
                  this.sDate = sFields;

		var bMatchFound = false ;
		var i = 0 ;
		this.sMaskMatched = "" ;

		while ((i<this.iMaskCount) && (!bMatchFound)) {
			// These values are re-initialised here
			this.intDay = 0;
			this.intMonth = 0;
			this.intYear = 0;
			this.Errors.clear();
			this.iNextEmptyIndex = 0;
			this.iMaskMatched = i ;
			var rtnBoolean = true;

			if (this.sDate.length == this.sMask[i].length) {
				// Get the broken down mask- which is in an array
				this.uoMask[i] = this.uoMaskArray[i].rtnArray();

				for (xx=0; xx < this.uoMask[i].length; xx++) {
					switch ((this.uoMask[i][xx]).charGrouping) {
						case ("dd"):
							if (!this.IsValidDay(this.sDate.substring(this.uoMask[i][xx].startString, this.uoMask[i][xx].endString), this.uoMask[i][xx].charGrouping)) {
								rtnBoolean = false;
								xx = this.uoMask[i].length;
							}
							break;
						case ("mm"):
							if (this.intMonth==0) {
								if (!this.IsValidMonth(this.sDate.substring(this.uoMask[i][xx].startString, this.uoMask[i][xx].endString), this.uoMask[i][xx].charGrouping)) {
									rtnBoolean = false;
									xx = this.uoMask[i].length;
								}
							}
							break;
						case ("yy"):
							if (this.intYear==0) {
								if (!this.IsValidYear(this.sDate.substring(this.uoMask[i][xx].startString, this.uoMask[i][xx].endString), this.uoMask[i][xx].charGrouping)) {
									rtnBoolean = false;
									xx = this.uoMask[i].length;
								}
							}
							break;
						case ("ccyy"):
							if (this.intYear==0) {
								if (!this.IsValidYear(this.sDate.substring(this.uoMask[i][xx].startString, this.uoMask[i][xx].endString), this.uoMask[i][xx].charGrouping)) {
									rtnBoolean = false;
									xx = this.uoMask[i].length;
								}
							}
							break;
						default:
							if (this.sDate.substring(this.uoMask[i][xx].startString, this.uoMask[i][xx].endString) != (this.uoMask[i][xx]).charGrouping) {
								rtnBoolean = false;
								xx = this.uoMask[i].length;
							}

					}  // end switch
				} // end for loop (mask segment array iterator)
			} else {
				rtnBoolean = false;
			}
			// If the date is valid, then make a note of which mask the date matched,
			// and do not attempt to match any more masks.
			if (rtnBoolean==true) {
				this.sMaskMatched = this.sMask[i] ;
				bMatchFound = true ;
			} else {
			  i++ ;
			}
		} // end while loop (all input masks)

		// Before we throw this back to the callee we need to populate the error object with a message
		// if, for some reason, the date is incorrect.
		if (rtnBoolean == false) {
			this.iMaskMatched = -1 ;
			this.Errors.add(this.getHelpText()) ;
		}

	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}

	debugMessage("Leaving " + sFunctionName + ", returning" + rtnBoolean,-1) ;
	return rtnBoolean;
}


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.IsValidYear ([Number object, String object]) rtn [boolean]
// ~
// ~   This function will be called from the isValid or the ChkDay function (although
// ~   one should note that it cannot be called from both in a single sweep through a date.
// ~   The mask passed in here will either be ccyy or yy.
// ~
// ~   If ccyy is passed in then we can check the following
// ~        1) That the number is numeric
// ~        2) That the year falls between 1700 and 2100
// ~
// ~    If only "yy" is passed in then we just check that it is numeric.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.IsValidYear = function(Year, Mask)
{

  debugMessage("Entering DateValidator.IsValidYear",1) ;
  var sFunctionName= "DateValidator.IsValidYear";

   try{
            var rtnBoolean = true;
            var numbercheck;
            maskSwitch: switch (Mask) {
            case ("yy"):
              if (!isNaN(Year)) {
                this.intYear = parseInt(Year, 10);
              } else {
                rtnBoolean = false;
                this.intYear = 0;
              }
              break maskSwitch;
            case ("ccyy"):
              if (!isNaN(Year)) {
                this.intYear = parseInt(Year, 10);

                if ((this.intYear < 1700) || (this.intYear > 2050)) {
                  rtnBoolean = false;
                  this.intYear = 0;
                }
              } else {
                rtnBoolean = false;
                this.intYear = 0;
              }
              break maskSwitch;
            default:
              e.description += "\n" + sFunctionName + " - incorrect year mask ";
              throw new ErrorObject("An invalid mask was passed into the DateValidator.IsValidYear function");
              rtnBoolean = false;
              this.intYear = 0;
            }
    } catch(e) {
        e.description += "\n" + sFunctionName ;
        throw e ;
    }

  debugMessage("Leaving DateValidator.IsValidYear",-1) ;
  return  rtnBoolean;
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.IsValidMonth ([Number object, String object]) rtn [boolean]
// ~
// ~   This function will be called from the isValid or the ChkDay function (although
// ~   one should note that it cannot be called from both in a single sweep through a date.
// ~   The mask passed in here will be mm.
// ~
// ~   If mm is passed in then we can check the following
// ~        1) That the number is numeric
// ~        2) That the month falls is between 1 and 12 (as one would expect)
// ~
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.IsValidMonth = function(Month, Mask)
{
   debugMessage("Entering DateValidator.IsValidMonth",1) ;
   var sFunctionName= "DateValidator.IsValidMonth";

   try{
            var rtnBoolean = true;
            var numbercheck;
            maskSwitch: switch (Mask)
            {
            case ("mm"):
              if (!isNaN(Month))
              {
                this.intMonth = parseInt(Month, 10);

                if (this.intMonth>12 || this.intMonth<1)
                {
                  rtnBoolean = false;
                  this.intMonth = 0;
                }
              }
              else
              {
                rtnBoolean = false;
                this.intMonth = 0;
              }
              break maskSwitch;
            default:
              // e.description += "\n" + sFunctionName + " - incorrect month mask ";
              throw new ErrorObject("An invalid mask was passed into the DateValidator.IsValidMonth function");
              this.intMonth = 0;
              rtnBoolean = false;
            }

    } catch(e) {
        e.description += "\n" + sFunctionName ;
        throw e ;
    }

  debugMessage("Leaving DateValidator.IsValidMonth",-1) ;
  return  rtnBoolean;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.IsValidDay ([Number object, String object]) rtn [boolean]
// ~
// ~   This function will be called from the isValid function only.
// ~   The mask passed in here will be dd.
// ~
// ~   If dd is passed in then we can check the following
// ~        1) That the number is numeric
// ~   ....further checks are then carried out in the ChkDay function called from this function.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.IsValidDay = function(Day, Mask)
{
  debugMessage("Entering DateValidator.IsValidDay",1) ;
  var sFunctionName= "DateValidator.IsValidDay";

  try{
            var rtnBoolean = true;
            var numbercheck;

            maskSwitch: switch (Mask)
            {
            case ("dd"):
              if (!isNaN(Day))
              {
                this.intDay = parseInt(Day, 10);
                rtnBoolean = this.ChkDay(Day);
              }
              else
              {
                rtnBoolean = false;
                this.intDay = 0;
              }

              break maskSwitch;
            default:
              e.description += "\n" + sFunctionName + " - incorrect day mask ";
              throw new ErrorObject("An invalid mask was passed into the DateValidator.IsValidDay function");
              rtnBoolean = false;
            }

    } catch(e) {
        e.description += "\n" + sFunctionName ;
        // add parameters to the description if you feel it helps.
        // newlines (\n) at the beginning of lines.
        throw e ;
    }

  debugMessage("Leaving DateValidator.IsValidDay",-1) ;

  return  rtnBoolean;
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.IsLeapYear () rtn [boolean]
// ~
// ~   For the year passed in we will determine whether it is a leap year or not.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.IsLeapYear = function ()
{
  debugMessage("Entering DateValidator.IsLeapYear",1) ;
  var sFunctionName= "DateValidator.IsLeapYear";

  try{
          if (this.intYear % 100 == 0)
          {
            if (this.intYear % 400 == 0) { return true; }
          }
          else
          {
            if ((this.intYear % 4) == 0) { return true; }
          }



    } catch(e) {
        e.description += "\n" + sFunctionName ;
        // add parameters to the description if you feel it helps.
        // newlines (\n) at the beginning of lines.
        throw e ;
    }

  debugMessage("Leaving DateValidator.IsLeapYear",-1) ;
  return false;
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.ChkDay () rtn [boolean]
// ~
// ~   For the day passed in this function will check the following
// ~        1) That the number of days tallies with the month selected.
// ~        2) Check whether it is a leap year for dates in February.
// ~
// ~   Note: If the month and the year have not been checked then they will be checked
// ~         here. The month and year are required to validate the day.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.ChkDay = function(Day)
{
  debugMessage("Entering DateValidator.ChkDay",1) ;
  var sFunctionName= "DateValidator.ChkDay";

  try{
          var rtnBoolean = true;
          // ~ first we need to get the month and year parts from the date value.
          // ~ If these do not exist then simply return true as there is nothing
          // ~ that we can check.

          if ((this.intMonth == 0) || (this.intYear == 0))
          {
            this.GetMonthYear();
          }

          if ((this.intYear ==0)  || (this.intMonth ==0))
          {
            // If we cannot determine what the month or year is then
            // we cannot check the day element of the date anymore.
            rtnBoolean = true;
          }
          else
          {

            monthLengthSwitch: switch (true)
            {
            case ((this.intMonth == 1 || this.intMonth == 3 || this.intMonth == 5 || this.intMonth == 7 || this.intMonth == 8 || this.intMonth == 10 || this.intMonth == 12) && (this.intDay > 31 || this.intDay < 1)):
              // Now ensure that the day number falls within the correct number of days for that month

              rtnBoolean = false;
              break monthLengthSwitch ;
            case ((this.intMonth == 4 || this.intMonth == 6 || this.intMonth == 9 || this.intMonth == 11) && (this.intDay > 30 || this.intDay < 1)):
              // Now ensure that the day number falls within the correct number of days for that month
              rtnBoolean = false;
              break monthLengthSwitch;
            case (this.intMonth == 2):
              if (this.intday < 1) ;

              if (this.IsLeapYear() == true)
              {
                if (this.intDay > 29)
                {
                  rtnBoolean = false;
                }
              }
              else
              {
                if (this.intDay > 28)
                {
                  rtnBoolean = false;
                }
              }
              break monthLengthSwitch;
            }
          }


    } catch(e) {
        e.description += "\n" + sFunctionName ;
        throw e ;
    }

  debugMessage("Leaving DateValidator.ChkDay",-1) ;

  return rtnBoolean;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS DateValidator.GetMonthYear () rtn [boolean]
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DateValidator.prototype.GetMonthYear = function()
{
  var sFunctionName= "DateValidator.GetMonthYear";
	debugMessage("Entering " + sFunctionName, 1) ;

  try {
		//	Get the mask that matched this date
		var itmi = this.iMaskMatched ;

        var rtnBoolean = true;

        for (z=0; z < this.uoMask[itmi].length; z++)
        {
          switch ((this.uoMask[itmi][z]).charGrouping)
          {
          case ("mm"):

            var strMonth = this.sDate.substring(this.uoMask[itmi][z].startString, this.uoMask[itmi][z].endString);
            rtnBoolean = this.IsValidMonth(strMonth, this.uoMask[itmi][z].charGrouping, "mm");
            break;

          case ("yy"):
            var strYear = this.sDate.substring(this.uoMask[itmi][z].startString, this.uoMask[itmi][z].endString);
            rtnBoolean = this.IsValidYear(strYear, this.uoMask[itmi][z].charGrouping, "yy");
            break;
          case ("ccyy"):
            var strYear = this.sDate.substring(this.uoMask[itmi][z].startString, this.uoMask[itmi][z].endString);
            rtnBoolean = this.IsValidYear(strYear, this.uoMask[itmi][z].charGrouping, "ccyy");
            break;
          }
        }

    } catch(e) {
        e.description += "\n" + sFunctionName ;
        // add parameters to the description if you feel it helps.
        // newlines (\n) at the beginning of lines.
        throw e ;
    }

	debugMessage("Leaving " + sFunctionName + ", returning" + rtnBoolean,-1) ;
  return rtnBoolean;
}