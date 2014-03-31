define("sea-libs/dropdown/1.0.0/dropdown-debug", [ "jquery-debug" ], function(require, exports, module) {
    var $ = require("jquery-debug");
    /**
     * dropDownButton jquery plugin that can simple simulator pop menu
     * and it always be used to website topheader pop dropdown menu Interactive experience.
     * dependency: jquery.1.4.2 +
     * create by terence tian
     * datatime:2012-11-13
     * issue: IE7 transparent bug: mouseleave/mouseover is triggering in IE7 while the cursor is still over the element
     * quick fix: we must set the background(the element that bind mouseleave/mouseout event) as "white" or having 1x1.gif as background.
     */
    // The default configurations.
    var defaults = {
        activeClass: "tn-active",
        timeout: 60,
        direction: "right"
    };
    /**
     * DropDownMenu class. eg. $elem=ddButton Object,options={list:$ddButtonList,topNav:$topNav}
     * @param {array} $elems  [jquery object]
     * @param {array} options [jquery selector list matched elems]
     */
    var DropdownButton = function($elem, options) {
        var cfg = $.extend({}, defaults, options);
        this.activeClass = cfg.activeClass;
        this.timeout = cfg.timeout;
        // Top Nav Selector
        this.$topNav = cfg.topNav;
        this.$ddButton = $elem;
        // Pop List Selector
        this.$ddList = cfg.list;
        // indicate the ddList container left justify of ddButton. 
        this.direction = cfg.direction;
        // give offset value used to adjust the positon of ddList when direction='left'. eg. 10 | -10
        this.offset = cfg.offset;
        // the callback function should be invoked while the dropdownbutton actived.
        this.callback = cfg.callback;
        return this;
    };
    DropdownButton.prototype = {
        init: function() {
            // init timer of current Dropdownbutton instance.
            this.timer = 0;
            // active
            this.active();
        },
        active: function() {
            var self = this;
            self.$ddButton.bind("mouseenter", function() {
                var $this = $(this), thisWidth = $this.width();
                if (self.timer) self.timer = clearTimeout(self.timer);
                // Add mouseenter active class on ddbutton.
                $this.addClass(self.activeClass);
                self.$ddList.css({
                    display: "block",
                    top: self.$topNav.height() + self.offset.y
                });
                // Diff with of ddButtom and ddList
                var ddListWidth = self.$ddList.width(), diffWidth = ddListWidth > thisWidth ? ddListWidth - thisWidth : 0;
                // Make sure that the with of $ddList > with of $ddbutton 
                self.$ddList.css({
                    width: thisWidth > ddListWidth ? thisWidth : ddListWidth
                });
                if (self.direction == "right") {
                    self.$ddList.addClass("d-right");
                    self.$ddList.css({
                        left: $this.offset().left - self.$topNav.offset().left + self.offset.x
                    });
                } else {
                    self.$ddList.addClass("d-left");
                    self.$ddList.css({
                        left: $this.offset().left - self.$topNav.offset().left - diffWidth + self.offset.x
                    });
                }
                // invoke callback function.
                if ($.isFunction(self.callback)) self.callback(self.$ddList);
            }).on("mouseleave", function() {
                self.timer = setTimeout(function() {
                    self.$ddButton.removeClass(self.activeClass);
                    self.$ddList.css({
                        display: "none"
                    });
                }, self.timeout);
            });
            // bind mouseenter,mouseleave event with $ddlist.
            self.$ddList.bind("mouseenter", function() {
                if (self.timer) self.timer = clearTimeout(self.timer);
            }).on("mouseleave", function() {
                self.timer = setTimeout(function() {
                    self.$ddButton.removeClass(self.activeClass);
                    self.$ddList.css({
                        display: "none"
                    });
                }, self.timeout);
            });
        }
    };
    module.exports = DropdownButton;
});
