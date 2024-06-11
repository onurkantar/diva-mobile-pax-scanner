
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDivaMobilePaxScannerSpec.h"

@interface DivaMobilePaxScanner : NSObject <NativeDivaMobilePaxScannerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface DivaMobilePaxScanner : NSObject <RCTBridgeModule>
#endif

@end
