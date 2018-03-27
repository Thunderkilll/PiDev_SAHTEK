/**
 * Created by émine on 16/04/2017.
 */

 function a($) {
    $(".panel-left").resizable({
        handleSelector: ".splitter",
        resizeHeight: true
    });

    $(".panel-top").resizable({
        handleSelector: ".splitter-horizontal",
        resizeWidth: false
    });

}
