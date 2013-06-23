$(function(){
    $('#btn_up').click(function() {
        $('html,body').animate({
            scrollTop:0
        }, 'slow');
    });

    $(window).scroll(function(){
        if($(window).scrollTop() < 500){
            $('#btn_up').fadeOut();
        }else{
            $('#btn_up').fadeIn();
        }
    });
    
    $("#titre").click(function(){
        var attrCssDisplay = $("#basket").css("display");
        if ( attrCssDisplay == "none"){
            $("#basket").slideDown(300);
            $("#triangle_gauche").css("display","none");
            $("#triangle_bas").css("display","block");
            $("#triangle_bas").css("top","10px");
        }else{
            $("#basket").slideUp(300);
            $("#triangle_bas").css("display","none");
            $("#triangle_gauche").css("display","block");
        }
    });
});

