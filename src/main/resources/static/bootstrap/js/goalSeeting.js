
$(function () {
    $('.date').datetimepicker({
        minView: 3,
        format: 'yyyy-mm-dd',
    });
});
$(function () {
    $('.navbar-collapse a').click(function () {
        $('.navbar-collapse').collapse('hide');
    });
})
function checkradio(){
    alert("提交成功！✌耶！️")
    return true;
}