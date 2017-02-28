/**
 * Created by zw on 2017/1/13.
 */

/**/
$(document).ready(function(){
    $(".subMenu .ui-draggable").draggable({
        connectToSortable:".container-designer",
        helper: "clone",
        handle:".dragIcon",
        stop:function(event,t){
            $(".container-designer").sortable({
                opacity: .35,
                connectWith: ".container-designer"
            });
        }
    });
});