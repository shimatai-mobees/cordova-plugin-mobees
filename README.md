# Cordova Mobees Plugin

## Usage

Install the plugin

    $ cd mobees
    $ cordova plugin add https://github.com/shimatai-mobees/cordova-plugin-mobees.git
    

Edit `www/js/index.js` and add the following code inside `onDeviceReady`

```js
    mobees.isGpsEnabled((result) => {
        alert('Result isGpsEnabled: ' + result); // Result: true | false
    }, () => {
        alert("Error calling Mobees Plugin");
    });

    mobees.hasGpsPermission((result) => {
        alert('Result hasGpsPermission: ' + result); // Result: true | false
    }, () => {
        alert("Error calling Mobees Plugin");
    });

    mobees.requestGpsPermission((result) => {
        alert('Result requestGpsPermission: ' + result); // Retorno 'requested'
    }, () => {
        alert("Error calling Mobees Plugin");
    });

    mobees.isConnected((result) => {
        alert('Result isConnected: ' + result); // Result: true | false
    }, () => {
        alert("Error calling Mobees Plugin");
    });

    mobees.toast("Teste de toast nativo!", () => {}, () => {});

    mobees.hasNotificationPermission((result) => {
        alert('Result hasNotificationPermission: ' + result); // Result: true | false
    }, () => {
        alert("Error calling Mobees Plugin");
    });

    mobees.logout((result) => {
        alert('Result logout: ' + result);
    }, () => {
        alert("Error calling Mobees Plugin");
    });
```

Install iOS or Android platform

    cordova platform add ios
    cordova platform add android
    
Run the code

    cordova run 

## More Info

For more information on setting up Cordova see [the documentation](http://cordova.apache.org/docs/en/latest/guide/cli/index.html)

For more info on plugins see the [Plugin Development Guide](http://cordova.apache.org/docs/en/latest/guide/hybrid/plugins/index.html)
