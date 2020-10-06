# Cordova Mobees Plugin

Simple plugin that returns your string prefixed with mobees.

Greeting a user with "Hello, world" is something that could be done in JavaScript. This plugin provides a simple example demonstrating how Cordova plugins work.

## Using

Create a new Cordova Project

    $ cordova create mobees br.com.mobees.app MyApp
    
Install the plugin

    $ cd mobees
    $ cordova plugin add https://github.com/shimatai-mobees/cordova-plugin-mobees.git
    

Edit `www/js/index.js` and add the following code inside `onDeviceReady`

```js
    let success = function(message) {
        alert(message);
    }

    let failure = function() {
        alert("Error calling Mobees Plugin");
    }

    mobees.toast("Hello world!", success, failure);
```

Install iOS or Android platform

    cordova platform add ios
    cordova platform add android
    
Run the code

    cordova run 

## More Info

For more information on setting up Cordova see [the documentation](http://cordova.apache.org/docs/en/latest/guide/cli/index.html)

For more info on plugins see the [Plugin Development Guide](http://cordova.apache.org/docs/en/latest/guide/hybrid/plugins/index.html)
