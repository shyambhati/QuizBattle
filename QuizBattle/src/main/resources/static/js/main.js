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






