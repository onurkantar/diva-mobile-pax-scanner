using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Diva.Mobile.Pax.Scanner.RNDivaMobilePaxScanner
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNDivaMobilePaxScannerModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNDivaMobilePaxScannerModule"/>.
        /// </summary>
        internal RNDivaMobilePaxScannerModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNDivaMobilePaxScanner";
            }
        }
    }
}
