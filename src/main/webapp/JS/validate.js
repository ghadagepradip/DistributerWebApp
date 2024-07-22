/**
 * 
 */
function validatevendor()
{
	var vendorname=document.getElementById("txtvend").value;
	let regexp=/^[a-zA-Z]+$/
	let result=regexp.test(vendorname);
	if(result==false)
	{
		let span=document.getElementById("s");
		span.innerHTML="Invalid Vendor Name";
		let button=document.getElementById("btn");
		button.disabled=true;
		return false;
	}
	else
	{
		let span=document.getElementById("s");
		span.innerHTML="";
		let button=document.getElementById("btn");
		button.disabled=false;
		return true;
	}
}