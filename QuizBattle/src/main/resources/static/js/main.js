$(function() { 
  $('#sidebarCollapse').on('click', function() 
  {
    $('#sidebar, #content').toggleClass('active');
    const bar = document.querySelector('.collapce_bar');
   

    if(bar.classList[1]==="fa-bars")
    {
         /*alert(bar.classList[1]); */

         bar.className = 'fa fa-close collapce_bar';
    }
    else
    {
         bar.className = 'fa fa-bars collapce_bar';
    }
  });
});















/*dashbord counter*/
$(document).ready(function(){
    $('.counter-value').each(function(){
        $(this).prop('Counter',0).animate({
            Counter: $(this).text()
        },{
            duration: 3500,
            easing: 'swing',
            step: function (now){
                $(this).text(Math.ceil(now));
            }
        });
    });
});



function myFunction(name,status,id) {
	
//	  alert("I am an alert box! :- "+name+" : "+status);
	  
	  document.getElementById("categoryName").value = ""+name;
	  
	  document.getElementById("categoryId").value = ""+id;

	  if(status==="Yes")
		  document.getElementById("categoryStatus").selectedIndex = "1";
	  else
		  document.getElementById("categoryStatus").selectedIndex = "0";
	
	  $("#editModal").modal()
	}


function editContestFunction(name,time,status,id) {
	

	  document.getElementById("contestName").value = ""+name;
	  
	  document.getElementById("contestId").value = ""+id;
	  
	  document.getElementById("startDateTime1").value = ""+time;

	  if(status==="Yes")
		  document.getElementById("contestStatus").selectedIndex = "1";
	  else
		  document.getElementById("contestStatus").selectedIndex = "0";
	
	  $("#editModal").modal()
}



function myRulesFunction(name,detail,id) {
	
	  document.getElementById("rulename").value = ""+name;
	  
	  document.getElementById("ruleId").value = ""+id;
	  

	  document.getElementById("detail").innerHTML = detail;
	
	  $("#editModal").modal();


	  $('#detail').wysiwyg({
	 	    highlight: true,
	 	    debug: false,
	 	    toolbar: [
	 	        ['operations', ['undo', 'rendo', 'cut', 'copy', 'paste']],
	 	        ['styles'],
	 	        ['fonts', ['select', 'size']],
	 	        ['text', ['bold', 'italic', 'underline', 'strike', 'subscript', 'superscript', 'font-color', 'bg-color']],
	 	        ['align', ['left', 'center', 'right', 'justify']],
	 	        ['lists', ['unordered', 'ordered']],
	 	        ['components', ['table', /*'chart'*/]],
	 	        ['intervals', ['line-height', 'letter-spacing']],
	 	        ['insert', ['emoji', 'symbol', /*'bookmark'*/]],
	 	        ['special', ['unformat', 'visual', 'clean']],
	 	        /*['fullscreen'],*/
	 	      ],
	 		});
}










/*lock timing*/
//Set timeout variables.
var timoutWarning = 1080000; // Display warning in 14 Mins.
var timoutNow = 1200000; // Timeout in 15 mins.
var logoutUrl = 'http://localhost:1991/'; // URL to logout page.

var warningTimer;
var timeoutTimer;

// Start timers.
function StartTimers() {
    warningTimer = setTimeout("IdleWarning()", timoutWarning);
    timeoutTimer = setTimeout("IdleTimeout()", timoutNow);
}

// Reset timers.
function ResetTimers() {
    clearTimeout(warningTimer);
    clearTimeout(timeoutTimer);
    StartTimers();
    $('#timeoutModel').modal('hide');
}

// Show idle timeout warning dialog.
function IdleWarning() {
    $("#timeoutModel").modal();
}

// Logout the user.
function IdleTimeout() {
    window.location = logoutUrl;
}



/*$('.content').richText({
	  bold: true,
	  italic: true,
	  underline: true,
	  imageUpload:false,
	  fileUpload:false,
	  Embed:false,
	  urls:false,
	  code:false,
	  height: 120
});
*/





////////////////////

	
google.load("elements", "1", {
    packages: "transliteration"
  });
function onLoad() {
var options = {
    sourceLanguage:
        google.elements.transliteration.LanguageCode.ENGLISH,
    destinationLanguage:
        google.elements.transliteration.LanguageCode.HINDI,
    shortcutKey: 'ctrl+g',
    transliterationEnabled: true
};
var control =
    new google.elements.transliteration.TransliterationControl(options);
control.makeTransliteratable(['hindiTyped']);
 
}
google.setOnLoadCallback(onLoad);





