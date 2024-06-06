
# react-native-diva-mobile-pax-scanner

## Getting started

`$ npm install react-native-diva-mobile-pax-scanner --save`

### Mostly automatic installation

`$ react-native link react-native-diva-mobile-pax-scanner`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-diva-mobile-pax-scanner` and add `RNDivaMobilePaxScanner.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDivaMobilePaxScanner.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNDivaMobilePaxScannerPackage;` to the imports at the top of the file
  - Add `new RNDivaMobilePaxScannerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-diva-mobile-pax-scanner'
  	project(':react-native-diva-mobile-pax-scanner').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-diva-mobile-pax-scanner/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-diva-mobile-pax-scanner')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNDivaMobilePaxScanner.sln` in `node_modules/react-native-diva-mobile-pax-scanner/windows/RNDivaMobilePaxScanner.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Diva.Mobile.Pax.Scanner.RNDivaMobilePaxScanner;` to the usings at the top of the file
  - Add `new RNDivaMobilePaxScannerPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNDivaMobilePaxScanner from 'react-native-diva-mobile-pax-scanner';

// TODO: What to do with the module?
RNDivaMobilePaxScanner;
```
  