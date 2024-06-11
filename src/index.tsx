import { NativeModules, Platform, DeviceEventEmitter } from 'react-native';

const LINKING_ERROR =
  `The package 'diva-mobile-pax-scanner' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const DivaMobilePaxScanner = NativeModules.DivaMobilePaxScanner
  ? NativeModules.DivaMobilePaxScanner
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

const BARCODE_READ_SUCCESS = 'barcodeReadSuccess';

let isListenerAssigned = false;

export function multiply(a: number, b: number): Promise<number> {
  return DivaMobilePaxScanner.multiply(a, b);
}

DivaMobilePaxScanner.startReader = (handler: any) => {
  if (!isListenerAssigned) {
    // Initialize the Zebra scanner
    return DivaMobilePaxScanner.init().then(() => {
      // Subscribe to the BARCODE_READ_SUCCESS event
      if (
        DeviceEventEmitter.addListener(
          BARCODE_READ_SUCCESS,
          // Pass the event data to the specified handler function
          (data: any) => handler(data)
        )
      ) {
        isListenerAssigned = true;
      }
    });
  }
};

DivaMobilePaxScanner.stopReader = () => {
  if (isListenerAssigned) {
    // Finalize the Zebra scanner
    return DivaMobilePaxScanner.finalize().then(() => {
      // Unsubscribe from the event
      DeviceEventEmitter.removeAllListeners(BARCODE_READ_SUCCESS);
      isListenerAssigned = false;
    });
  }
};

export default DivaMobilePaxScanner;
