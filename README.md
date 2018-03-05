#### react-native-pin-screen

A [pin-screen](https://support.google.com/nexus/answer/6118421?hl=en) like functionality for react-native (Android only).


## Usage
```javascript
import RNPinScreen from 'react-native-pin-screen';

// no lockscreen anymore - screen go off as usual (button press, idle mode)
RNPinScreen.pin()

// lockscreen comes back - if the device was previously idle, lock screen popup immediately
RNPinScreen.unpin()

```
