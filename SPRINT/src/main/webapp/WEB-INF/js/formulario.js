$(document).ready(function(){    

    $("input[type='radio']").click(function(){
        switch(this.id){
            case "cliente":
                $("#Cliente").removeClass("oculto");
                $("#Profesional").addClass("oculto");
                $("#Administrativo").addClass("oculto");
                break;
            case "profesional":
                $("#Profesional").removeClass("oculto");
                $("#Cliente").addClass("oculto");
                $("#Administrativo").addClass("oculto");
                break;
            case "administrativo":
                $("#Administrativo").removeClass("oculto");
                $("#Cliente").addClass("oculto");
                $("#Profesional").addClass("oculto");
                break;
        }
    });
    
    $("#editar").click(function(){
	    $("input").prop("disabled", !$("input").prop("disabled"));
	    $("select").prop("disabled", !$("select").prop("disabled"));
	    $("input[name=rut]").prop("disabled", true);
	    $("input[name=dv]").prop("disabled", true);
        $("#editar").css("display", "none");
	});
});