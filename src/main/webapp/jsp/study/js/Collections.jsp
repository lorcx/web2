<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title></title>
</head>
<body>

</body>
<script type="text/javascript">
    function Map() {
        this.element = new Array();
        /**
         * 集合的个数
         * @returns {*}
         */
        this.size = function () {
            return this.element.length;
        };
        /**
         * 放入
         *  k ：key
         *  v : value
         */
        this.put = function (k, v) {
            if(this.get(k)){
                this.remove(k);
            }
            obj = {key: k, value: v};
            this.element.push(obj);
        };
        /**
         * 是否为空
         */
        this.isEmpty = function () {
            return this.size() == 0
        };
        /**
         * 获取
         * 出错就抛异常
         */
        this.get = function (k) {
            try {
                for (var i = 0; i < this.size(); i++) {
                    if (this.element[i].key == k) {
                        return this.element[i].value;
                    }
                }
            } catch (e) {
                return null;
            }
        };
        /**
         * 删除
         * @param e
         */
        this.remove = function (k) {
            var b = true;
            try {
                for (var i = 0; i < this.size(); i++) {
                    if (this.element[i].key == k) {
                        this.element.splice(i, 1);//删除
                        return true;
                    }
                }
            } catch (e) {
                b = false;
            }
            return b;
        }
    }
    var map = new Map();
    map.put('a', 'b');
    map.put('a', 'c');
//    map.remove('a');
    console.log(map);



</script>
</html>
