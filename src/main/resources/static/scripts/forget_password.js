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
    function submitData(currentForm, formType){
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
                        window.location.href="/login";
                    }
                },
                error:function(data,status){
                    console.log(data);
                    console.log(status);
                    $('#formSuccessMessageWrap').fadeIn(500);
                    formSubmitted = 'false';
                }
            }
        );

    //     $.post($('#' + currentForm).attr('action'),formInput, function(data,status){
    //         if(data=="404") {
    //             $('#formSuccessMessageWrap').fadeIn(500);
    //             formSubmitted = 'false';
    //             var onFocus = document.activeElement;
    //             if (onFocus.id === "contactEmailField") {
    //                 $('#formSuccessMessageWrap').fadeOut(500);
    //             }
    //         }
    //         else if(data=="200"||data=="204")
    //             window.location.href="/modifyPassword";
    //     });
     };
    // submit form data function starts
    // validate form function starts
    function validateForm(currentForm, formType){
        // hide any error messages starts
        $('.formValidationError').hide();
        $('.fieldHasError').removeClass('fieldHasError');
        var count=2;
        // hide any error messages ends
        $('#' + currentForm + ' .requiredField').each(function(i){
            if($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')){
                $(this).val($(this).attr('data-dummy'));
                $(this).focus();
                $(this).addClass('fieldHasError');
                $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                count=count-1;
                return false;
            };


        });
        if(formSubmitted == 'false' && count==2){
            submitData(currentForm, formType);
        };

    };
    // validate form function ends

    // contact button function starts
    $('#contactSubmitButton').click(function() {
        var flag2=validateForm($(this).attr('data-formId'));
        if(flag2==true)
            return true;
        return false;
    });
    // contact button function ends



});

/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*//////////////////// Document Ready Function Ends                                                                       */
/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
