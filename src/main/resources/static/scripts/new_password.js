var $ = jQuery.noConflict();
var formSubmitted = 'false';


jQuery(document).ready(function($) {

    $('#formSuccessMessageWrap').hide(0);
    $('#formFailureMessageWrap').hide(0);
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
        $.post($('#' + currentForm).attr('action'),formInput, function(data,status){
            if(data=="404") {
                $('#formFailureMessageWrap').fadeIn(500);
                formSubmitted = 'false';
                var onFocus = document.activeElement;
                if (onFocus.id === "contactEmailField") {
                    $('#formFailureMessageWrap').fadeOut(500);
                }
            }
            else if(data=="200"||data=="204")
                $('#formSuccessMessageWrap').fadeIn(500);
            window.setTimeout("window.location='/'",2000);
        });
        //window.location.href='1vali_psw.html';
    };
    // submit form data function starts
    // validate form function starts
    function validateForm(currentForm, formType){
        // hide any error messages starts
        $('.formValidationError').hide();
        $('.fieldHasError').removeClass('fieldHasError');
        var count=3;
        var judge=true;
        // hide any error messages ends
        $('#' + currentForm + ' .requiredField').each(function(i){
            if($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')){
                $(this).val($(this).attr('data-dummy'));
                $(this).focus();
                $(this).addClass('fieldHasError');
                $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                count=count-1;
                judge=false;
                return false;
            };

            if($('#contactNameField').val()!==$('#contactEmailField').val()){
                $('#differentError').fadeIn(300);
                count=count-1;
                return false;
            };


        });
        if(formSubmitted == 'false' && count==3&&judge==true){
            submitData(currentForm, formType);
        };

    };
    // validate form function ends

    // contact button function starts
    $('#contactSubmitButton').click(function() {
        var flag2=validateForm($(this).attr('data-formId'));
        if(flag2==true)
        {
            alert(flag2);
            return true;
        }
        return false;
    });
    // contact button function ends



});