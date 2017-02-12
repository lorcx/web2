/**
 * Created by lx on 2017/2/1.
 */
(function () {
    window.Router = function () {
        var self = this;
        self.hashList = {};//路由表
        self.index = null;
        self.key = '!';

        // 当锚点改变时
        window.onhashchange = function () {
            self.reload();
        }
    };

    /**
     * 添加路由，如果路由存在则会覆盖
     * @param addr:地址
     * @param callback: 回掉函数
     */
    Router.prototype.add = function (addr, callback) {
        var self = this;
        self.hashList[addr] = callback;
    };

    /**
     * 删除路由
     * @param addr:地址
     */
    Router.prototype.remove = function (addr) {
        var self = this;
        delete self.hashList[addr];
    };

    /**
     * 设置主页
     * @param index:主页地址
     */
    Router.prototype.setIndex = function (index) {
        var self = index;
        self.index = index;
    };

    /**
     * 跳转到指定地址
     * @param addr:地址值
     */
    Router.prototype.go = function (addr) {
        var self = this;
        window.location.href = '#' + self.key + addr;
    }

    /**
     * 重载页面
     */
    Router.prototype.reload = function () {
        var self = this;
        var hash = window.location.hash.replace('#' + self.key, '');
        var addr = hash;
        var cb = getCb(addr, self.hashList);
        if (cb) {
            var arr = hash.split('/');
            arr.shift();// 移除数组第一个元素
            cb.apply(self, arr);
        } else {
            self.index && self.go(self.index);
        }
    };

    /**
     * 开始路由，实际上只是为了当直接访问路由地址的时候能够及时调用回调
     */
    Router.prototype.start = function () {
        var self = this;
        self.reload();
    };

    /**
     * 获取callback
     * @return false or callback
     */
    function getCb(addr, hashList) {
        for (var key in hashList) {
            if (key == addr) {
                return hashList[key];
            }
        }
        return false;
    }

})();