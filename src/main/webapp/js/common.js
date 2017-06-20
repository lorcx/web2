/**
 * 获取当前系统的根路径
 */
function getContextPaht() {
    var location = window.location;
    var contextPath = location.pathname.split("/")[1];
    if (contextPath.indexOf(".") != -1) {
        return "";
    }
    return "/" + contextPath;
}