/*global cordova, module*/

module.exports = {
    greet: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "greet", [name]);
    },
    isGpsEnabled: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "isGpsEnabled", []);
    },
    isConnected: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "isConnected", []);
    }
};
