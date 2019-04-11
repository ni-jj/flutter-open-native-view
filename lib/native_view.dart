import 'dart:async';

import 'package:flutter/services.dart';

class NativeView {
  static const MethodChannel _channel = const MethodChannel('native_view');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future openActivity() async {
    var ret = await _channel.invokeMethod('openActivity');
    return ret;
  }
}
