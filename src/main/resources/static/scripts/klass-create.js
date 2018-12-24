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
         var formInput =  new FormData($('#' + currentForm)[0]);
        // var formInput = $('#' + currentForm).serialize();
        console.log(formInput);
        formInput.append("file", $('#excelUpload')[0].files[0]);
        console.log(formInput.get("file"));
        var courseId=$('#contactForm').attr("name");
        alert(courseId);
        $.ajax(
            {
                url:"/teacher/course/klass/create?courseId="+courseId,
                type:'post',
                processData: false,
                contentType: false,
                data:formInput,
                success:function(data,status,response){
                    if(response.status=="200"){
                        window.location.href="/teacher/course/klassList?courseId="+courseId;
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

    };
    // submit form data function starts
    // validate form function starts
    function validateForm(currentForm, formType){
        // hide any error messages starts
        $('.formValidationError').hide();
        $('.fieldHasError').removeClass('fieldHasError');
        var count=4;
        // hide any error messages ends
        $('#' + currentForm + ' .requiredField').each(function(i){
            if($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')){
                // $(this).val($(this).attr('data-dummy'));
                // $(this).focus();
                $(this).addClass('fieldHasError');
                $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                count=count-1;
                return false;
            };


        });
        if(formSubmitted == 'false' && count===4){
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