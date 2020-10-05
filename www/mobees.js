/*global cordova, module*/

module.exports = {
    toast: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "toast", [name]);
    },
    isGpsEnabled: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "isGpsEnabled", []);
    },
    hasGpsPermission: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "isConnected", []);
    },
    requestGpsPermission: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "requestGpsPermission", []);
    },
    isConnected: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "isConnected", []);
    },
    setUser: function (cpf, authTk, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Mobees", "setUser", [cpf, authTk]);
    }
};
