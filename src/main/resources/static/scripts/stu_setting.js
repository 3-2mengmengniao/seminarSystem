var $ = jQuery.noConflict(); 
var formSubmitted = 'false';

jQuery(document).ready(function($) {	

	$('#formSuccessMessageWrap').hide(0);
	$('.formValidationError').fadeOut(0);
	
	// fields focus function starts
	$('input[type="text"], input[type="password"], textarea').focus(function(){
		if($(this).val() == $(this).attr('data-dummy')){
			$(this).val('');
		};	
	});
	// fields focus function ends
		
	// fields blur function starts
	$('input, textarea').blur(function(){
    	if($(this).val() == ''){		    
			$(this).val($(this).attr('data-dummy'));				
		};			
	});
	// fields blur function ends
		
	// submit form data starts	   
    function submitData(currentForm, formType) {
        formSubmitted = 'true';
        var formInput = $('#' + currentForm).serialize();
        $.ajax(
            {
                url:$('#' + currentForm).attr('action'),
                type:'post',
                data:formInput,
                success:function(data,status,response){
                    if(response.status=="200"){
                        var info=response.responseText;
                        window.location.href="/student/setting";
                    }
                },
                error:function(data,status){
                    console.log(data);
                    console.log(status);
                    $('#formSuccessMessageWrap').fadeIn(500);
                    formSubmitted = 'false';
                    var onFocus = document.activeElement;
                    if (onFocus.id === "contactEmailField") {
                        $('#formSuccessMessageWrap').fadeOut(500);
                    }
                    console.log("error");
                }
            }
        );
            // $.post($('#' + currentForm).attr('action'),formInput, function(data,status){
            //     if(data=="404") {
            //         $('#formSuccessMessageWrap').fadeIn(500);
            //         formSubmitted = 'false';
            //         var onFocus = document.activeElement;
            //         if (onFocus.id === "contactEmailField") {
            //             $('#formSuccessMessageWrap').fadeOut(500);
            //         }
            //     }
            //     else if(data=="200")
            //         window.location.href="/teacher/setting";
            //     else if(data=="204")
            //         window.location.href="/student/setting";
            // });
            //window.location.href='1vali_psw.html';
        };
	// submit form data function starts	
	// validate form function starts
    function validateForm(currentForm, formType){
        // hide any error messages starts
        $('.formValidationError').hide();
        $('.fieldHasError').removeClass('fieldHasError');
        // hide any error messages ends
        $('#' + currentForm + ' .requiredField').each(function(i){
            if($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')){
                $(this).val($(this).attr('data-dummy'));
                $(this).focus();
                $(this).addClass('fieldHasError');
                $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                return false;
            };
            if($(this).hasClass('requiredEmailField')){
                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                var tempField = '#' + $(this).attr('id');
                if(!emailReg.test($(tempField).val())) {
                    $(tempField).focus();
                    $(tempField).addClass('fieldHasError');
                    $(tempField + 'Error2').fadeIn(300);
                    return false;
                };
            };

            if(formSubmitted == 'false' && i == $('#' + currentForm + ' .requiredField').length - 1){
                submitData(currentForm, formType);
            };

        });

    };
	// validate form function ends	
	
	// contact button function starts
	$('#contactSubmitButton').click(function() {	
		var flag2=validateForm($(this).attr('data-formId'));	
	    return false;		
	});
	// contact button function ends
	
	
	
});
/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*//////////////////// Document Ready Function Ends                                                                       */
/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
