/**
 * Created by krzysztof-pawlowski on 28/03/15.
 */

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

$("#myModal").modal('show');

(function AdminViewModel() {

    var that = this;
    var eb = new vertx.EventBus(window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/eventbus');
    that.items = ko.observableArray([]);

    //eb.onopen = function() {
    //
    //    // Get the static data
    //
    //    eb.send('vertx.mongopersistor', {action: 'find', collection: 'albums', matcher: {} },
    //        function(reply) {
    //            if (reply.status === 'ok') {
    //                var albumArray = [];
    //                for (var i = 0; i < reply.results.length; i++) {
    //                    albumArray[i] = new Album(reply.results[i]);
    //                }
    //                that.albums = ko.observableArray(albumArray);
    //                ko.applyBindings(that);
    //            } else {
    //                console.error('Failed to retrieve albums: ' + reply.message);
    //            }
    //        });
    //};
    //
    //eb.onclose = function() {
    //    eb = null;
    //};

    that.username = ko.observable('');
    that.password = ko.observable('');
    that.loggedIn = ko.observable(false);
    that.sessionId = '';

    that.login = function() {
        if (that.username().trim() != '' && that.password().trim() != '') {
            eb.login(that.username(), that.password(), function (reply) {
                if (reply.status === 'ok') {
                    that.loggedIn(true);
                    that.sessionId = reply.sessionID;
                    setCookie(
                        "sessionId", reply.sessionID, 1
                    )
                    ko.applyBindings(that);
                } else {
                    alert('invalid login');
                }
            });
        }
    }

    that.logout = function() {
        eb.logout(that.sessionId, function (reply) {
            that.loggedIn(false);
            that.sessionId = '';
            that.username('');
            that.password('');
            ko.applyBindings(that);
        });
    }

    ko.applyBindings(that);

})();